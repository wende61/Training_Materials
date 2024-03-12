package com.xpath.util;

import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

import com.xpath.model.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class XMLValidator {
public static void validate() throws Exception {
    // Creating a JAXBContext
    JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

    // Creating an Unmarshaller
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

    // Creating a SchemaFactory
    SchemaFactory schemaFactory = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);

    // Loading XSD file from classpath resources
    InputStream xsdInputStream = XMLValidator.class.getResourceAsStream("/person.xsd");
    if (xsdInputStream == null) {
        throw new FileNotFoundException("XSD file not found in resources");
    }
    // Creating a Schema from XSD input stream
    Schema schema = schemaFactory.newSchema(new StreamSource(xsdInputStream));

    // Setting the Schema to the Unmarshaller
    unmarshaller.setSchema(schema);

    // Loading XML file from classpath resources
    InputStream xmlInputStream = XMLValidator.class.getResourceAsStream("/person.xml");
    if (xmlInputStream == null) {
        throw new FileNotFoundException("XML file not found in resources");
    }
    // Parsing XML file with schema validation
    Person person = (Person) unmarshaller.unmarshal(xmlInputStream);

    // Printing parsed person details
    System.out.println("Name: " + person.getName());
    System.out.println("Age: " + person.getAge());
}

}

