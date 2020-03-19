package net.tomgo.customer.config;

import net.tomgo.customer.model.Address;
import net.tomgo.customer.model.Customer;
import net.tomgo.customer.service.CustomerService;
import net.tomgo.customer.service.LinuxService;
import net.tomgo.customer.service.WindowsService;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(basePackages = {"net.tomgo.customer"})
@Import({ActorConfig.class, DataSourceConfig.class})
@ImportResource("classpath:staff-context.xml")
@EnableScheduling
@EnableAsync
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean(name = "str1")
    public String createString(){
        return new String("abc");
    }

    @Bean(name = "address")
    public Address createAddress() {
        System.out.println("这是使用java创建方式");
        return new Address();
    }

    @Bean
    public Customer createCustomer(Address address) {
        Customer customer = new Customer();
        customer.setAddress( createAddress() );
        return customer;
    }


   /* @Bean(initMethod = "init", destroyMethod = "destroy")
    public CustomerService createCustomerService() {
        return new CustomerService();
    }*/

   @Bean
   @Conditional(WindowsConditional.class)
   public WindowsService createWinService() {
       return new WindowsService();
   }

    @Bean
    @Conditional(LinuxConditional.class)
    public LinuxService createLinuxService() {
        return new LinuxService();
    }
}
