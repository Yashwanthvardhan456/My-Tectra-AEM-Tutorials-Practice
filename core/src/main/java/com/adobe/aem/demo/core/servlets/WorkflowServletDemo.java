package com.adobe.aem.demo.core.servlets;

import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.model.WorkflowModel;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
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
                "sling.servlet.paths=/bin/yash",
                "sling.servlet.methods=" + HttpConstants.METHOD_GET
            }
)
public class WorkflowServletDemo extends SlingSafeMethodsServlet {
    private static final Logger LOG = LoggerFactory.getLogger(WorkflowServletDemo.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)throws ServletException, IOException{
        String status = "Workflow Executing";

        final ResourceResolver resourceResolver = request.getResourceResolver();
        String payload = request.getParameter("page").toString();
        try {
            if(StringUtils.isNotBlank(payload)) {
                WorkflowSession workflowSession = resourceResolver.adaptTo(WorkflowSession.class);
                WorkflowModel workflowModel = workflowSession.getModel("/var/workflow/models/workflow-test");
                WorkflowData workflowData = workflowSession.newWorkflowData("JCR_PATH", payload);
                status = workflowSession.startWorkflow(workflowModel, workflowData).getState();
            }

        }catch (Exception e){
            LOG.info("\n Error in Workflow {} "+ e.getMessage());
        }
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("Workflow Status: " + status);

    }

}
