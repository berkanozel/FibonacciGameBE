package com.berkanozel.FibonacciGame.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayGround {
    private Box[][] boxes;
    @JsonProperty("isThereAnyFibonacci")
    private boolean isThereAnyFibonacci;
}
