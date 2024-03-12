package com.starter.springstarter.dto;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;



@Data
@JacksonXmlRootElement(localName = "bookstore") // Specify the root element name
public class Bookstore {
    @JacksonXmlProperty(localName  = "book")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Book> books;

    // @XmlElement(name = "book") // Specify the element name for the list of books
    // public List<Book> getBooks() {
    //     return books;
    // }

    // public void setBooks(List<Book> books) {
    //     this.books = books;
    // }
}
