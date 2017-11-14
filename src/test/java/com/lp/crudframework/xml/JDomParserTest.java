package com.lp.crudframework.xml;

import com.lp.crudframework.main.Main;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.List;
import java.util.Map;

class JDomParserTest {

    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
    private JDomParser jDomParser;

    @BeforeEach
    void init() {
        jDomParser = context.getBean(JDomParser.class);
    }

    @AfterEach
    void end() {
        context.close();
    }

    @Test
    void mapXMLTest() {
        String filePath = "test.xml";

        try {
            Map<String, List<Element>> map = jDomParser.mapXML(filePath);
            System.out.println(map.get(JDomParser.ROOT).get(0).getName());
            System.out.println(map.get(JDomParser.QUERY).get(0).getAttribute("type"));
            System.out.println(map.get(JDomParser.QUERY).get(1).getAttribute("type"));
            System.out.println(map.get(JDomParser.QUERY).get(2).getAttribute("type"));

            //todo smth wrong here
            System.out.println(map.get(JDomParser.FIND_FIELDS).get(0).getAttribute("name"));
            System.out.println(map.get(JDomParser.FIND_FIELDS).get(1).getAttribute("name"));
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
}

}
