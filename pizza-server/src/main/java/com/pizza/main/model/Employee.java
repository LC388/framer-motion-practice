package com.pizza.main.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends User {
    @Id
    @Column(name = "employee_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "employee_first_name", nullable = false)
    private String employeeName;

    @Column(name = "employee_birthday")
    private String employeeBirthday;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @OneToMany(mappedBy = "employee")
    private Set<Order> orders = new LinkedHashSet<>();

    @Column(name = "employee_last_name", nullable = false)
    private String employeeLastName;

    @Column(name = "employee_street")
    private String employeeStreet;

    @Column(name = "employee_city")
    private String employeeCity;

    @Column(name = "employee_state")
    private String employeeState;

    @Column(name = "employee_zipcode")
    private String employeeZipcode;

    @Column(name = "employee_phone")
    private String employeePhone;

}
