package com.lp.crudframework.xml;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
class JDomParser {

    List<Element> readXML(String filePath) throws JDOMException, IOException {
        File inputFile = new File(filePath);
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(inputFile);

        Element root = document.getRootElement();
        System.out.println(root.getName());

        List<Element> childrenElements = root.getChildren();

        childrenElements.forEach(child -> {
            Attribute attribute = child.getAttribute("rollno");
            System.out.println(attribute.getValue());
            System.out.println(child.getChild("firstname").getText());
            System.out.println(child.getChild("lastname").getText());
            System.out.println(child.getChild("nickname").getText());
            System.out.println(child.getChild("marks").getText());
        });

        return null;
    }


}
