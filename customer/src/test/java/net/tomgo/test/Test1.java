package net.tomgo.test;

import net.tomgo.customer.config.AppConfig;
import net.tomgo.customer.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@ActiveProfiles("prod")
public class Test1 {

    @Autowired
    DataSource dataSource;

    @Test
    public void testDS() {
        System.out.println(dataSource);
    }

    @Autowired
    CustomerService customerService;

    @Test
    public void testCustService() {
        System.out.println(customerService);
    }

}
