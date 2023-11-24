package com.example.MQ;

import com.example.MQ.Entity.Reservation;
import com.example.MQ.Producer.ConsumeMessage;
import com.example.MQ.Service.ReservationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Consumer {
    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    private final ReservationService reservationService;
    private final ObjectMapper objectMapper;

    @Autowired
    public Consumer(ReservationService reservationService, ObjectMapper objectMapper) {
        this.reservationService = reservationService;
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "ticket.queue")
    public void consume(String message) {
        try {
            int price = 0;
            String seat1 = "";
            String seat2 = "";

            ConsumeMessage msg = objectMapper.readValue(message, ConsumeMessage.class);

            log.info("Consumer consumes Message : {}", msg.getEmail());
            log.info("Consumer consumes Message : {}", msg.getSelectedSeats());
            log.info("Consumer consumes Message : {}", msg.getSid());

//            List<String> selectedSeats = msg.getSelectedSeats();
            Reservation savedReservation = reservationService.createReservation(msg);
            log.info("Reservation saved with ID: {}", savedReservation.getId());

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}