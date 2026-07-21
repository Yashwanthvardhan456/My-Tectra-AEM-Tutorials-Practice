package com.adobe.aem.demo.core.models.impl;

import com.adobe.aem.demo.core.models.DemoModel;
import com.adobe.aem.demo.core.service.DemoService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Model(adaptables = Resource.class,
        adapters = DemoModel.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class DemoModelImpl implements DemoModel {

    @OSGiService
    DemoService demoService;


    private static final Logger LOG = LoggerFactory.getLogger(DemoModelImpl.class);

    @ValueMapValue
    private String mytitle;

    @ValueMapValue
    private boolean isRegular;

    @ValueMapValue
    private String country;

    @ChildResource
    private List<DemoMultiModel> socialMedia;

    @Override
    public String getMyTitle() {
        LOG.info("getMyTitle Method Calling from sling model");
        return demoService.getTitle();
    }

    @Override
    public boolean getIsRegular() {
        return isRegular;
    }



    @Override
    public String getCountry() {
        LOG.info("Info Log");
        return country;
    }

    @Override
    public List<DemoMultiModel> getSocialMedia() {
        return socialMedia;
    }
}
