public class Pancake {
    public int size;
    // todo: add attr for burnt side

    public Pancake(int size) {
        this.size = size;
    }
    
    @Override
    public String toString() {
        return Integer.toString(this.size);
    }
}
