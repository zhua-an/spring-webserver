package com.zhua.spring.webserver.publish.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceProvider;

/**
 * @ClassName WebService
 * @Description TODO
 * @Author zhua
 * @Date 2020/8/13 11:09
 * @Version 1.0
 */
@WebService(targetNamespace = "http://service.zhua.web.com/wsdl")// 命名空间,一般是接口的包名倒序
//@SOAPBinding(style = SOAPBinding.Style.RPC)
//@WebServiceProvider
public interface MyWebService {

    @WebMethod(operationName = "sayHello")
    public String sayHello(@WebParam(name = "username") String username);//不使用此注解 webservice 页面看到参数全是arg0

}
