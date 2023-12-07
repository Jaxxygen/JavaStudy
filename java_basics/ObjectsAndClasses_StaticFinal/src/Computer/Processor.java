import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Processor {

    private final double frequency;
    private final int coreAmount;
    private final ProcessorManufacturer type;
    private final double processorWeight;

    public Processor(double frequency, int coreAmount, ProcessorManufacturer type, double processorWeight) {
        this.frequency = frequency;
        this.coreAmount = coreAmount;
        this.type = type;
        this.processorWeight = processorWeight;
    }

    public double getFrequency() {
        return frequency;
    }

    public int getCoreAmount() {
        return coreAmount;
    }

    public ProcessorManufacturer getType() {
        return type;
    }

    public double getProcessorWeight() {
        return processorWeight;
    }

    @Override
    public String toString() {
        return "Processor {" +
                "частота =" + frequency +
                ", кол-во ядер =" + coreAmount +
                ", тип =" + type +
                ", вес =" + processorWeight +
                '}';
    }
}
