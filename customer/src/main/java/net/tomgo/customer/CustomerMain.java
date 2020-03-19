package net.tomgo.customer;


import net.tomgo.customer.config.ActorConfig;
import net.tomgo.customer.config.AppConfig;
import net.tomgo.customer.model.Customer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class CustomerMain {
    public static void main(String[] args) {


        //通过xml配置文件启动Spring 应用程序
        /*ClassPathXmlApplicationContext app =
                new ClassPathXmlApplicationContext("applicationContext.xml");*/

        //FileSystemXmlApplicationContext
        /*ClassPathXmlApplicationContext app =
                new ClassPathXmlApplicationContext("applicationContext.xml");*/

        AnnotationConfigApplicationContext annoApp =
                new AnnotationConfigApplicationContext(AppConfig.class);

      /*  DataSource ds = (DataSource) annoApp.getBean("druidDataSource");
        System.out.println(ds);*/


    }
}
