package net.tomgo.web.controller;

import lombok.extern.slf4j.Slf4j;
import net.tomgo.web.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/delete/{custId}")
    public String deleteCustomer(@PathVariable("custId") int id) {
        log.info("删除数据:"+id);
        return "ok";
    }
    @RequestMapping("/delete2")
    public String deleteCustomer2(@RequestParam("custId") int id) {
        log.info("删除数据:"+id);
        customerService.delCustomer(id);
        return "ok";
    }
}
