package com.adobe.aem.demo.core.workflows;

import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.day.cq.workflow.WorkflowException;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.Session;

@Component(service = WorkflowProcess.class,
        property = {
        "process.label=Yashwanth Workflow"
        }

)
public class DemoWorkflow implements WorkflowProcess {

    private static final Logger log = LoggerFactory.getLogger(DemoWorkflow.class);
    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) throws com.adobe.granite.workflow.WorkflowException {


        try {
            log.info("Workflow has been Triggered");
            String payload = workItem.getWorkflowData().getPayload().toString();
            Session session = workflowSession.adaptTo(Session.class);
            // Access the page's jcr:content node
            Node contentNode = session.getNode(payload + "/jcr:content");
            // Update properties
            contentNode.setProperty("reviewStatus", "Reviewed");
            contentNode.setProperty("reviewedBy", "workflow");
            contentNode.setProperty("reviewedOn", java.util.Calendar.getInstance());
            session.save();
        } catch (Exception e) {
            log.error(e.getMessage());;
        }

    }
}
