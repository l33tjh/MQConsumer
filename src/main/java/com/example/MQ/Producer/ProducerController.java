//package com.example.MQ.Producer;
//
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class ProducerController {
//    private static final String EXCHANGE_NAME = "ticket.exchange";
//
//    @Autowired
//    RabbitTemplate rabbitTemplate;
//
//    @GetMapping("ticket/queue")
//    public String Publish(){
//        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "ticket.routing.#","RabbitMQ + SpringBoot = Success");
//        return "Message Sending";
//    }
//}
