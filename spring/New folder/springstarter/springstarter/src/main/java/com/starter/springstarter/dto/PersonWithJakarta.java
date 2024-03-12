package com.starter.springstarter.dto;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "person", namespace = "http://www.example.com/person")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonWithJakarta {
    @XmlElement(name = "name", namespace = "http://www.example.com/person")
    private String name;

    @XmlElement(name = "age", namespace = "http://www.example.com/person")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}