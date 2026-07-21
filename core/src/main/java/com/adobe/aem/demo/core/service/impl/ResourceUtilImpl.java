package com.adobe.aem.demo.core.service.impl;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.HashMap;
import java.util.Map;

@Component(service = ResourceUtilImpl.class)
public class ResourceUtilImpl{

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    public ResourceResolver getResolver() throws LoginException{
        Map<String, Object> Obj = new HashMap<>();
        Obj.put(ResourceResolverFactory.SUBSERVICE, "YL");
        return resourceResolverFactory.getServiceResourceResolver(Obj);
    }
}
