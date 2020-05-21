package com.ylw.service.auth.mapper;

import com.ylw.service.auth.mapper.entity.AppInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AppInfoMapper {


	@Insert("INSERT INTO `app_info`(`ID`, `APP_NAME`, `APP_ID`, `APP_SECRET`, `AVAILABILITY`) VALUES (NULL, #{appName},  #{appId}, #{appSecret}, '0');")
    public int insertAppInfo(AppInfo appInfo);

	@Select("SELECT ID AS ID ,app_id as appId, app_name AS appName ,app_secret as appSecret  FROM app_info where app_id=#{appId} and app_secret=#{appSecret}; ")
	public AppInfo selectByAppInfo(@Param("appId") String appId, @Param("appSecret") String appSecret);

	@Select("SELECT ID AS ID ,app_id as appId, app_name AS appName ,app_secret as appSecret  FROM app_info where app_id=#{appId}  ")
	public AppInfo findByAppInfo(@Param("appId") String appId);
}
