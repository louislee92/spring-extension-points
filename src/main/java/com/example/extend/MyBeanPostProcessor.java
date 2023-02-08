package com.example.extend;

import com.example.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * 自定义Bean后置处理器
 * 支持在Bean初始化前、初始化后对bean进行处理
 */
@Slf4j
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        if (bean instanceof Person) {
            log.info("【BeanPostProcessor.postProcessBeforeInitialization】【Bean初始化前】person");
            ((Person) bean).setName("张三");
        }
        // 返回原对象，或者包装为代理对象
        return bean;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Person) {
            log.info("【BeanPostProcessor.postProcessAfterInitialization】【Bean初始化后】person");
            ((Person) bean).setName("李四");
        }
        // 返回原对象，或者包装为代理对象
        return bean;
    }
}
