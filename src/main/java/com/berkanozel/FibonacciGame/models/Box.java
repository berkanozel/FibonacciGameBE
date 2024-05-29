package com.berkanozel.FibonacciGame.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Box {
    private int x;
    private int y;
    @JsonProperty("isFibonacci")
    private boolean isFibonacci;
    private long value;

    public void incrementValue() {
        value++;
    }
}