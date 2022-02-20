package io.shine.tools.math;

public class MathUtils {
    public static int getPourcentage(int value, int max){
        return (value/max)*100;
    }

    public static int linearConvert(int currentValue, int originalMin, int originalMax, int newMin, int newMax) {
        return (((currentValue - originalMin) * (newMax - newMin)) / (originalMax - originalMin)) + newMin;
    }

    public static int linearConvert(int currentValue, int originalMin, int originalMax) {
        return linearConvert(currentValue, originalMin, originalMax, 0, 100);
    }

    public static int pourcentageToValue(int pourcentage, int max){
        return max*(pourcentage/100);
    }


}
