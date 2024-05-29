package com.berkanozel.FibonacciGame.service.impl;

import com.berkanozel.FibonacciGame.models.Box;
import com.berkanozel.FibonacciGame.models.PlayGround;
import com.berkanozel.FibonacciGame.service.FibonacciService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class FibonacciServiceImplTest {

    @Mock
    private PlayGround mockPlayGround;

    @Autowired
    private FibonacciService fibonacciService;

    @Test
    public void testResetFibonacciBoxes() {
        Box box1 = new Box(0, 1, false, 1);
        Box box2 = new Box(0, 2, true,1);
        Box box3 = new Box(0, 3, true,2);
        Box box4 = new Box(0, 4, false,3);

        Box[][] mockBoxes = {
                {box1, box2},
                {box3, box4}
        };

        when(mockPlayGround.getBoxes()).thenReturn(mockBoxes);
        fibonacciService.resetFibonacciBoxes(mockPlayGround);
        assertEquals(1, box1.getValue());
        assertEquals(0, box2.getValue());
        assertEquals(0, box3.getValue());
        assertEquals(3, box4.getValue());

        verify(mockPlayGround).setThereAnyFibonacci(false);
    }

    @Test
    public void findNextFibonacciNumber() {

        FibonacciServiceImpl serviceImpl = new FibonacciServiceImpl();

        long[] inputValues = {0, 1, 3, 5, 8};
        long[] expectedValues = {-1, 2, 5, 8, 13};

            for (int i = 0; i < inputValues.length; i++) {
            long input = inputValues[i];
            long expected = expectedValues[i];

            long result = serviceImpl.findNextFibonacciNumber(input);

            assertEquals(expected, result);
        }
    }

}