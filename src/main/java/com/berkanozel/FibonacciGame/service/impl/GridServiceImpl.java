package com.berkanozel.FibonacciGame.service.impl;

import com.berkanozel.FibonacciGame.models.Box;
import com.berkanozel.FibonacciGame.models.PlayGround;
import com.berkanozel.FibonacciGame.service.FibonacciService;
import com.berkanozel.FibonacciGame.service.GridService;
import org.springframework.stereotype.Service;

@Service
public class GridServiceImpl implements GridService {
    private final FibonacciService fibonacciService;

    public GridServiceImpl(FibonacciService fibonacciService) {
        this.fibonacciService = fibonacciService;
    }

    private PlayGround playGround;

    @Override
    public void createANewPlayGround(int size) {
        if (size <= 4) {
            throw new IllegalArgumentException("Size must be a greater than four!");
        }
        this.playGround = new PlayGround();
        playGround.setBoxes(new Box[size][size]);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                playGround.getBoxes()[i][j] = new Box(i, j, false, 0);
            }
        }
    }

    @Override
    public void setPressedGridCoordination(int row, int column) {
        int lengthOfArray = playGround.getBoxes().length;
        if (row >= lengthOfArray || column >= lengthOfArray) {
            throw new IllegalArgumentException("row and column must be less than size of the array!");
        }
        if (row < 0 || column < 0) {
            throw new IllegalArgumentException("row and column must be greater than zero!");
        }
        for (int i = 0; i < lengthOfArray; i++) {
            if (i != column) {
                playGround.getBoxes()[row][i].incrementValue();
            }
            playGround.getBoxes()[i][column].incrementValue();
        }
        fibonacciService.determineFibonacciSequence(playGround);
    }

    @Override
    public PlayGround getPlayGround() {
        return playGround;
    }
}
