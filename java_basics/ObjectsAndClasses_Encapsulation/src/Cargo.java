import java.util.Scanner;

public class Cargo {


    private final Dimensions dimensions;
    private final double weight;

    private final String deliveryAdress;
    private final boolean overTurning;
    private final String registrationNumber;
    private final boolean fragility;

    public Cargo(Dimensions dimensions,
                 double weight,
                 String deliveryAdress,
                 boolean overTurning,
                 String registrationNumber,
                 boolean fragility) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAdress = deliveryAdress;
        this.overTurning = overTurning;
        this.registrationNumber = registrationNumber;
        this.fragility = fragility;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public double getWeight() {
        return weight;
    }

    public String getDeliveryAdress() {
        return deliveryAdress;
    }

    public boolean isOverTurning() {
        return overTurning;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean isFragility() {
        return fragility;
    }

    public Cargo setWeight(double weight) {
        return new Cargo(dimensions, weight, deliveryAdress, overTurning, registrationNumber, fragility);
    }

    public Cargo setDeliveryAdress(String deliveryAdress) {
        return new Cargo(dimensions, weight, deliveryAdress, overTurning, registrationNumber, fragility);
    }

    public Cargo setOverTurning(boolean overTurning) {
        return new Cargo(dimensions, weight, deliveryAdress, overTurning, registrationNumber, fragility);
    }

    public Cargo setRegistrationNumber(String registrationNumber) {
        return new Cargo(dimensions, weight, deliveryAdress, overTurning, registrationNumber, fragility);
    }

    public Cargo setFragility(boolean fragility) {
        return new Cargo(dimensions, weight, deliveryAdress, overTurning, registrationNumber, fragility);
    }

    public String toString() {
        return  dimensions + "\n" +
                "Вес груза: " + weight + "\n" +
                "Адрес доставки: " + deliveryAdress + "\n" +
                "Можно ли певорачивать: " + overTurning + "\n" +
                "Регистрационный номер: " + registrationNumber + "\n" +
                "Хрупкий: " + fragility + "\n";
    }
}
