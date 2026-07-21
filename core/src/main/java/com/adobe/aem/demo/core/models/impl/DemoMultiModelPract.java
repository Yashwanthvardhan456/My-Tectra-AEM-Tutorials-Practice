package com.adobe.aem.demo.core.models.impl;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class DemoMultiModelPract {
    @ValueMapValue
    private String socialMediaIcon;

    @ValueMapValue
    private String socialMediaAccount;

    @ValueMapValue
    private String altText;

    @ValueMapValue
    private String extraField;

    public String getSocialMediaIcon(){
        return socialMediaIcon;
    }

    public String getSocialMediaAccount(){
        return socialMediaAccount;
    }

    public String getAltText(){
        return altText;
    }

    public String getExtraField(){
        return extraField;
    }
}
