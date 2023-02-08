package com.example.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Data
@Slf4j
public class Person implements ApplicationContextAware, InitializingBean, DisposableBean {

    private ApplicationContext applicationContext;
    private String name;

    public void init() {
        log.info("【Bean的init方法】【初始化】");
    }

    @PostConstruct
    public void post() {
        log.info("【Bean的@PostConstrunct方法】【初始化】");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("【Bean的ApplicationContextAware接口】【初始化-Aware接口】");
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("【Bean的InitializingBean接口】【初始化-属性赋值后】{}", this);
    }

    @Override
    public void destroy() throws Exception {
        log.info("【Bean的DisposableBean接口】【销毁】{}", this);
    }
}
