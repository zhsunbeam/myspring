package net.tomgo.web.service;

import net.tomgo.web.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    public int delCustomer(int id) {

        return customerDAO.delCustomer(id);
    }
}
