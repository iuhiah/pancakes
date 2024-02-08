Short program that flips pancakes. Question is taken from CS2040S Recitation 2 handout (AY 23/24 S2).

### (Summarized) Problem Statement:
Given a stack of pancakes with varying sizes produced, your goal is to organize it with the smallest on top and the biggest at the bottom. Since you are holding a plate of pancakes in one hand, you only have one hand free to flip the pancakes. The only way to reorganize the pancakes is to pick up some pancakes from the top of the stack and flip them over.

![Example illustration of flipping pancake stack](https://github.com/iuhiah/pancakes/blob/main/src/example.png?raw=true)

Additionally, all pancakes will have a randomly burnt side. It was decided that the stacks are to be presented to the customers such that the burnt side of every pancake faces down. 

### Input:
The input file is expected to contain `n+1` line of integers where:
- The first line contains a single integer `n`, for the number of pancakes.
- The next `n` lines include the size of each pancake, as well as a `0` or `1` to indicate whether the burnt side of the pancake is facing up.
    - `0` - burnt side down, `1` - burnt side up

`RNG.java` is used to generate random inputs for the program. It can be run independently or in the main method in `PancakeStack.java` (default).
_Note: The default file paths expect the project to be run from the root folder._

### Solution:
(Where `n` is the number of pancakes and `i = n - round`)
Bring the `i`th smallest (biggest unsorted) pancake to the top, then flip it above the `i+1`th smallest pancake. Repeat this process for `n` pancakes.

Loop invariant: Bottom `i` pancakes are always sorted with burnt side down.


**To-do:**
- [x] Add burnt pancakes
- [ ] Handle non-distinct pancake sizes