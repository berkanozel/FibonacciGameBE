package com.berkanozel.FibonacciGame.resources;

import com.berkanozel.FibonacciGame.models.PlayGround;
import com.berkanozel.FibonacciGame.service.FibonacciService;
import com.berkanozel.FibonacciGame.service.GridService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {
    private final GridService gridService;
    private final FibonacciService fibonacciService;

    public GameController(GridService gridService, FibonacciService fibonacciService) {
        this.gridService = gridService;
        this.fibonacciService = fibonacciService;
    }

    @GetMapping("/give-grid-size-info/{size}")
    public void setGridSizeInfo(@PathVariable int size) {
        gridService.createANewPlayGround(size);
    }

    @GetMapping("/get-play-ground")
    public PlayGround getPlayGround() {
        return gridService.getPlayGround();
    }

    @GetMapping("/set-pressed-grid-coordination/{row}/{column}")
    public void setPressedGridCoordination(@PathVariable int row, @PathVariable int column) {
        gridService.setPressedGridCoordination(row, column);
    }

    @GetMapping("/reset-fibonacci-boxes")
    public PlayGround resetFibonacciBoxes() {
        return fibonacciService.resetFibonacciBoxes(gridService.getPlayGround());
    }

}
