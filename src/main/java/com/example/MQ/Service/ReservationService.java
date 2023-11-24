package com.example.MQ.Service;

import com.example.MQ.Entity.Reservation;
import com.example.MQ.Producer.ConsumeMessage;
import com.example.MQ.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation createReservation(ConsumeMessage msg) {
        int price = 0;
        Reservation reservation = new Reservation();
        reservation.setEmail(msg.getEmail());
        reservation.setSelectedSeats(msg.getSelectedSeats());
        reservation.setSid(msg.getSid());
        int numberOfSeats = msg.getSelectedSeats().size();
        if (numberOfSeats == 1){price = 24000;}
        else {price = 48000;}
        reservation.setPrice((long) price);
        return reservationRepository.save(reservation);
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }
}