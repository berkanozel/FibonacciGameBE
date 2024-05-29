package com.berkanozel.FibonacciGame.service;

import com.berkanozel.FibonacciGame.models.PlayGround;

public interface GridService {
    void createANewPlayGround(int size);

    void setPressedGridCoordination(int row, int column);

    PlayGround getPlayGround();
}
