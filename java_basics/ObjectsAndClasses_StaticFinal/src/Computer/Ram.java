public class Ram {
    private final RamType type;
    private final double ramVolume;
    private final double ramWeight;

    public Ram(RamType type, double ramVolume, double ramWeight) {
        this.type = type;
        this.ramVolume = ramVolume;
        this.ramWeight = ramWeight;
    }

    public RamType getType() {
        return type;
    }

    public double getRamVolume() {
        return ramVolume;
    }

    public double getRamWeight() {
        return ramWeight;
    }

    @Override
    public String toString() {
        return "Оперативная память {" +
                "тип =" + type +
                ", объем e=" + ramVolume +
                ", вес =" + ramWeight +
                '}';
    }
}
