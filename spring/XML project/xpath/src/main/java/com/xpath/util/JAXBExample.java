package com.xpath.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.xpath.model.Person;

import java.io.StringWriter;

public class JAXBExample {

    public static void main(String[] args) {
        // Create an instance of the class to be marshalled
        Person person = new Person();
        person.setName("John Doe");
        person.setAge(30);

        try {
            // Create JAXBContext instance
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

            // Create Marshaller
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Marshal the Java object to XML
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(person, stringWriter);

            // Get the XML string
            String xml = stringWriter.toString();
            System.out.println(xml);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

