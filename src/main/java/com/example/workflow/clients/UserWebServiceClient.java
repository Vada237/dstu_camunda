package com.example.workflow.clients;

import jakarta.xml.soap.*;

import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserWebServiceClient {
    public void createUser(String firstName, String secondName){
        try {
            // Создаем SOAP-запрос
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // URL эндпоинта
            String url = "http://localhost:8010/wss/user";

            // Создаем SOAP-сообщение
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();

            // Создаем SOAP-конверт
            SOAPEnvelope envelope = soapPart.getEnvelope();
            envelope.addNamespaceDeclaration("ns", "http://example.com/namespace");

            // Создаем SOAP-заголовок (если необходимо)
            SOAPHeader header = envelope.getHeader();
            // Добавьте заголовки, если они нужны

            // Создаем SOAP-тело
            SOAPBody soapBody = envelope.getBody();
            SOAPElement soapBodyElem = soapBody.addChildElement("SomeMethod", "ns");
            SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("parameter", "ns");
            soapBodyElem1.addTextNode("value");

            // Отправляем SOAP-запрос
            SOAPMessage soapResponse = soapConnection.call(soapMessage, url);

            // Получаем ответ
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            soapResponse.writeTo(out);
            String response = new String(out.toByteArray());

            // Выводим ответ
            System.out.println("Response: " + response);

            // Закрываем соединение
            soapConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}