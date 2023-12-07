public class Screen {
    private final int diagonal;
    private final ScreenType type;
    private final double ScreenWeight;

    public Screen(int diagonal, ScreenType type, double weight) {
        this.diagonal = diagonal;
        this.type = type;
        this.ScreenWeight = weight;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public ScreenType getType() {
        return type;
    }

    public double getScreenWeight() {
        return ScreenWeight;
    }

    @Override
    public String toString() {
        return "Экран {" +
                "диагональ =" + diagonal +
                ", тип матрицы =" + type +
                ", вес =" + ScreenWeight +
                '}';
    }
}
