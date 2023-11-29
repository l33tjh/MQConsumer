package com.example.MQ.Entity;

import com.example.MQ.StringListConverter;
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

    @Convert(converter = StringListConverter.class)
    @Column(name = "seats", nullable = false)
    private List<String> selectedSeats;

    @Column(nullable = false)
    private String sid;

    @Column(nullable = false)
    private Long price;
}
