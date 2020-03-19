package com.ylw.service.member.impl;


import com.ylw.api.member.dto.output.UserOutDTO;
import com.ylw.common.web.core.api.BaseApiService;
import com.ylw.common.web.core.constants.Constants;
import com.ylw.common.web.core.entity.BaseResponse;
import com.ylw.common.web.core.util.BeanUtils;
import com.ylw.common.web.core.util.GenerateToken;
import com.ylw.common.web.core.util.TypeCastHelper;
import com.ylw.service.api.member.MemberService;
import com.ylw.service.member.mapper.UserMapper;
import com.ylw.service.member.mapper.UserTokenMapper;
import com.ylw.service.member.mapper.entity.UserDo;
import com.ylw.service.member.mapper.entity.UserTokenDo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MemberServiceImpl extends BaseApiService<UserOutDTO> implements MemberService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserTokenMapper userTokenMapper;


    @Override
    public BaseResponse<UserOutDTO> existMobile(String mobile) {
        /*if (true) {
            throw new RuntimeException("抛出个自定义的异常，6666666");
        }*/
        // 1.验证参数
        if (StringUtils.isEmpty(mobile)) {
            return setResultError("手机号码不能为空!");
        }

        // 2.根据手机号码查询用户信息 单独定义code 表示是用户信息不存在把
        UserDo userEntity = userMapper.existMobile(mobile);
        if (userEntity == null) {
            return setResultError(Constants.HTTP_RES_CODE_EXISTMOBILE_203, "用户信息不存在!");
        }
        // 3.将do转换成dto
        return setResultSuccess(BeanUtils.doToDto(userEntity, UserOutDTO.class));
    }

    @Override
    public BaseResponse<UserOutDTO> getInfo(String token) {

        UserTokenDo userTokenDo = userTokenMapper.selectByToken(token);
        if(userTokenDo == null){
            return setResultError("该用户没有登录!");
        }

        UserDo userDo = userMapper.findByUserId(userTokenDo.getUserId());
        if (userDo == null) {
            return setResultError("用户不存在!");
        }
        // 下节课将 转换代码放入在BaseApiService
        return setResultSuccess(BeanUtils.doToDto(userDo, UserOutDTO.class));
    }

}
