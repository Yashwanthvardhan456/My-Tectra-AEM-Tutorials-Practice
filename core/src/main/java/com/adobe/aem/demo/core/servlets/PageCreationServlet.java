package com.adobe.aem.demo.core.servlets;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class,
        property = {
        "sling.servlet.paths=/bin/pageCreation",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET
        }
)
public class PageCreationServlet extends SlingAllMethodsServlet {
    private static final Logger log = LoggerFactory.getLogger(PageCreationServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException{

        log.info("Page creation Servlet");

        String templatePath = request.getParameter("templatePath");
        String pageTitle = request.getParameter("pageTitle");
        String pageName = request.getParameter("pageName");
        String parentPagePath = request.getParameter("parentPagePath");

        ResourceResolver resourceResolver = request.getResourceResolver();
        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
        try{


            Page page = pageManager.create(parentPagePath,pageName,templatePath,pageTitle);

            resourceResolver.commit();

            log.info("Page created Succefully");

        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
