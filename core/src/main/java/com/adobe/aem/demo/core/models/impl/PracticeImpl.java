package com.adobe.aem.demo.core.models.impl;


import com.adobe.aem.demo.core.models.Practice;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
       adapters = Practice.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class PracticeImpl implements Practice{

    @Inject
    @Default (values = "Binty")
    private String fname;

    @Inject
    @Required
    @Default (values = "Practice")
    private String lname;

    @Inject
    private boolean professor;

    @Override
    public String getFirstName() {
        return fname;
    }

    @Override
    public String getLastName() {
        return lname;
    }

    @Override
    public boolean getIsprofessor() {
        return professor;
    }
}
