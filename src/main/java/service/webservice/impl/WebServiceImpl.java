package service.webservice.impl;

import service.webservice.WebService;
@javax.jws.WebService
public class WebServiceImpl implements WebService {
    @Override
    public String sayHello(String name) {
        return "webservice调用";
    }
}
