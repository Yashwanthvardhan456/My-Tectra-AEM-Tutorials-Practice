package com.adobe.aem.demo.core.service.impl;

import com.adobe.aem.demo.core.models.impl.DemoModelImpl;
import com.adobe.aem.demo.core.service.DemoService;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = DemoService.class, immediate = true)
public class DemoServiceImpl implements DemoService{

    private String text = "Coming from OSGI Service";

    private static final Logger log = LoggerFactory.getLogger(DemoModelImpl.class);
    @Override
    public String getTitle() {
        log.info("Get Title Method Triggered");
        return text;
    }
}
