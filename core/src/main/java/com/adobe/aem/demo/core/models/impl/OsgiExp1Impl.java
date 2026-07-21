package com.adobe.aem.demo.core.models.impl;


import com.adobe.aem.demo.core.models.OsgiExp1;
import com.adobe.aem.demo.core.service.OsgiEx1;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Model(adaptables = Resource.class,
        adapters = OsgiExp1.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class OsgiExp1Impl implements OsgiExp1 {

    @OSGiService
    OsgiEx1 osgiex1;

    private static final Logger log = LoggerFactory.getLogger(OsgiExp1Impl.class);

    @ValueMapValue
    @Default (values = "Default")
    private String videoId;

    @Override
    public String getTitle() {
        log.info("Osgi Method Triggered form sling model");
        return osgiex1.getTitlee();
    }
}
