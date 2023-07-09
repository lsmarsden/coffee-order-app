package org.lsmarsden.user.model;

import jakarta.persistence.*;
import lombok.Data;
import org.lsmarsden.order.model.Order;

import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String passwordHash;

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
    private List<Order> orders;
}
