package com.starter.springstarter.util;

import java.awt.print.Book;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;

import org.xml.sax.InputSource;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.starter.springstarter.dto.Bookstore;
import com.starter.springstarter.dto.Person;
import com.starter.springstarter.dto.PersonWithJakarta;

import ch.qos.logback.core.pattern.parser.Node;

public class XmlUtility {

    public static void parse(MultipartFile file) throws IOException {
        try {
            // Creating a JAXBContext
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

            // Creating an Unmarshaller
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Reading the uploaded XML file
            InputStream xmlInputStream = file.getInputStream();

            // Loading XML file from classpath resources
            // InputStream xmlInputStream =
            // XmlUtility.class.getResourceAsStream("/person.xml");
            if (xmlInputStream == null) {
                throw new FileNotFoundException("XML file not found in resources");
            }

            // Parsing XML file
            Person person = (Person) unmarshaller.unmarshal(xmlInputStream);

            // Printing parsed person details
            System.out.println("Name: " + person.getName());
            System.out.println("Age: " + person.getAge());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void validation(MultipartFile file) throws JAXBException {
        try {
            // Creating a JAXBContext
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

            // Creating an Unmarshaller
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Creating a SchemaFactory
            SchemaFactory schemaFactory = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // Loading XSD file from classpath resources
            InputStream xsdInputStream = XmlUtility.class.getResourceAsStream("/person.xsd");
            if (xsdInputStream == null) {
                throw new FileNotFoundException("XSD file not found in resources");
            }
            // Creating a Schema from XSD input stream
            Schema schema = schemaFactory.newSchema(new StreamSource(xsdInputStream));

            // Setting the Schema to the Unmarshaller
            unmarshaller.setSchema(schema);

            // Reading the uploaded XML file
            InputStream xmlInputStream = file.getInputStream();

            // Loading XML file from classpath resources
            // InputStream xmlInputStream =
            // XmlUtility.class.getResourceAsStream("/person.xml");
            if (xmlInputStream == null) {
                throw new FileNotFoundException("XML file not found in resources");
            }
            // Parsing XML file with schema validation
            Person person = (Person) unmarshaller.unmarshal(xmlInputStream);

            // Printing parsed person details
            System.out.println("Name: " + person.getName());
            System.out.println("Age: " + person.getAge());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void xpath(String xmlString) throws Exception {
        try {
            // Parsing XML
            InputSource inputSource = new InputSource(new StringReader(xmlString));
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);

            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();

            // Example: Selecting the first 'book' element
            XPathExpression expr = xpath.compile("/bookstore/book[1]/title");
            XPathExpression expression = xpath.compile("/bookstore/book[1]");
            Node bookNode = (Node) expression.evaluate(document, XPathConstants.NODE);
            Object result = expr.evaluate(document);
            System.out.println(result);

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }

    public static String processXmlData(String xmlData) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            Bookstore bookstore = xmlMapper.readValue(xmlData, Bookstore.class);
            // Process the parsed XML data
            return "Processed XML data: " + bookstore.getBooks().get(0).getAuthor() + " book found.";
        } catch (Exception e) {
            // Handle JAXB exception
            return "Error processing XML data: " + e.getMessage();
        }
    }

    public static String processXmlFile(MultipartFile xmlFile) {
        try {
            // Read XML file content
            String xmlData = new String(xmlFile.getBytes());
            return processXmlData(xmlData);
        } catch (IOException e) {
            // Handle file reading exception
            return "Error reading XML file: " + e.getMessage();
        }
    }

    public static String personXmlFile(MultipartFile xmlFile) {
        try {
            // Read XML file content
            String xmlData = new String(xmlFile.getBytes());
            return personXmlData(xmlData);
        } catch (IOException e) {
            // Handle file reading exception
            return "Error reading XML file: " + e.getMessage();
        }
    }

    public static String personXmlData(String xmlData) {
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Person person = (Person) unmarshaller.unmarshal(new StringReader(xmlData));
            // Create an instance of the class to be marshalled
            Person person2 = new Person();
            person2.setName("John Doe");
            person2.setAge(30);
            // Process the parsed XML data

            // Create Marshaller
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Marshal the Java object to XML
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(person2, stringWriter);

            // Get the XML string
            String xml = stringWriter.toString();
            System.out.println(xml);
            // Process the parsed XML data
            return "Processed XML data: " + person.getName() + " person found.";
        } catch (Exception e) {
            // Handle JAXB exception
            return "Error processing XML data: " + e.getMessage();
        }
    }

    // when using Jakarta
    public static String personWithJakartaXmlData(String xmlData) {
        try {
            jakarta.xml.bind.JAXBContext jaxbContext = jakarta.xml.bind.JAXBContext
                    .newInstance(PersonWithJakarta.class);
            jakarta.xml.bind.Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            PersonWithJakarta personWithJakarta = (PersonWithJakarta) unmarshaller.unmarshal(new StringReader(xmlData));
            // Process the parsed XML data
            return "Processed XML data: " + personWithJakarta.getName() + " person found.";
        } catch (Exception e) {
            // Handle exception
            return "Error processing XML data: " + e.getMessage();
        }
    }

    public static String personWithJakartaXmlFile(MultipartFile xmlFile) {
        try {
            // Read XML file content
            String xmlData = new String(xmlFile.getBytes());
            return personWithJakartaXmlData(xmlData);
        } catch (IOException e) {
            // Handle file reading exception
            return "Error reading XML file: " + e.getMessage();
        }
    }
}
