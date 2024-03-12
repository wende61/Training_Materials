package com.xpath;

import com.xpath.util.XMLParser;
import com.xpath.util.XMLValidator;
import com.xpath.util.XPathExample;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        XPathExample.parse();
        XMLValidator.validate();
        XMLParser.validate();
    }
}
