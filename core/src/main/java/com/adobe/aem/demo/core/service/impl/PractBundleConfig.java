package com.adobe.aem.demo.core.service.impl;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

@ObjectClassDefinition(name = "Practice Osgi Configuration", description = "Osgi configuration Practice")
public @interface PractBundleConfig {

    @AttributeDefinition(name = "Student Name", type = AttributeType.STRING, description = "Name of the Student")
    public String getStudentName();

    @AttributeDefinition(name = "Is Regular Student", type = AttributeType.BOOLEAN, description = "Is he a Regular Student")
    public boolean getIsRegularStudent();

    @AttributeDefinition(name = "Student Id", type = AttributeType.PASSWORD, description = "Enter Student ID Number")
    public String getStudentId();

    @AttributeDefinition(name = "Subjects List", type = AttributeType.STRING, description = "List of the Subjects")
    public String[] getStudentSubjects() default {"Telugu","Hindi","English"};

    @AttributeDefinition(name = "Class Name", type = AttributeType.STRING, description = "Class name of the Student", options = {
            @Option(label = "10th class", value = "10"),
            @Option(label = "9th class", value = "9")
    })
    public String getStudentClass();
}
