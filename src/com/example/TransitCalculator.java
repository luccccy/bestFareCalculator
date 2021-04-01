package com.example;
import java.util.*;
public class TransitCalculator {
    int numOfDays;
    int numOfRides;
    String[] fareOptions = {"Pay-per-day", "7-day", "30-day"};
    double[] fares = new double[3];

    public TransitCalculator(int days, int rides) {
        this.numOfDays = days;
        this.numOfRides = rides;
    }

    public static void main(String[] args) {
        TransitCalculator myTransit = new TransitCalculator(22, 16);
        double jack = myTransit.unlimited7Price();
        myTransit.getRidePrices(jack);
        String lucy = myTransit.getBestFare();
        System.out.println(lucy);

    }

    public double unlimited7Price() {
        double perPriceOf7;
        if(numOfDays > 0 && numOfDays <= 7) {
            perPriceOf7 = 33.00 / numOfRides;
            return perPriceOf7;
        }
        else if (numOfDays > 7 && numOfDays <= 14) {
            perPriceOf7 = 66.00 / numOfRides;
            return perPriceOf7;
        }
        else if (numOfDays > 14 && numOfDays <= 21) {
            perPriceOf7 = 99.00 / numOfRides;
            return perPriceOf7;
        }
        else {
            perPriceOf7 = 132.00 / numOfRides;
            return perPriceOf7;
        }
    }

    public double[] getRidePrices(double perPrice) {
        fares[0] = 2.75;
        fares[1] = perPrice;
        fares[2] = 127.00 / numOfRides;
        System.out.println(Arrays.toString(fares));
        return fares;
    }

    public String getBestFare() {
        double minFare = fares[0];
        String option = fareOptions[0];
      for (int i = 1; i < fares.length; i++) {
          if(fares[i] < minFare) {
              minFare = fares[i];
              option = fareOptions[i];
          }
      }
        return "You should get the " + option + " option at $" + minFare  + " per ride.";
    }


}
