package com.example.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class NotifyTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    @PostConstruct
    public void init() {
        NotifyEvent event = new NotifyEvent("object", "abc@qq.com", "This is the content");
        webApplicationContext.publishEvent(event);
        log.info("已触发事件");
    }
}
