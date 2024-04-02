package practice.hospital;

import java.util.Arrays;

public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        float[] patientsTemperature = new float[patientsCount];
        for (int i = 0; i < patientsCount; i++) {
            float b = (float) Math.round((Math.random() * 8 + 32) * 10) / 10;
            patientsTemperature[i] = b;
        }
        return patientsTemperature;
    }
    public static String getReport(float[] temperatureData) {
        int healthyPatients = 0;
        float middleTemperature = 0;

        for (int i = 0; i < temperatureData.length; i++) {
            middleTemperature = middleTemperature + temperatureData[i];
            if (i == temperatureData.length - 1) {
                middleTemperature = (float) Math.round(middleTemperature/temperatureData.length * 100) / 100;
            }
        }

        for (float temperatureDatum : temperatureData) {
            if (temperatureDatum >= 36.2f && temperatureDatum <= 36.9f) {
                healthyPatients = healthyPatients + 1;
            }
        }
        String regex = "[^0-9 .]";
        String massiveFormat = Arrays.toString(temperatureData);
        massiveFormat = massiveFormat.replaceAll(regex,"");



        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
            Округлите среднюю температуру с помощью Math.round до 2 знаков после запятой,
            а температуры каждого пациента до 1 знака после запятой
        */

        return "Температуры пациентов: " + massiveFormat +
        "\nСредняя температура: " + middleTemperature +
        "\nКоличество здоровых: " + healthyPatients;
    }
}
