package com.starter.springstarter.dto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private String title;
    private String author;
    private int year;
}