package com.berkanozel.FibonacciGame.service.impl;

import com.berkanozel.FibonacciGame.models.Box;
import com.berkanozel.FibonacciGame.models.PlayGround;
import com.berkanozel.FibonacciGame.service.FibonacciService;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class FibonacciServiceImpl implements FibonacciService {

    public void determineFibonacciSequence(PlayGround playGround) {
        for (int i = 0; i < playGround.getBoxes().length; i++) {
            for (int j = 0; j < playGround.getBoxes()[i].length; j++) {
                findConsecutiveFibonacciRow(playGround, i, j);
                findConsecutiveFibonacciColumn(playGround, i, j);
            }
        }
    }

    public void findConsecutiveFibonacciRow(PlayGround playGround, int startRow, int startCol) {
        int size = playGround.getBoxes().length;
        final int totalRows = 5;

        if (startRow < 0 || startCol < 0 || startRow >= size || startCol >= size) {
            throw new IllegalArgumentException("Row and column values cannot be outside the array boundaries!");
        }

        if (startRow + totalRows > size) {
            return;
        }

        for (int i = 0; i < totalRows - 1; i++) {
            int currentRow = startRow + i;
            long currentValue = playGround.getBoxes()[currentRow][startCol].getValue();
            long nextValueInFibonacciSequence = findNextFibonacciNumber(currentValue);
            long nextValue = playGround.getBoxes()[currentRow + 1][startCol].getValue();

            if (i == 0 && currentValue == 1 && nextValue == 1) {
                continue;
            }

            if (nextValueInFibonacciSequence != nextValue) {
                return;
            }
        }
        for (int i = 0; i < totalRows; i++) {
            playGround.getBoxes()[startRow + i][startCol].setFibonacci(true);
        }
        playGround.setThereAnyFibonacci(true);
    }

    public void findConsecutiveFibonacciColumn(PlayGround playGround, int startRow, int startCol) {
        int size = playGround.getBoxes().length;
        final int totalRows = 5;

        if (startRow < 0 || startCol < 0 || startRow >= size || startCol >= size) {
            throw new IllegalArgumentException("Row and column values cannot be outside the array boundaries!");
        }

        if (startCol + totalRows > size) {
            return;
        }

        for (int i = 0; i < totalRows - 1; i++) {
            int currentColumn = startCol + i;
            long currentValue = playGround.getBoxes()[startRow][currentColumn].getValue();
            long nextValueInFibonacciSequence = findNextFibonacciNumber(currentValue);
            long nextValue = playGround.getBoxes()[startRow][currentColumn + 1].getValue();

            if (i == 0 && currentValue == 1 && nextValue == 1) {
                continue;
            }
            if (nextValueInFibonacciSequence != nextValue) {
                return;
            }
        }
        for (int i = 0; i < totalRows; i++) {
            playGround.getBoxes()[startRow][startCol + i].setFibonacci(true);
        }
        playGround.setThereAnyFibonacci(true);
    }

    public long findNextFibonacciNumber(long n) {
        if (n <= 0) {
            return -1;
        }
        double a = n * (1 + Math.sqrt(5)) / 2.0;
        return Math.round(a);
    }

    @Override
    public PlayGround resetFibonacciBoxes(PlayGround playGround) {
        Arrays.stream(playGround.getBoxes())
                .flatMap(Arrays::stream)
                .filter(Box::isFibonacci)
                .forEach(box -> {
                    box.setValue(0);
                    box.setFibonacci(false);
                });
        playGround.setThereAnyFibonacci(false);
        return playGround;
    }
}
