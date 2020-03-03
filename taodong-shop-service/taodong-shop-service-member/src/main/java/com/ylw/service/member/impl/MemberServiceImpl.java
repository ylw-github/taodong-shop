package com.ylw.service.member.impl;


import com.ylw.api.member.dto.output.UserOutDTO;
import com.ylw.common.core.api.BaseApiService;
import com.ylw.common.core.constants.Constants;
import com.ylw.common.core.entity.BaseResponse;
import com.ylw.common.core.util.BeanUtils;
import com.ylw.common.core.util.GenerateToken;
import com.ylw.common.core.util.TypeCastHelper;
import com.ylw.service.api.member.MemberService;
import com.ylw.service.member.mapper.UserMapper;
import com.ylw.service.member.mapper.entity.UserDo;
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
    private GenerateToken generateToken;


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
        // 1.验证token参数
        if (StringUtils.isEmpty(token)) {
            return setResultError("token不能为空!");
        }
        // 2.使用token查询redis 中的userId
        String redisUserId = generateToken.getToken(token);
        if (StringUtils.isEmpty(redisUserId)) {
            return setResultError("token已经失效或者token错误!");
        }
        // 3.使用userID查询 数据库用户信息
        Long userId = TypeCastHelper.toLong(redisUserId);
        UserDo userDo = userMapper.findByUserId(userId);
        if (userDo == null) {
            return setResultError("用户不存在!");
        }
        // 下节课将 转换代码放入在BaseApiService
        return setResultSuccess(BeanUtils.doToDto(userDo, UserOutDTO.class));
    }

}
