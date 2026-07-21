package com.adobe.aem.demo.core.service.impl;

import org.apache.jackrabbit.spi.QValue;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

@ObjectClassDefinition(name = "YL First Test Configuration", description = "Testing Configuration for yash and leela")
public @interface BundleTestConfiguration {

    @AttributeDefinition(name = "Student Name",type = AttributeType.STRING, description = "Enter the Student Name")
    public String getStudentName() default "Yashwanth";

    @AttributeDefinition(name = "Student Age",type = AttributeType.INTEGER, description = "Enter the Student Age")
    public int getStudentAge() default 25;

    @AttributeDefinition(name = "Regular Student", type = AttributeType.BOOLEAN, description = "Is Student Regular?")
    public boolean getIsRegular() default true;

    //Array
    @AttributeDefinition(name = "Student Subjects", type = AttributeType.STRING, description = "Provide Student Subjects")
    public String[] getStudentSubjects() default {"Telugu", "English"};

    @AttributeDefinition(name = "Student Pan", type = AttributeType.PASSWORD, description = "Enter Student PAN Card")
    public String getStudentPan();

    //List
    @AttributeDefinition(name = "Select Student Class", type = AttributeType.STRING, description = "Select Student Class", options = {
            @Option(label = "10th Class", value = "10"),
            @Option(label = "9th Class", value = "9")
    })
    public String getStudentClass();
}
