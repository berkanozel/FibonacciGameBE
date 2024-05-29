package com.berkanozel.FibonacciGame.resources;

import com.berkanozel.FibonacciGame.models.PlayGround;
import com.berkanozel.FibonacciGame.service.FibonacciService;
import com.berkanozel.FibonacciGame.service.GridService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameControllerTest {

    @Mock
    private GridService gridService;

    @Mock
    private FibonacciService fibonacciService;

    @InjectMocks
    private GameController gameController;

    @Test
    public void testGetColumnLineInfo() {
        int size = 10;
        gameController.setGridSizeInfo(size);
        verify(gridService).createANewPlayGround(size);
    }

    @Test
    void getPlayGround() {
        PlayGround mockPlayGround = new PlayGround();
        when(gridService.getPlayGround()).thenReturn(mockPlayGround);
        PlayGround result = gameController.getPlayGround();
        assertEquals(mockPlayGround, result);
    }

    @Test
    void setPressedGridCoordination() {
        int row = 0;
        int column = 0;
        gameController.setPressedGridCoordination(row,column);
        verify(gridService).setPressedGridCoordination(row, column);
    }

    @Test
    void resetFibonacciBoxes() {
        PlayGround mockPlayGround = new PlayGround();

        when(gridService.getPlayGround()).thenReturn(mockPlayGround);
        when(fibonacciService.resetFibonacciBoxes(mockPlayGround)).thenReturn(mockPlayGround);

        PlayGround result = gameController.resetFibonacciBoxes();
        assertEquals(mockPlayGround, result);
        verify(fibonacciService).resetFibonacciBoxes(mockPlayGround);
    }
}