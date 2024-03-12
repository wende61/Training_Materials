package com.xpath.util;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class XPathExample {
    public static void parse() throws Exception {
        // XML document
        String xml = "<person><name>John</name><age>30</age></person>";

        // Creating XPathFactory
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

        // Parsing XML
        InputSource inputSource = new InputSource(new StringReader(xml));
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);

        // Evaluating XPath expression
        String name = xPath.evaluate("/person/name", document);
        String age = xPath.evaluate("/person/age", document);

        // Printing result
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

