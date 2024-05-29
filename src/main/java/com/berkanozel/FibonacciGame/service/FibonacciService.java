package com.berkanozel.FibonacciGame.service;

import com.berkanozel.FibonacciGame.models.PlayGround;

public interface FibonacciService {
    void determineFibonacciSequence(PlayGround playGround);

    PlayGround resetFibonacciBoxes(PlayGround playGround);
}
