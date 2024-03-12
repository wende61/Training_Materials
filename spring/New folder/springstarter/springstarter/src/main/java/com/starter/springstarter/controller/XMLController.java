package com.starter.springstarter.controller;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.starter.springstarter.dto.Bookstore;
import com.starter.springstarter.dto.Person;
import com.starter.springstarter.dto.PersonWithJakarta;
import com.starter.springstarter.util.XmlUtility;

// import javax.xml.bind.JAXBContext;
// import javax.xml.bind.JAXBException;
// import javax.xml.bind.Marshaller;

@RestController
public class XMLController {

    @PostMapping("/processXml")
    public String processXml(@RequestParam(required = false) MultipartFile xmlFile,
            @RequestBody(required = false) String xmlData) throws Exception {
        if (xmlData != null) {
            // Process XML data from the request body
            XmlUtility.SAXParser();
            XmlUtility.DOMParser();
            XmlUtility.xpath(xmlData);
            return XmlUtility.processXmlData(xmlData);
        } else if (xmlFile != null && !xmlFile.isEmpty()) {
            // Process XML file from multipart form
            return XmlUtility.processXmlFile(xmlFile);
        } else {
            // Handle error
            return "No XML data provided";
        }
    }

    @PostMapping("/person")
    public String personXml(@RequestParam(required = false) MultipartFile xmlFile,
            @RequestBody(required = false) String xmlData) throws Exception {
        if (xmlData != null) {
            // Process XML data from the request body
            XmlUtility.xpath(xmlData);
            return XmlUtility.personXmlData(xmlData);
        } else if (xmlFile != null && !xmlFile.isEmpty()) {
            // Process XML file from multipart form
            return XmlUtility.personXmlFile(xmlFile);
        } else {
            // Handle error
            return "No XML data provided";
        }
    }

    @PostMapping("/personwithjakarta")
    public String personWithJakartaXml(@RequestParam(required = false) MultipartFile xmlFile,
            @RequestBody(required = false) String xmlData) throws Exception {
        if (xmlData != null) {
            // Process XML data from the request body
            XmlUtility.xpath(xmlData);
            return XmlUtility.personWithJakartaXmlData(xmlData);
        } else if (xmlFile != null && !xmlFile.isEmpty()) {
            // Process XML file from multipart form
            XmlUtility.validation(xmlFile);
            XmlUtility.parse(xmlFile);
            return XmlUtility.personWithJakartaXmlFile(xmlFile);
        } else {
            // Handle error
            return "No XML data provided";
        }
    }

    // private String processXmlData(String xmlData) {
    //     try {
    //         XmlMapper xmlMapper = new XmlMapper();
    //         Bookstore bookstore = xmlMapper.readValue(xmlData, Bookstore.class);
    //         // Process the parsed XML data
    //         return "Processed XML data: " + bookstore.getBooks().get(0).getAuthor() + " book found.";
    //     } catch (Exception e) {
    //         // Handle JAXB exception
    //         return "Error processing XML data: " + e.getMessage();
    //     }
    // }

    // private String processXmlFile(MultipartFile xmlFile) {
    //     try {
    //         // Read XML file content
    //         String xmlData = new String(xmlFile.getBytes());
    //         return processXmlData(xmlData);
    //     } catch (IOException e) {
    //         // Handle file reading exception
    //         return "Error reading XML file: " + e.getMessage();
    //     }
    // }

    // private String personXmlFile(MultipartFile xmlFile) {
    //     try {
    //         // Read XML file content
    //         String xmlData = new String(xmlFile.getBytes());
    //         return personXmlData(xmlData);
    //     } catch (IOException e) {
    //         // Handle file reading exception
    //         return "Error reading XML file: " + e.getMessage();
    //     }
    // }


    // private String personXmlData(String xmlData) {
    //     try {

    //         JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
    //         Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    //         Person person = (Person) unmarshaller.unmarshal(new StringReader(xmlData));
    //         // Create an instance of the class to be marshalled
    //         Person person2 = new Person();
    //         person2.setName("John Doe");
    //         person2.setAge(30);
    //         // Process the parsed XML data
    //         // Create JAXBContext instance
    //         JAXBContext jaxbContextConverter = JAXBContext.newInstance(Person.class);

    //         // Create Marshaller
    //         Marshaller marshaller = jaxbContext.createMarshaller();
    //         marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    //         // Marshal the Java object to XML
    //         StringWriter stringWriter = new StringWriter();
    //         marshaller.marshal(person2, stringWriter);

    //         // Get the XML string
    //         String xml = stringWriter.toString();
    //         System.out.println(xml);
    //         // Process the parsed XML data
    //         return "Processed XML data: " + person.getName() + " person found.";
    //     } catch (Exception e) {
    //         // Handle JAXB exception
    //         return "Error processing XML data: " + e.getMessage();
    //     }
    // }
    // // when using Jakarta
    // private String personWithJakartaXmlData(String xmlData) {
    //     try {
    //         jakarta.xml.bind.JAXBContext jaxbContext = jakarta.xml.bind.JAXBContext.newInstance(PersonWithJakarta.class);
    //         jakarta.xml.bind.Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    //         PersonWithJakarta personWithJakarta = (PersonWithJakarta) unmarshaller.unmarshal(new StringReader(xmlData));
    //         // Process the parsed XML data
    //         return "Processed XML data: "  + personWithJakarta.getName() + " person found.";
    //     } catch (Exception e) {
    //         // Handle exception
    //         return "Error processing XML data: " + e.getMessage();
    //     }
    // }

    // private String personWithJakartaXmlFile(MultipartFile xmlFile) {
    //     try {
    //         // Read XML file content
    //         String xmlData = new String(xmlFile.getBytes());
    //         return personWithJakartaXmlData(xmlData);
    //     } catch (IOException e) {
    //         // Handle file reading exception
    //         return "Error reading XML file: " + e.getMessage();
    //     }
    // }
    
}
