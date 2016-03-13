# cookie-monster
*Help Cookie Monster eat the most cookies.*

*Based on the problem from [Ruby Quiz](http://rubyquiz.strd6.com/quizzes/178-cookie-monster).*

## Table of Contents
* **[Overview](#overview)**
* **[Requirements](#requirements)**
* **[Running](#running)**
* **[Examples](#examples)**

## Overview
Description copied from [Ruby Quiz](http://rubyquiz.strd6.com/quizzes/178-cookie-monster):
>Cookie Monster is trying to walk through the Cookie Forest and consume as many cookies as possible. However, there are many different paths that Cookie Monster can take, and he isn’t sure which way is the best way. Help him eat as many cookies as possible by writing a program which finds the optimal path from the upper left part of the forest to the bottom right. Cookie Monster can only move south and east. There are also several thorn patches through which he cannot cross. The forest can be represented as a grid of numbers, where the number represents the amount of cookies in that acre and -1 represents an impassible thorn patch.

## Requirements
* Java 1.8

## Running
The most recent build of the project is located in the `latest-build` folder. It can be ran using just `java -jar`:
```
java -jar latest-build\cookie-monster-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```

## Examples
* Forest with no route `(src/test/resources/forestSolver/noRoutes.txt)`
```
11 12 -1
21 -1 -1
-1 32 33
```
* Example run:
```
java -jar latest-build\cookie-monster-0.0.1-SNAPSHOT-jar-with-dependencies.jar src\test\resources\forestSolver\noRoutes.txt
....
The best route is:
Is valid?: false
Number of cookies: -1
Coordinates:
```
* Forest with one route `(src/test/resources/forestSolver/oneRoute.txt)`
```
11 12 13
-1 22 -1
31 32 33
```
* Example run:
```
java -jar latest-build\cookie-monster-0.0.1-SNAPSHOT-jar-with-dependencies.jar src\test\resources\forestSolver\oneRoute.txt
....
The best route is:
Is valid?: true
Number of cookies: 110
Coordinates:
(0, 0), (0, 1), (1, 1), (2, 1), (2, 2),
```
* Forest with multiple routes `(src/test/resources/forestSolver/multipleRoutes.txt)`
```
11 12 13
21 22 23
31 32 33
```
* Example run:
```
java -jar latest-build\cookie-monster-0.0.1-SNAPSHOT-jar-with-dependencies.jar src\test\resources\forestSolver\multipleRoutes.txt
....
The best route is:
Is valid?: true
Number of cookies: 128
Coordinates:
(0, 0), (1, 0), (2, 0), (2, 1), (2, 2),
```
