package com.adobe.aem.demo.core.models;

import com.adobe.aem.demo.core.models.impl.DemoMultiModel;

import java.util.List;

public interface DemoModel {

    public String getMyTitle();

    public boolean getIsRegular();

    public String getCountry();

    public List<DemoMultiModel> getSocialMedia();
}
