package com.lp.crudframework.xml;

import com.lp.crudframework.api.Facade;
import org.jdom2.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FacadeImpl implements Facade {

    private final JDomParser jDomParser;

    @Autowired
    public FacadeImpl(JDomParser jDomParser) {
        this.jDomParser = jDomParser;
    }

    @Override
    public void generateClasses(String filePath) {
        try {
            jDomParser.readXML(filePath);
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
    }
}
