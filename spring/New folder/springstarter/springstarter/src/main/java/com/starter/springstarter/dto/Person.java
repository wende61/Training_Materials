package com.starter.springstarter.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "http://www.example.com/person")
@XmlType(propOrder = {"name", "age"})
public class Person {
    private String name;
    private int age;

    @XmlElement(name = "name", namespace = "http://www.example.com/person")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "age", namespace = "http://www.example.com/person")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
