package com.adobe.aem.demo.core.models.impl;

import com.adobe.aem.demo.core.models.Author2;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;

import javax.inject.Inject;


@Model(adaptables = Resource.class,
        adapters = Author2.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

public class AuthorImpl2 implements Author2 {

    @Inject
    @Default (values = "AEM")
    private String fname;

    @Inject
    @Required
    @Default (values = "Geeks")
    private String lname;

    @Inject
    boolean professor;

    @Override
    public String getFirstName() {
        return fname;
    }

    @Override
    public String getLastName() {
        return lname;
    }

    @Override
    public boolean getIsProfessor() {
        return professor;
    }
}
