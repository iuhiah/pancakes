/*
 * Practice for pancake flipping question in
 * CS2040S Recitation 2 handout (AY 23/24 S2).
 * author: iuhiah
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class PancakeStack {
    Pancake[] stack;
    int size;
    int max = 0;

    public PancakeStack(Pancake[] pancakes, int max) {
        this.stack = pancakes;
        this.size = pancakes.length;
        this.max = max;
    }

    public void flipStack(int length) {
        // flip length number of pancakes
        Pancake[] temp = new Pancake[length];
        for (int i=0; i<length; i++) {
            // flip burnt side
            temp[i] = new Pancake(this.stack[length-i-1].size,
                                  (this.stack[length-i-1].burntSide) ? 0 : 1);
        }
        System.arraycopy(temp, 0, stack, 0, length);

        // uncomment to print stack after flipping
        System.out.println(this.toString());
    }

    public int findNext(int round) {
        // find next biggest pancake
        if (round == this.size-1) {
            return this.max;
        } else {
            int next = 0;
            for (int i=0; i<round+1; i++) {
                next = (this.stack[i].size > this.stack[next].size)
                        ? i : next;
            }
            return next;
        }
    }

    public void sortStack() {
        // bring current largest pancake to bottom
        int curr;

        for (int round = this.size-1; round > 0; round--) {
            curr = this.findNext(round);

            // if largest pancake is not at bottom
            // or burnt side is up
            if ((curr != round) || (this.stack[curr].burntSide)) {
                // bring max to top
                this.flipStack(curr+1);
                
                // bring burnt side up before flipping down
                // so burnt side will be at bottom
                if (!this.stack[0].burntSide) {
                    this.flipStack(1);
                }

                // bring pancake back to bottom
                this.flipStack(round+1);
            }
        }
        // check top pancake
        if (this.stack[0].burntSide) {
            this.flipStack(1);
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i=0; i<this.size; i++) {
            s.append(this.stack[i]);
        }
        return s.toString();
    }

    // attempts to read input from file
    // rng will create input file if not found
    public static Scanner readFile(String filename) throws RuntimeException {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader(filename));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return sc;
    }

    public static void main(String[] args) {
        // change to input file path
        String filename = "./src/input";

        // comment out use same input
        RNG.main(new String[] {filename});

        // reading input
        Scanner sc = readFile(filename);
        int n = sc.nextInt();
        Pancake[] pancakes = new Pancake[n];

        int largest = 0;
        for (int i=0; i<n; i++) {
            pancakes[i] = new Pancake(sc.nextInt(), sc.nextInt());
            largest = (pancakes[i].size > pancakes[largest].size) ? i : largest;
        }
        PancakeStack stack = new PancakeStack(pancakes, largest);

        System.out.println(stack.toString());
        stack.sortStack();
        System.out.println(stack.toString());
    }
}
