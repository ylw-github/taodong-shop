package com.ylw.service.pay.factory;

import com.ylw.service.pay.strategy.PaymentCompensationStrategy;
import org.apache.commons.lang.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * description: 对账策略者工厂
 * create by: YangLinWei
 * create time: 2020/5/19 9:31 上午
 */
public class CompensationStrategyFactory {
    private static Map<String, PaymentCompensationStrategy> strategyBean = new ConcurrentHashMap<String, PaymentCompensationStrategy>();

    public static PaymentCompensationStrategy getPaymentCompensationStrategy(String classAddres) {
        try {
            if (StringUtils.isEmpty(classAddres)) {
                return null;
            }
            PaymentCompensationStrategy beanPaymentCompensationStrategy = strategyBean.get(classAddres);
            if (beanPaymentCompensationStrategy != null) {
                return beanPaymentCompensationStrategy;
            }
            // 1.使用Java的反射机制初始化子类
            Class<?> forName = Class.forName(classAddres);
            // 2.反射机制初始化对象
            PaymentCompensationStrategy payStrategy = (PaymentCompensationStrategy) forName.newInstance();
            strategyBean.put(classAddres, payStrategy);
            return payStrategy;
        } catch (Exception e) {
            return null;
        }

    }
}
