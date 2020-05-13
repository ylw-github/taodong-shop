package com.ylw.common.web.core.api;
import com.ylw.common.web.core.constants.Constants;
import com.ylw.common.web.core.entity.BaseResponse;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * description: 统一返回code信息
 * create by: YangLinWei
 * create time: 2020/2/20 11:48 上午
 */
@Data
@Component
public class BaseApiService<T> {

	public BaseResponse<T> setResultError(Integer code, String msg) {
		return setResult(code, msg, null);
	}

	// 返回错误，可以传msg
	public BaseResponse<T> setResultError(String msg) {
		return setResult(Constants.HTTP_RES_CODE_500, msg, null);
	}

	// 返回成功，可以传data值
	public BaseResponse<T> setResultSuccess(Object data) {
		return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, data);
	}

	// 返回成功，沒有data值
	public BaseResponse<T> setResultSuccess() {
		return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, null);
	}

	// 返回成功，沒有data值
	public BaseResponse<T> setResultSuccess(String msg) {
		return setResult(Constants.HTTP_RES_CODE_200, msg, null);
	}

	// 通用封装
	public BaseResponse<T> setResult(Integer code, String msg, Object data) {
		return new BaseResponse(code, msg, data);
	}

	// 调用数据库层判断
	public Boolean toDaoResult(int result) {
		return result > 0 ? true : false;
	}

	// 接口直接返回true 或者false
	public Boolean isSuccess(BaseResponse<?> baseResp) {
		if (baseResp == null) {
			return false;
		}
		if (baseResp.getCode().equals(Constants.HTTP_RES_CODE_500)) {
			return false;
		}
		return true;
	}

}
