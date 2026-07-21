package com.adobe.aem.demo.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class,property = {
        "sling.servlet.resourceTypes=demo/components/yashLeela/youtubevideo",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.selectors=yl",
        "sling.servlet.extensions=html"
})

// R7 Annotations
//@Component(service = Servlet.class)
//SlingServletResourceTypes(
//        resourceTypes="demo/components/page",
//        methods = "GET",
//        selectors = "yl",
//        extensions = "html"
//)
public class ResourceTypeSevletExp extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.getWriter().println("<h1>Hello World</h1>");
    }
}
