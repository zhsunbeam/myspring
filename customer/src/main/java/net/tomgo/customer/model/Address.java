package net.tomgo.customer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component("custAddress")
@Scope("prototype")
public class Address {
    private Integer addressId;
    private String addr;

}
