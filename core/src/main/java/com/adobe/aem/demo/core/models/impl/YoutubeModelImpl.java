package com.adobe.aem.demo.core.models.impl;


import com.adobe.aem.demo.core.models.YoutubeModel;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

@Model(adaptables = Resource.class,
        adapters = YoutubeModel.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
) // this annotation can converts the java class as a sling model
public class YoutubeModelImpl implements YoutubeModel {

    @ValueMapValue
    private String videoId;

    @ValueMapValue
    private int videoNumber;

    @ValueMapValue
    private String videoDescription;


    @Override
    public String getVideoId() {
        return videoId;
    }

    @Override
    public int getVideoNumber() {

        return videoNumber;
    }

    public static final Logger log = LoggerFactory.getLogger(YoutubeModelImpl.class);

    @Override
    public String getVideoDescription() {
        log.trace("Info Log");
        log.debug("Debug Log");
        log.info("Info Log");
        log.warn("Warning Log");
        log.error("Error Log");
        return videoDescription;
    }


}
