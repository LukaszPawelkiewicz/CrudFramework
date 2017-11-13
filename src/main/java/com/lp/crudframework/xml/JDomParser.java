package com.lp.crudframework.xml;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Component
class JDomParser {

    public static final String ROOT = "root";
    public static final String TABLES = "tables";
    public static final String FIELDS = "fields";
    public static final String QUERIES = XMLMapping.QUERIES;
    public static final String QUERY = XMLMapping.QUERY;
    public static final String FIND_FIELDS = XMLMapping.FIND_FIELD;

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

    @SuppressWarnings("unchecked")
    Map<String, List<Element>> mapXML(String filePath) throws JDOMException, IOException {
        Map map = new HashMap<>();
        File file = new File(filePath);
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(file);

        List<Element> rootList = new ArrayList<>();
        Element root = document.getRootElement();
        rootList.add(root);
        List<Element> tables = root.getChildren();

        List<Element> fields = new ArrayList<>();
        List<Element> queries = new ArrayList<>();
        tables.forEach(table -> {
            fields.add(table.getChild(XMLMapping.FIELD));
            queries.add(table.getChild(XMLMapping.QUERIES));
        });

        List<Element> childQueries = new ArrayList<>();
        queries.forEach(query -> {
            childQueries.add(query.getChild(XMLMapping.QUERY));
        });

        List<Element> findQueries = new ArrayList<>();
        childQueries.forEach(childQuery -> {
            if (Objects.equals(childQuery.getAttribute(XMLMapping.QUERY_TYPE).getName(), XMLMapping.FIND)) {
                Element findQuery = childQuery.getChild(XMLMapping.FIND_FIELD);
            }
        });

        map.put(ROOT, rootList);
        map.put(TABLES, tables);
        map.put(FIELDS, fields);
        map.put(QUERIES, queries);
        map.put(QUERY, childQueries);
        map.put(FIND_FIELDS, findQueries);

        return map;
    }

}
