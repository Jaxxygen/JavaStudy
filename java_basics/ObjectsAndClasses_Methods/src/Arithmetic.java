public class Arithmetic {
    private int a;
    private int b;

    public Arithmetic (int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int sum () {
        int sum = a + b;
        return sum;
    }
    public int multip () {
        int multip = a * b;
        return multip;
    }
    public int max () {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
    public int min () {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

}
