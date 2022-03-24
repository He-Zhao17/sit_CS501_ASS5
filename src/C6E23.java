import java.util.Scanner;

public class C6E23 {

    public static int count (String str, char a) {
        try {
            int k = 0;
            for (int i = 0; i < str.length(); i++ ){
                if (str.charAt(i) == a) {
                    k++;
                }
            }
            return k;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public static void main (String[] args) {
        System.out.println("This tool is to get the number of the occurrences of a specified character in a string.");
        System.out.println("The rule of the string is:");
        System.out.println("1. The size of the string is at least 1 and at most 100.");
        System.out.println("2. Must be consist of digits and letter.");
        System.out.println("\nThe rule of the character to be searched:");
        System.out.println("Must be a letter or digit.");

        boolean cont = true;
        Scanner scan = new Scanner(System.in);
        outer1:
        while (cont) {
            try {
                System.out.print("\nNow input the string as the rule below or quit by inputting N, end with enter: ");
                String str = scan.nextLine();
                if (str.equals("!")) {
                    break;
                }
                if (str.length() < 1 || str.length() >100) {
                    System.out.println("Error: Invalid size of the string. Please input again or quit by " +
                            "inputting !, end by enter.");
                    continue;
                }
                for (int i = 0; i < str.length(); i++) {
                    if (!Character.isLetterOrDigit(str.charAt(i))) {
                        System.out.println("Error: The string must be consist of letters or digits." +
                                " Please input again or quit by " +
                                "inputting !, end by enter.");
                        continue outer1;
                    }
                }
                System.out.println("Congratulations! The string input is valid.");
                boolean isCharValid = false;
                String c = "";
                while (!isCharValid) {
                    System.out.print("\nNow input the character to be searched with the rule below, end with enter: ");
                    c = scan.nextLine();
                    if (c.length() != 1) {
                        System.out.println("Error: You should input a character but not a string or null. Please input " +
                                "again or quit by inputting !, end by enter.");
                        continue;
                    }
                    if (c.equals("!")) {
                        break outer1;
                    }
                    if (!Character.isLetterOrDigit(c.charAt(0))) {
                        System.out.println("Error: You should input a letter or digit. Please input " +
                                "again or quit by inputting !, end by enter.");
                        continue;
                    }
                    isCharValid = true;
                }
                System.out.println("Congratulations! The character input is valid.");
                System.out.println("\nThe number of occurrences of \'" + c + "\' in \"" + str + "\" is " + count(str, c.charAt(0)));

                while (true) {
                    System.out.println("\n Do you want to check another? Y/N and end with enter.");
                    String ynStr = scan.nextLine();
                    if (ynStr.equals("Y")) {
                        continue outer1;
                    } else if (ynStr.equals("N")) {
                        break outer1;
                    } else {
                        System.out.println("Error. Please input Y/N, end with enter.");
                        continue;
                    }
                }




            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw e;
            }


        }

        scan.close();
    }
}
