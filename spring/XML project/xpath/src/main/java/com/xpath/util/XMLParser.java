package com.xpath.util;

import javax.xml.bind.*;

import com.xpath.model.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class XMLParser {
    public static void validate() throws Exception {
    // Creating a JAXBContext
    JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

    // Creating an Unmarshaller
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

    // Loading XML file from classpath resources
    InputStream xmlInputStream = XMLValidator.class.getResourceAsStream("/person.xml");
    if (xmlInputStream == null) {
        throw new FileNotFoundException("XML file not found in resources");
    }

    // Parsing XML file
    Person person = (Person) unmarshaller.unmarshal(xmlInputStream);

    // Printing parsed person details
    System.out.println("Name: " + person.getName());
    System.out.println("Age: " + person.getAge());
}

}

