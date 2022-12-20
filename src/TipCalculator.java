import java.util.Scanner;

public class TipCalculator {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // Total Amount
        double amtVal = getUserAmt(keyboard);
        // Tip Percent
        double tipPercent = getTipPercent(keyboard);
        // Number of People
        int numPerson = getNumPersons(keyboard);

        // Output
        System.out.println("amount = " + amtVal);
        System.out.println("tip percent = " + tipPercent);
        System.out.println("number of people = " + numPerson);
        double tipAmt = tipVal(amtVal,tipPercent);
        System.out.println("Val: " + tipAmt);
        System.out.println("Payment per Person: " + splitVal(tipAmt, numPerson));
    }

    public static double getUserAmt(Scanner keyboard) {
        System.out.print("Enter the total bill amount: ");
        String amount = keyboard.nextLine();
        while (isDouble(amount)) {
            System.out.println("ERROR!!! Wrong Input Received!");
            System.out.print("Enter the total bill amount: ");
            amount = keyboard.nextLine();
        }
        double amtVal = Double.parseDouble(amount);
        while (amtVal < 0.0) {
            System.out.println("ERROR!!! Bill Amount should be greater than 0");
            System.out.print("Enter the total bill amount: ");
            amount = keyboard.nextLine();
            amtVal = Double.parseDouble(amount);
        }
        return amtVal;
    }

    public static double getTipPercent(Scanner keyboard) {
        System.out.print("Enter the tip percentage: ");
        String tip = keyboard.nextLine();
        while (isDouble(tip)) {
            System.out.println("ERROR!!! Wrong Input Received!");
            System.out.print("Enter the tip percentage: ");
            tip = keyboard.nextLine();
        }
        double tipPercent = Double.parseDouble(tip);
        while (tipPercent < 0.0 || tipPercent > 100.0) {
            System.out.println("ERROR!!! Tip Percent should be between 0 and 100");
            System.out.print("Enter the tip percentage: ");
            tip = keyboard.nextLine();
            tipPercent = Double.parseDouble(tip);
        }
        return tipPercent;
    }

    public static int getNumPersons(Scanner keyboard) {
        System.out.print("Enter the number of people: ");
        String numPeople = keyboard.nextLine();
        while (isInteger(numPeople)) {
            System.out.println("ERROR!!! Wrong Input Received!");
            System.out.print("Enter the number of people: ");
            numPeople = keyboard.nextLine();
        }
        int numPerson = Integer.parseInt(numPeople);
        while (numPerson <= 0) {
            System.out.println("ERROR!!! Number of people should be greater than 0");
            System.out.print("Enter the tip percentage: ");
            numPeople = keyboard.nextLine();
            numPerson = Integer.parseInt(numPeople);
        }
        return numPerson;
    }

    public static boolean isDouble(String str) {
        try {
            double val = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    public static boolean isInteger(String str) {
        try {
            int val = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    public static double tipVal(double amount, double tip) {
        if(tip != 0) {
            double tipDec = tip / 100;
            double tipVal = tipDec * amount;
            return amount + tipVal;
        }
        return amount;
    }

    public static double splitVal(double totAmt, int numPeople) {
        double val = totAmt/numPeople;
        return Math.round(val * 100.0) / 100.0;
    }

}
