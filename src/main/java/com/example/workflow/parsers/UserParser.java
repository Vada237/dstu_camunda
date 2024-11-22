package com.example.workflow.parsers;

import com.example.workflow.viewModels.User;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserParser {
    public static User[] getUsers(String response) throws ParserConfigurationException, IOException, SAXException {
        List<User> users = new ArrayList<>();
        NodeList data = SoapParser.getItems(response);

        for (int i=0;i<data.getLength(); i++) {
            Node item = data.item(i);
            Node firstNameNode = item.getFirstChild();
            Node idNode = firstNameNode.getNextSibling();
            Node secondNameNode = idNode.getNextSibling();

            String firstName = firstNameNode.getFirstChild().getNodeValue();
            String secondName = secondNameNode.getFirstChild().getNodeValue();
            int id = Integer.parseInt(idNode.getFirstChild().getNodeValue());

            users.add(new User(id, firstName, secondName));
        }

        return users.toArray(new User[0]);
    }
}
