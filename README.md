# spring-extention-points
spring常用扩展点


# Bean的生命周期

1. 初始化容器
2. 加载BeanFactoryPostProcessor实现类
3. 执行BeanFactoryPostProcessor的postProcessBeanFactory方法
4. 加载BeanPostProcessor实现类
5. 实例化业务Bean
6. Aware接口族调用
7. 执行BeanPostProcessor实现类的postProcessBeforeInitialization方法
8. 执行InitializingBean实现类的afterPropertiesSet方法
9. 执行bean的init-method属性指定的初始化方法
10. 执行BeanPostProcessor实现类的postProcessAfterInitialization方法
11. 初始化完毕
12. 关闭容器，执行DisposableBean实现类的destroy方法
13. 执行bean的destroy-method属性指定的方法