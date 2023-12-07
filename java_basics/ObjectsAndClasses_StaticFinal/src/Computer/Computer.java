public class Computer {
    private String vendor;
    private String name;
    private Processor processor;
    private Ram ram;
    private StorageDevice storageDevice;
    private Screen screen;
    private Keyboard keyboard;

    public Computer(String vendor, String name, Processor processor,
                    Ram ram, StorageDevice storageDevice, Screen screen,
                    Keyboard keyboard) {
        this.vendor = vendor;
        this.name = name;
        this.processor = processor;
        this.ram = ram;
        this.storageDevice = storageDevice;
        this.screen = screen;
        this.keyboard = keyboard;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public StorageDevice getStorageDevice() {
        return storageDevice;
    }

    public void setStorageDevice(StorageDevice storageDevice) {
        this.storageDevice = storageDevice;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }
    public double totalComputerWeight() {
        double a = 0.0;
        a = a + ram.getRamWeight() + screen.getScreenWeight() + keyboard.getKeyboardWeight() +
                processor.getProcessorWeight() + storageDevice.getStorageDeviceWeight();
        return a;
    }


    @Override
    public String toString() {
        return "Компьютер {" +
                "производитель = '" + vendor + "'\n" +
                ", имя = '" + name + "'\n" +
                processor + '\n' +
                ram + '\n' +
                storageDevice +'\n' +
                screen + '\n' +
                keyboard +
                '}' + '\n' +
                "Общий вес комьютера: " + totalComputerWeight() + '\n';
    }
}
