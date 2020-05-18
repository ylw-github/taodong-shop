package com.ylw.service.pay.mapper;

import com.ylw.service.pay.mapper.entity.PaymentTransactionLogEntity;
import org.apache.ibatis.annotations.Insert;

public interface PaymentTransactionLogMapper {

	@Insert("INSERT INTO `payment_transaction_log`(`ID`, `SYNCH_LOG`, `ASYNC_LOG`, `CHANNEL_ID`, `TRANSACTION_ID`, `REVISION`, `CREATED_BY`, `CREATED_TIME`, `UPDATED_BY`, `UPDATED_TIME`) VALUES (NULL, NULL, #{asyncLog}, NULL, #{transactionId}, NULL, NULL,  NOW(),  NULL, NOW());")
	public int insertTransactionLog(PaymentTransactionLogEntity paymentTransactionLog);
}
