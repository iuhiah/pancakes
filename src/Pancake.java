public class Pancake {
    public int size;
    public boolean burntSide;

    public Pancake(int size, int burntSide) {
        this.size = size;
        this.burntSide = (burntSide == 1);
    }
    
    @Override
    public String toString() {
        return Integer.toString(this.size) +
               (this.burntSide ? " (burnt) " : " ");
    }
}
