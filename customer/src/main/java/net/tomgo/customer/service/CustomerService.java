package net.tomgo.customer.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class CustomerService {

    @PostConstruct
    public void init() {
        System.out.println("在CustomerService构造方法之前调用");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("在CustomerService对象销毁之前调用");
    }
}
