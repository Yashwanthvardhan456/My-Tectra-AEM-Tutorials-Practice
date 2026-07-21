package com.adobe.aem.demo.core.servlets;

import com.day.cq.workflow.WorkflowService;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkflowData;
import com.day.cq.workflow.model.WorkflowModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

//AEM as cloud
//R7 Annotations
//@Component(service = Servlet.class)
//@SlingServletPaths("/bin/yl")

@Component(service = Servlet.class,
        property = {
        "sling.servlet.paths=/bin/yl",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET
        }
)

public class DemoServlet extends SlingAllMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(DemoServlet.class);

    @Reference
    WorkflowService workflowService;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException{
        log.info("Demo Servlet Get Method Called");

//        String pagePath = request.getParameter("pagePath");

        String payloadPath = request.getParameter("payloadPath");

        try{

        ResourceResolver resolver = request.getResourceResolver();
//        Resource resource = resolver.getResource(pagePath + "/jcr:content");
//        log.info(resource.getPath());
//        log.info(resource.getName());
//        log.info(resource.getValueMap().get("pageTitle").toString());
//
////        String age = request.getParameter("age");
//        response.setContentType("text/html");
//        response.setCharacterEncoding("UTF-8");
//        PrintWriter out = response.getWriter();
//        out.println("Hi " + pagePath + " Welcome to Aem training");
////        out.println("Hi your age is " +age+ " This Demo Servlet");


            if(payloadPath != null || !payloadPath.isEmpty()) {

                Session session = resolver.adaptTo(Session.class);
                WorkflowSession workflowSession = workflowService.getWorkflowSession(session);
                WorkflowModel model = workflowSession.getModel("/var/workflow/models/yl");
                WorkflowData data = workflowSession.newWorkflowData("JCR_PATH", payloadPath);
                workflowSession.startWorkflow(model, data);

                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.println("Your workflow "+ payloadPath+ " Successfully Triggered");

            }else {
                log.error("Please pass the payload path");
                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.println("Please pass the payload path");
            }
        }catch (Exception e){
            log.error("Error"+e.getMessage());
        }
    }
}
