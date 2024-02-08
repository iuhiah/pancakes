Short program that flips pancakes. Question is taken from CS2040S Recitation 2 handout (AY 23/24 S2).

## (Summarized) Problem statement:
Given a stack of pancakes with varying sizes produced, your goal is to organize it with the smallest on top and the biggest at the bottom. Since you are holding a plate of pancakes in one hand, you only have one hand free to flip the pancakes. The only way to reorganize the pancakes is to pick up some pancakes from the top of the stack and flip them over.

![Example illustration of flipping pancake stack](https://github.com/iuhiah/pancakes/blob/main/src/example.png?raw=true)

## Input:
_Note: This folder is set up as an IntelliJ project. The input has been redirected to read from the `input` file in the `src` folder, but can be changed under the project configuration settings._

Input file contains a line of integers where:
- The first integer `n` is the number of pancakes.
- The next `n` integers are the sizes of the pancakes.

## Solution:
Sort the two smallest unsorted pancakes at a time. Bring the smaller pancake to the top of the stack, then flip it to be above the next smallest pancake. Repeat until the largest pancake is at the bottom of the stack, at which point the stack is sorted.

Loop invariant: The `i` smallest pancakes are always sorted.