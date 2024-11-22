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
            Node item = data.item(i);
            Node countHoursNode = item.getFirstChild();
            Node finishTimeNode = countHoursNode.getNextSibling();
            Node idNode = finishTimeNode.getNextSibling();
            Node startTimeNode = idNode.getNextSibling().getNextSibling().getNextSibling();
            Node statusNode = startTimeNode.getNextSibling();
            Node titleNode = statusNode.getNextSibling();

            int countHours = Integer.parseInt(countHoursNode.getFirstChild().getNodeValue());
            String finishTime = finishTimeNode.getFirstChild().getNodeValue();
            int id = Integer.parseInt(idNode.getFirstChild().getNodeValue());
            String startTime = startTimeNode.getFirstChild().getNodeValue();
            String status = statusNode.getFirstChild().getNodeValue();
            String title = titleNode.getFirstChild().getNodeValue();

            tasks.add(new Task(
                    id, title, startTime, finishTime, countHours, status
            ));
        }

        return tasks.toArray(new Task[0]);
    }
}
