package com.ylw.service.member.mapper;

import com.ylw.service.member.mapper.entity.UserDo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

/**
 * description: 用户mapper
 * create by: YangLinWei
 * create time: 2020/2/21 3:21 下午
 */
public interface UserMapper {

	@Insert("INSERT INTO `user` VALUES (null,#{mobile}, #{email}, #{password}, #{userName}, null, null, null, '1', null, null, null);")
	int register(UserDo userEntity);

	@Select("SELECT * FROM user WHERE MOBILE=#{mobile};")
	UserDo existMobile(@Param("mobile") String mobile);

	@Select("SELECT USER_ID AS USERID ,MOBILE AS MOBILE,EMAIL AS EMAIL,PASSWORD AS PASSWORD, USER_NAME AS USER_NAME ,SEX AS SEX ,AGE AS AGE ,CREATE_TIME AS CREATETIME,IS_AVALIBLE AS ISAVALIBLE,PIC_IMG AS PICIMG,QQ_OPENID AS QQOPENID,WX_OPENID AS WXOPENID "
			+ "  FROM user  WHERE MOBILE=#{0} and password=#{1};")
	UserDo login(@Param("mobile") String mobile, @Param("password") String password);

	@Select("SELECT USER_ID AS USERID ,MOBILE AS MOBILE,EMAIL AS EMAIL,PASSWORD AS PASSWORD, USER_NAME AS userName ,SEX AS SEX ,AGE AS AGE ,CREATE_TIME AS CREATETIME,IS_AVALIBLE AS ISAVALIBLE,PIC_IMG AS PICIMG,QQ_OPENID AS QQOPENID,WX_OPENID AS WXOPENID"
			+ " FROM user WHERE user_Id=#{userId}")
	UserDo findByUserId(@Param("userId") Long userId);

}
