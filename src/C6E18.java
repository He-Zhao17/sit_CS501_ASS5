import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class C6E18 {
    public static void main(String[] args) {
        System.out.println("This tool is to check whether the password input is valid.");
        System.out.println("The valid password rule is that: ");
        System.out.println("1. Must have at least 8 characters.");
        System.out.println("2. Must contain only letters and digits.");
        System.out.println("3. Must contain at least two digits.");

        String password = "";
        Scanner scan = new Scanner(System.in);
        boolean cont = true;
        int MAXSIZE = 100;
        while (cont) {
            System.out.print("\n\nPlease input the password (end with enter):");
            try {
                password = scan.nextLine();

                boolean isValid = true;
                if (password.length() > MAXSIZE) {
                    System.out.println("Too long password.");
                    continue;
                }
                if (password.length() < 8) {
                    isValid = false;
                    System.out.println("Invalid password: Less than 8 characters.");
                }
                ArrayList<Integer> wd = new ArrayList<>();
                int nd = 0;
                for (int i = 0; i < password.length(); i++) {
                    char c = password.charAt(i);
                    if (!Character.isLetterOrDigit(c)) {
                        wd.add(i + 1);
                    }
                    if (Character.isDigit(c)) {
                        nd++;
                    }
                }
                if (wd.size() > 0) {
                    isValid = false;
                    System.out.print("Invalid password: There is one or more characters which are not a letter or a digit." +
                            " Locations:");
                    for (int i = 0; i < wd.size(); i++) {
                        System.out.print(wd.get(i) + " ");
                    }
                    System.out.print("\n");
                }
                if (nd < 2) {
                    isValid = false;
                    System.out.println("Invalid password: Must contain 2 digits. You just have " + nd + ".");
                }
                if (isValid) {
                    System.out.println("Congratulations: This password is valid.");
                }

                boolean contYN = true;
                while (contYN) {
                    System.out.println("\nDo you want to check another password? (Y/N and end with enter.)");
                    String yn = scan.nextLine();
                    if (yn.equals("Y")) {
                        contYN = false;
                    } else if (yn.equals("N")) {
                        contYN = false;
                        cont = false;
                    } else {
                        System.out.println("Input error. Please input Y/N and end with enter.");
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
