package com.berkanozel.FibonacciGame.service.impl;

import com.berkanozel.FibonacciGame.models.Box;
import com.berkanozel.FibonacciGame.service.GridService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GridServiceImplTest {

    @Autowired
    private GridService gridService;

    @Test
    void fourShouldReturnIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    gridService.createANewPlayGround(-1);
                });
    }

    @Test
    void fiveShouldCreatePlayGround() {
        int size = 5;
        gridService.createANewPlayGround(size);
        assertEquals(size, gridService.getPlayGround().getBoxes().length);
        assertEquals(size, gridService.getPlayGround().getBoxes()[0].length);
    }

    @Test
    void negativeOneShouldReturnIllegalArgumentExceptionWhenSetCoordinat() {
        gridService.createANewPlayGround(5);
        assertThrows(IllegalArgumentException.class,
                () -> {
                    gridService.setPressedGridCoordination(-1, -1);
                });
    }

    @Test
    void greaterNumberShouldReturnIllegalArgumentExceptionWhenSetCoordinat() {
        gridService.createANewPlayGround(5);
        assertThrows(IllegalArgumentException.class,
                () -> {
                    gridService.setPressedGridCoordination(10, 10);
                });
    }

    @Test
    void properCoordinateShouldIncreasePlayGroundsBoxes() {
        int size = 5;
        int x = 0;
        int y = 0;
        gridService.createANewPlayGround(size);
        gridService.setPressedGridCoordination(x,y);
        Box[][] playGround = gridService.getPlayGround().getBoxes();
        assertEquals(1, playGround[0][0].getValue());
        assertEquals(0, playGround[4][4].getValue());
    }

}