/*
 * Practice for pancake flipping question in
 * CS2040S Recitation 2 handout (AY 23/24 S2).
 * author: iuhiah
 */

import java.util.Scanner;

public class PancakeStack {
    Pancake[] stack;
    int size;
    int max = 0;

    public PancakeStack(int[] sizes) {
        this.size = sizes.length;
        stack = new Pancake[size];

        // set max
        for (int i=0; i<size; i++) {
            stack[i] = new Pancake(sizes[i]);
            if (stack[i].size > stack[max].size) {
                max = i;
            }
        }
    }

    public void flipStack(int length) {
        // flip length number of pancakes
        Pancake[] temp = new Pancake[length];
        for (int i=0; i<length; i++) {
            temp[i] = stack[length-i-1];
        }
        System.arraycopy(temp, 0, stack, 0, length);

        // print stack after flipping
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
            // if max is not at bottom
            if (curr != round) { 
                // bring max to top, then to bottom
                this.flipStack(curr+1);
                this.flipStack(round+1);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i=0; i<this.size; i++) {
            s.append(this.stack[i]);
            s.append(" ");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sizes = new int[n];

        for (int i=0; i<n; i++) {
            sizes[i] = sc.nextInt();
        }
        PancakeStack stack = new PancakeStack(sizes);

        System.out.println(stack.toString());
        stack.sortStack();
    }
}
