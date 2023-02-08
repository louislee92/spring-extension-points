package com.example.extend;

import com.example.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.stereotype.Component;

/**
 * 自定义Bean工厂后置处理器
 * 在Bean实例化之前，对Bean工厂进行预处理
 */
@Slf4j
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("person");
//        beanDefinition.setScope("prototype");       // 设置作用域
        beanDefinition.setInitMethodName("init");   // 设置初始化方法
        beanDefinition.setDestroyMethodName("dest");    // 指定销毁方法
//        beanDefinition.setLazyInit(true);           // 设置懒加载
        log.info("【BeanFactoryPostProcessor.postProcessBeanFactory】【Bean实例化前】");
    }
}
