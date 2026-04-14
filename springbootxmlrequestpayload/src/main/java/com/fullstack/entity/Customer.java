package com.fullstack.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.spi.ManagedEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
@XmlRootElement(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long custId;

    @Size(min = 2, message = "Customer Name should be at least 2 characters")
    private String custName;

    private String custAddress;

    private long custContactNumber;

    @Email(message = "Email Must Be Valid")
    private String custEmailId;

    private String custPassword;

    // enum- CustomerStatus
    // API- find customer by status
    // API- Status wise customer count
   // Hint - Map Status, Long

    


}
