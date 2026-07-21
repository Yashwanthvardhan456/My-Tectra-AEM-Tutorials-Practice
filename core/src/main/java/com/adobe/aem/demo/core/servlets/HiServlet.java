package com.adobe.aem.demo.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

@Component(service = Servlet.class,
            property = {
            "sling.servlet.paths=/bin/binty",
            "sling.servlet.methods=" + HttpConstants.METHOD_GET
            }
)
public class HiServlet extends SlingSafeMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(HiServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException{
        log.info("HiServlet calling from servlet");

        String name = request.getParameter("name");
                if (name == null) name = "Default";

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Hello Iam "+name+ " Iam an AEM Developer");

    }

}
