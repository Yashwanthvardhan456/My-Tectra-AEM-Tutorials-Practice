package com.adobe.aem.demo.core.service.impl;

import com.adobe.aem.demo.core.service.OsgiEx1;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;


@Component(service = OsgiEx1.class, immediate = true)
@Designate(ocd = PractBundleConfig.class)
public class OsgiEx1Impl implements OsgiEx1 {

    private String studentName;
    private boolean isRegularStudent;
    private String studentId;
    private String[] studentSubjects;
    private String studentClass;

    private String text = "This is coming from OSGI EX 1";

    private static final Logger log = LoggerFactory.getLogger(OsgiEx1Impl.class);

    @Activate
    public void activate(PractBundleConfig practBundleConfig){
        studentName = practBundleConfig.getStudentName();
        isRegularStudent = practBundleConfig.getIsRegularStudent();
        studentId = practBundleConfig.getStudentId();
        studentSubjects = practBundleConfig.getStudentSubjects();

        log.info("Student Name: {}, Is Regular Student: {}, Student Id: {}, Student Subjects: {}",studentName, isRegularStudent,studentId, Arrays.toString(studentSubjects),studentClass);


    }

    @Override
    public String getTitlee() {
        log.info("Get Title method from osgi service method triggered");
        return text;
    }
}
