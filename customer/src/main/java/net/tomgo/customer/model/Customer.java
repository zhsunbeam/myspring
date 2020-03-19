package net.tomgo.customer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component("cust")
public class Customer {
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String email;

    @Autowired
    @Qualifier("custAddress")
    private Address address;




}
