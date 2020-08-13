package com.zhua.spring.webserver;

import com.zhua.spring.webserver.publish.service.MyWebService;
import com.zhua.spring.webserver.publish.service.impl.MyWebServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.ws.Endpoint;

@SpringBootApplication
public class WebServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServerApplication.class, args);

        System.out.println("启动并发布webservice远程服务");
        /**
         * 第一种方式：直接在启动类中使用Endpoint，不需编写配置类，这种方式可以自定义webservice的端口，但不要和服务器的端口冲突了。
         * 第二种方式：使用配置类，不用在启动类中加Endpoint.publish，这种接口的端口号和服务器端口号是一致的
         */
        MyWebService myWebService = new MyWebServiceImpl();
        Endpoint.publish("http://127.0.0.1:11008/webService?wsdl", myWebService);
        System.out.println("启动并发布webservice远程服务，服务发布成功....");
    }

}
