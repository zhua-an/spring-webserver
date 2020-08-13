package com.zhua.spring.webserver.publish.config;

import com.zhua.spring.webserver.publish.service.MyWebService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @ClassName CxfConfig
 * @Description
 * 第一种方式：直接在启动类中使用Endpoint，不需编写配置类，这种方式可以自定义webservice的端口，但不要和服务器的端口冲突了。
 * 第二种方式：使用配置类，不用在启动类中加Endpoint.publish，这种接口的端口号和服务器端口号是一致的
 * @Author zhua
 * @Date 2020/8/13 11:15
 * @Version 1.0
 */

@Configuration
public class CxfConfig {

    @Autowired
    private Bus bus;

    @Autowired
    private MyWebService myWebService;

    /**
     * 此方法作用是改变项目中服务名的前缀名，此处127.0.0.1或者localhost不能访问时，请使用ipconfig查看本机ip来访问
     * 此方法被注释后:wsdl访问地址为http://127.0.0.1:8080/services/myWebService?wsdl
     * 去掉注释后：wsdl访问地址为：http://127.0.0.1:8080/soap/myWebService?wsdl
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean disServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new CXFServlet(), "/webService/*");
        return servletRegistrationBean;
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    /** JAX-WS
     * 站点服务
     *
     **/
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, myWebService);
        endpoint.publish("/sayHello");
        return endpoint;
    }
}
