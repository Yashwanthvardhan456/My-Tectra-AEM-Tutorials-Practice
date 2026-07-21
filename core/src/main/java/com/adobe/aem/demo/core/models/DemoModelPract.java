package com.adobe.aem.demo.core.models;

import com.adobe.aem.demo.core.models.impl.DemoMultiModelPract;

import java.util.List;

public interface DemoModelPract {
    public boolean getIsRegular();
    public String getCountry();
    public List<DemoMultiModelPract> getSocialMedia();
}
