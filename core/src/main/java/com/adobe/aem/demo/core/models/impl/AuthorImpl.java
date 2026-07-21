package com.adobe.aem.demo.core.models.impl;


import com.adobe.aem.demo.core.models.Author;
import com.adobe.aem.demo.core.service.TestService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = Author.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class AuthorImpl implements Author{

    @OSGiService
    TestService testService;

    private static final Logger log = LoggerFactory.getLogger(AuthorImpl.class);

    @Inject
    private String mytitle;

    @Inject
    @Default (values = "AEM")
    private String fname;

    @Inject
    @Required
    @Default (values = "Geeks")
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
    public boolean getIsProfessor() {
        return professor;
    }

    @Override
    public String getTestTitle() {
        log.info("getTitle Method Calling from sling model");
        return testService.getTestTit();
    }


}
