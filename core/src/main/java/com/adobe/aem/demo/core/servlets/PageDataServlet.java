package com.adobe.aem.demo.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class,
        property = {
                "sling.servlet.resourceTypes=demo/components/page",
                "sling.servlet.methods=GET",
                "sling.servlet.extensions=json"
        }
)

public class PageDataServlet extends SlingSafeMethodsServlet {

    private static final Logger log =
            LoggerFactory.getLogger(PageDataServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request,
                         SlingHttpServletResponse response)
            throws ServletException, IOException {

        log.info("ResourceType Servlet Called");

        String pagePath = request.getResource().getPath();

        response.setContentType("application/json");
        response.getWriter().write(
                "{ \"message\": \"Success\", \"path\": \"" + pagePath + "\" }"
        );
    }
}