public class Keyboard {
    private final KeyboardType type;
    private final boolean backlight;
    private final double keyboardWeight;

    public Keyboard(KeyboardType type, boolean backlight, double keyboardWeight) {
        this.type = type;
        this.backlight = backlight;
        this.keyboardWeight = keyboardWeight;
    }

    public KeyboardType getType() {
        return type;
    }

    public boolean isBacklight() {
        return backlight;
    }

    public double getKeyboardWeight() {
        return keyboardWeight;
    }

    @Override
    public String toString() {
        return "Клавиатура {" +
                "тип =" + type +
                ", наличие подсветки =" + backlight +
                ", вес =" + keyboardWeight +
                '}';
    }
}
