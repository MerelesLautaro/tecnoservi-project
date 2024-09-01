package com.lautadev.tecnoservi_project.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;
    @ManyToOne
    private Task task;
    @ManyToOne
    private State state;
    @ManyToOne
    private Client client;
    @ManyToOne
    private WorkTeam workTeam;

}
