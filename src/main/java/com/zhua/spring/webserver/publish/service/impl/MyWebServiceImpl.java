package com.zhua.spring.webserver.publish.service.impl;

import com.zhua.spring.webserver.publish.service.MyWebService;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;


/**
 * @ClassName WebServiceImpl
 * @Description TODO
 * @Author zhua
 * @Date 2020/8/13 11:09
 * @Version 1.0
 */
//@WebService
//@WebServiceProvider
@WebService(endpointInterface = "com.zhua.spring.webserver.publish.service.MyWebService",
        targetNamespace = "http://service.zhua.web.com/wsdl", serviceName = "webService", portName = "myWebService")
@Component
public class MyWebServiceImpl implements MyWebService {

    @WebMethod(operationName = "sayHello")
    @Override
    public String sayHello(String username) {
        return "hello,"+username;
    }
}
