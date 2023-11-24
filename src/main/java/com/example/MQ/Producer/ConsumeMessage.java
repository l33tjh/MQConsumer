package com.example.MQ.Producer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsumeMessage {
    private List<String> selectedSeats;
    private String email;
    private String sid;
}