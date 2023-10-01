package edu.uoc.pac1;

public class PAC1Ex3 {

    static double[] dailyServiceCharges = {4.52, 5.05, 4.84, 5.27, 4.78, 5.39, 4.99};

    static double[][] unitRatesPerDay = {
            {0.234, 0.456, 0.789, 0.101, 0.123, 0.567, 0.890},
            {0.234, 0.567, 0.890, 0.112, 0.345, 0.678, 0.901},
            {0.345, 0.678, 0.901, 0.223, 0.456, 0.789, 0.012},
            {0.456, 0.789, 0.012, 0.334, 0.567, 0.890, 0.123},
    };

    public static double twoDecimals(double number) {
        return Math.round(number * 100d) / 100d;
    }

    public static double calculateTotalBill(int[][] unitsPerMonth) {
        double totalBill = 0;

        for (int day = 0; day < 7; day++) {
            int unitatsDia = unitsPerMonth[0][day];
            double preuUnitatDia = unitRatesPerDay[0][day];  
            double costTiered = calculateTieredPricing(unitatsDia);
            double costosAddicionals = calculateAdditionalCharges(unitatsDia);
            double taxaFixaDia = dailyServiceCharges[day];

            double costDia = (unitatsDia * preuUnitatDia) + costTiered + costosAddicionals + taxaFixaDia;
            totalBill += costDia;
        }

        return twoDecimals(totalBill);
    }

    public static double calculateDiscount(int daysUnderFiftyUnits, double totalBill) {
        double discount = 0;

        if (daysUnderFiftyUnits >= 10) {
            discount = totalBill * 0.20;
        } else if (daysUnderFiftyUnits >= 5) {
            discount = totalBill * 0.10;
        }

        return twoDecimals(discount);
    }

    public static double calculateAdditionalCharges(int units) {
        double additionalCharges = 0;


        if (units > 300) {
            additionalCharges = units * 0.02;
        }

        return twoDecimals(additionalCharges);
    }

    public static double calculateTieredPricing(int units) {
        double cost = 0;

        if (units <= 300) {
            cost = units * 0.04;
        } else if (units <= 600) {
            cost = (300 * 0.04) + ((units - 300) * 0.06);
        } else {
            cost = ((300 * 0.04) + (300 * 0.06)) + ((units - 600) * 0.014);
        }

        return twoDecimals(cost);
    }
}