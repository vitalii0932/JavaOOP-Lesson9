package Exercise3;

public class CharsCount implements Comparable{
    private char c;
    private int count;

    public CharsCount() {
    }

    public CharsCount(char c) {
        this.c = c;
        count = 1;
    }

    public void setC(char c) {
        this.c = c;
    }

    public char getC() {
        return c;
    }

    public void setCount() {
        this.count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int compareTo(Object o) {
        CharsCount newCharsCount = (CharsCount) o;
        if(this.count > newCharsCount.count) {
            return 1;
        }
        if(this.count < newCharsCount.count) {
            return -1;
        }
        return count - newCharsCount.getCount() > 0 ? -1 : 1;
    }

    @Override
    public String toString() {
        return  c + " -> " + count;
    }
}
