/*
 * Practice for pancake flipping question in
 * CS2040S Recitation 2 handout (AY 23/24 S2).
 * author: iuhiah
 */

import java.util.Scanner;

public class PancakeStack {
    Pancake[] stack;
    int size;
    int min;
    int max;

    public PancakeStack(int[] sizes) {
        this.size = sizes.length;
        stack = new Pancake[size];

        // set min and max
        min = max = 0;

        for (int i=0; i<size; i++) {
            stack[i] = new Pancake(sizes[i]);
            if (stack[i].size < stack[min].size) {
                min = i;
            } else if (stack[i].size > stack[max].size) {
                max = i;
            }
        }
    }

    public void flipStack(int length) {
        // flip stack from start to end (inclusive)
        Pancake[] temp = new Pancake[length];
        for (int i=0; i<length; i++) {
            temp[i] = stack[length-i-1];
        }
        System.arraycopy(temp, 0, stack, 0, length);

        // update min and max if flipped
        this.min = (this.min < length) ? length - this.min - 1 : this.min;
        this.max = (this.max < length) ? length - this.max - 1 : this.max;

        // print stack after flipping
        System.out.println(this.toString());
    }

    public int findNext(int curr) {
        // find next smallest element
        int next = this.max;
        for (int i=0; i<this.size; i++) {
            next = ((this.stack[i].size > this.stack[curr].size)
                    && (this.stack[i].size < this.stack[next].size))
                    ? i : next;
        }
        return next;
    }

    public void sortStack() {
        // bring next pancake in order to top
        int curr = this.min;
        int next = findNext(curr);
        boolean sorted = false;

        while (!sorted) {
            if (next != curr + 1) {
                if (curr == next) {
                    // end of stack reached
                    // stack sorted
                    sorted = true;
                } else {
                    // pair not in order found
                    // bring smaller to top
                    flipStack(curr+1);
                    // flip smaller to be above bigger
                    next = (next < curr) ? curr - next : next;
                    flipStack(next);

                    // continue with next pair
                    // new curr is old next
                    curr = next;
                    next = findNext(curr);
                }

            } else if (next == this.max) {
                // reached largest pancake
                // pair not separated

                if (next == this.size-1) {
                    // if largest pancake is at bottom
                    // stack sorted
                    sorted = true;
                } else {
                    if (next != 0) {
                        // smaller pancake at top
                        // bring largest to top
                        flipStack(next+1);
                    }

                    flipStack(this.size);
                    // reset values
                    curr = this.min;
                    next = findNext(curr);
                }
            } else {
                // find next smallest separated pair
                curr = next;
                next = findNext(curr);
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
