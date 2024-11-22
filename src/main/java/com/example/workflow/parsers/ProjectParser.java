package com.example.workflow.parsers;

import com.example.workflow.viewModels.Project;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProjectParser {
    public static Project[] getProjects(String response) throws ParserConfigurationException, IOException, SAXException {
        List<Project> projects = new ArrayList<>();
        NodeList data = SoapParser.getItems(response);

        for (int i=0;i<data.getLength(); i++) {
            Node item = data.item(i);
            Node idNode = item.getFirstChild().getNextSibling();
            Node titleNode = idNode.getNextSibling().getNextSibling();
            int id = Integer.parseInt(idNode.getFirstChild().getNodeValue());
            String title = titleNode.getFirstChild().getNodeValue();
            projects.add(new Project(id, title));
        }

        return projects.toArray(new Project[0]);
    }
}
