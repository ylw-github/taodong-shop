package com.ylw.service.member.impl;

import com.alibaba.fastjson.JSONObject;
import com.ylw.api.member.dto.intput.UserLoginInDTO;
import com.ylw.common.web.core.api.BaseApiService;
import com.ylw.common.web.core.constants.Constants;
import com.ylw.common.web.core.entity.BaseResponse;
import com.ylw.common.web.core.util.GenerateToken;
import com.ylw.common.web.core.util.MD5Util;
import com.ylw.common.web.core.util.RedisDataSoureceTransaction;
import com.ylw.service.api.member.MemberLogOutService;
import com.ylw.service.api.member.MemberLoginService;
import com.ylw.service.member.mapper.UserMapper;
import com.ylw.service.member.mapper.UserTokenMapper;
import com.ylw.service.member.mapper.entity.UserDo;
import com.ylw.service.member.mapper.entity.UserTokenDo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberLogOutServiceImpl extends BaseApiService<JSONObject> implements MemberLogOutService {

    @Autowired
    private GenerateToken generateToken;

    @Autowired
    private UserTokenMapper userTokenMapper;

    /**
     * 手动事务工具类
     */
    @Autowired
    private RedisDataSoureceTransaction manualTransaction;

    @Override
    public BaseResponse<JSONObject> logout(String token) {
        TransactionStatus transactionStatus = null;
        try {
            transactionStatus = manualTransaction.begin();
            //2.删除Redis
            generateToken.removeToken(token);
            //1.首先更新数据库
            int updateTokenAvailability = userTokenMapper.updateTokenAvailability(token);
            if (updateTokenAvailability < 0) {
                manualTransaction.rollback(transactionStatus);
                return setResultError("系统错误");
            }
            manualTransaction.commit(transactionStatus);
            JSONObject data = new JSONObject();
            data.put("result", true);
            return setResultSuccess(data);
        } catch (Exception e) {
            try {
                // 回滚事务
                manualTransaction.rollback(transactionStatus);
            } catch (Exception e1) {
            }
            return setResultError("系统错误!");
        }
    }
}
