# Fibonacci Game

Fibonacci Game Backend

## Description
The core feature on the frontend involves designing a 50x50 grid interface. Each cell in the grid is interactive and can take on a value (the default value is 0). When a user clicks on any particular cell, the values in all the cells present in the same row and column get incremented by 1. If the cell was empty, it should now have a value of 1. After each interaction, the affected cells should flash yellow for a brief period.

A secondary trait of the interactive grid is to identify the Fibonacci sequence. If the application detects 5 consecutive numbers from the Fibonacci sequence either horizontally or vertically, the cells carrying those values will flash green briefly before their values are cleared out.

The objective of the game is to create <b>Fibonacci</b> numbers. <br>
- When you click on any square on the screen, all squares in the same row and column will be incremented by 1.<br>
- If you obtain five consecutive <b>Fibonacci</b> numbers, the corresponding area will be reset.
 <br><br>
This is a backend development of Fiboacci Game!

## Getting Started

### Dependencies

* Java Version 17.0.9
* Maven Version 3.9.6
* SpringBoot Version 3.2.5

### Executing program
* In this project, since there is a Maven wrapper, you can follow the commands listed below in order.
* First pull code from the repository than you can run the project by typing the following commands in the terminal.
```
For windows:

.\mvnw clean install
.\mvnw spring-boot:run

For macOS and Linux:

./mvnw clean install
./mvnw spring-boot:run
```

# API endpoints

These endpoints allow you to create the playground and play

## GET
`Create Game With Size Info ->` [game/grid-size-info/{size}](#give-grid-size-info) <br/><br/>
`Get Playground ->` [game/get-play-ground](#get-play-ground) <br/><br/>
`Send x,y Coordinate And Calculate ->` [game/set-pressed-grid-coordination/{row}/{column}](#set-pressed-grid-coordination}) <br/><br/>
`Reset All Fibonacci Boxes->` [game/reset-fibonacci-boxes](#reset-fibonacci-boxes) <br/><br/>


___

### give-grid-size-info
In order to create game. You should create playground first. To do that that is the first endpoint you should call

**Parameters**

|   Name | Required | Type | Description                          |
|-------:|:--------:|:----:|--------------------------------------|
| `size` | required | int  | The size for create playground grid. |

**Response**

```
void
```
___


### get-play-ground
In order to get playground this endpoint should call

**Response**

```
{
    "boxes": [
        [
            {
                "x": 0,
                "y": 0,
                "value": 0,
                "isFibonacci": false
            }
        ]
    ]
        "isThereAnyFibonacci": false
}
```
___

### set-pressed-grid-coordination
The endpoint used to send the x and y coordinates of a box when a user clicks on it within the playground. Through this endpoint, the values of other boxes are calculated, and it is checked whether a Fibonacci series is formed on the playground.

**Parameters**

|     Name | Required | Type | Description            |
|---------:|:--------:|:----:|------------------------|
|    `row` | required | int  | Pressed x coordination |
|
| `column` | required | int  | Pressed y coordination |

**Response**

```
void
```
___

___

### reset-fibonacci-boxes

A separate endpoint has been created to display the calculated numbers on the screen once and inform the user. This endpoint is called after the user notification, and it ensures that the values of the relevant boxes containing Fibonacci series are reset.

**Response**

```
{
    "boxes": [
        [
            {
                "x": 0,
                "y": 0,
                "value": 0,
                "isFibonacci": false
            }
        ]
    ]
        "isThereAnyFibonacci": false
}
```

## Authors


Berkan Özel<br>
[@LinkedIn_Profile](https://www.linkedin.com/in/berkan-%C3%B6zel/)
