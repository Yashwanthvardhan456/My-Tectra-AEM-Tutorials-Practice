package com.adobe.aem.demo.core.models.impl;

import com.adobe.aem.demo.core.models.DemoModelPract;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = Resource.class,
        adapters = DemoModelPract.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class DemoModelImplPract implements DemoModelPract {

    @ValueMapValue
    private Boolean isRegular;

    @ValueMapValue
    private String country;

    @ChildResource
    private List<DemoMultiModelPract> socialMedia;

    @Override
    public boolean getIsRegular() {
        return isRegular;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public List<DemoMultiModelPract> getSocialMedia() {
        return socialMedia;
    }
}
