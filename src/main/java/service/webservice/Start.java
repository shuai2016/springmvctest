package service.webservice;

import service.webservice.impl.WebServiceImpl;

import javax.xml.ws.Endpoint;

public class Start {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8010/webservice",new WebServiceImpl());
    }
}
