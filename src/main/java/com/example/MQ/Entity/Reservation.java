package com.example.MQ.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Table(name = "reservation")
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @ElementCollection
    @CollectionTable(name = "selected_seats", joinColumns = @JoinColumn(name = "reservation_id"))
    @Column(name = "seat")
    private List<String> selectedSeats;

    @Column(nullable = false)
    private String sid;

    @Column(nullable = false)
    private Long price;
}
