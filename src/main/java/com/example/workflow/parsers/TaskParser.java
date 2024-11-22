package com.example.workflow.parsers;

import com.example.workflow.viewModels.Task;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskParser {
    public static Task[] getTasks(String response) throws ParserConfigurationException, IOException, SAXException {
        List<Task> tasks = new ArrayList<>();
        NodeList data = SoapParser.getItems(response);

        for (int i=0;i<data.getLength(); i++) {
            Node x = data.item(i);
        }

        return new Task[0];
    }
}
