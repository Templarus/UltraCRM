/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;



import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
/**
 *
 * @author Asus
 */
public class ParserXMLDom  {
    
    
    
    
    
    
    
    
    public static void parseXML(File file) throws ParserConfigurationException, SAXException, IOException{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(file);
        
        Element rootEl = doc.getDocumentElement();
        String titleEl = rootEl.getNodeName();
        System.out.println("titleEl = " + titleEl);
    }
    
    
    
    
    
    
    

}
