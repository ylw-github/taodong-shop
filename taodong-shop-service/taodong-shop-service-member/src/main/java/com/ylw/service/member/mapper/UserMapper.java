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
}
