package edu.uoc.pac1;

public class PAC1Ex2 {

    public static int divsSum(int num) {
        int suma = 0;

        // Si num es divisible per i
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                suma += i;
            }
        }

        if (suma <= 0) {
            return -1;
        }

        return suma;
    }

    public static boolean isAbundant(int number) {
        return number > 0 && divsSum(number) > number;
    }

    public static boolean isPerfect(int number) {
        return number > 0 && divsSum(number) == number;
    }

    public static boolean isDeficient(int number) {
        return number > 0 && divsSum(number) < number;
    }

    public static void categorize(int[] numbers) {
        int perfect = 0, abundant = 0, deficient = 0;

        for (int num : numbers) {
            if (isPerfect(num)) {
                perfect++;
            } else if (isAbundant(num)) {
                abundant++;
            } else if (isDeficient(num)) {
                deficient++;
            }
        }
        System.out.println("There are: " + perfect + " perfect numbers.");
        System.out.println("There are: " + abundant + " abundant numbers.");
        System.out.println("There are: " + deficient + " deficient numbers.");
    }

}