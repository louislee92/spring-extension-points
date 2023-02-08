package com.example.extend;

import com.example.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

@Slf4j
@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    /**
     * 实例化之前调用，可以实现该方法直接使用自定义逻辑返回一个定制化的bean；
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) {
        if(beanClass.equals(Person.class)) {
            log.info("【Bean的InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation】【实例化前】");
            // 返回定制化的bean会导致MyBeanPostProcessor的postProcessBeforeInitialization方法跳过
//            Person p = new Person();
//            p.setName("大卫天龙");
//            return p;
        }
        return null;
    }


    /**
     * 在bean实例化对象之后，属性值填充之前会被调用。这个时候
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if(bean instanceof Person)
            log.info("【Bean的InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation】【实例化后】");
        return true;
    }

    /**
     * 在bean实例化对象完成之后，首先会执行populateBean方法填充bean的属性【按照名称或者类型】，
     * 然后会执行该方法进行自定义属性的依赖注入
     * 使用该方法可以完成bean中一些自定义属性的解析【例如解析标注某些自定义注解的属性】；
     * 注意：该方法是Spring5.1中新增的方法，5.1之前使用的是postProcessProperties方法
     */
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if(bean instanceof Person)
            log.info("【Bean的InstantiationAwareBeanPostProcessor.postProcessProperties】【实例化后，填充属性】");
        return null;
    }

    /**
     * Spring5.1之前使用的方法，目前5.1版本已经过时，也是用来解析bean中的一些自定义属性
     */
    /** @deprecated */
    @Deprecated
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        return pvs;
    }
}
