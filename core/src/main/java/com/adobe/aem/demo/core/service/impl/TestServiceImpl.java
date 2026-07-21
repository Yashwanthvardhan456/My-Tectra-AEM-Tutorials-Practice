package com.adobe.aem.demo.core.service.impl;


import com.adobe.aem.demo.core.service.TestService;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Component(service = TestService.class)
public class TestServiceImpl implements TestService{

    private String text = "Coming from OSGI Service";

    private static final Logger log = LoggerFactory.getLogger(TestServiceImpl.class);

    @Override
    public String getTestTit() {
        log.info("Get Title Triggered");
        return text;
    }
}
