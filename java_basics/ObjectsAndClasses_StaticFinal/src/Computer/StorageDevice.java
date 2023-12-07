public class StorageDevice {
    private final StoageDeviceType type;
    private final double storageDeviceVolume;
    private final double storageDeviceWeight;

    public StorageDevice(StoageDeviceType type, double storageDeviceVolume, double storageDeviceWeight) {
        this.type = type;
        this.storageDeviceVolume = storageDeviceVolume;
        this.storageDeviceWeight = storageDeviceWeight;
    }

    public StoageDeviceType getType() {
        return type;
    }

    public double getStorageDeviceVolume() {
        return storageDeviceVolume;
    }

    public double getStorageDeviceWeight() {
        return storageDeviceWeight;
    }

    @Override
    public String toString() {
        return "Накопитель {" +
                "тип =" + type +
                ", объем =" + storageDeviceVolume +
                ", вес =" + storageDeviceWeight +
                '}';
    }
}
