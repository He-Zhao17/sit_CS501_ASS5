import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class C12E13 {
    //JFileChooser
    public static void main(String[] args) throws Exception {
        System.out.println("This tool allow you to find a \".txt\" file and return how many characters, words and lines.");



        try {
            Scanner scann = new Scanner(System.in);
            outer1:
            while (true) {
                while (true) {
                    System.out.println("Now please input 0 to quit and input 1 to find the document. ");
                    String choose = scann.next();
                    if (choose.equals("0")){
                        break outer1;
                    } else  if (choose.equals("1")) {
                        break;
                    } else
                    {
                        System.out.println("Incorrect input. Please input 0 to quit and input 1 to find the document.");
                    }
                }



                System.out.println("Now please input the name of the file, with the \".txt\" extention.");
                String fName = scann.next();
                File file = new File(fName);
                if (file.exists()) {
                    Scanner fileText = new Scanner(file);
                    int numOfLines = 0;
                    int numOfCharacters = 0;
                    int numOfWords = 0;
                    while (fileText.hasNextLine()) {
                        String currentLine = fileText.nextLine();
                        numOfLines++;
                        String[] words = currentLine.split(" ");
                        numOfWords += words.length;
                        for (int i = 0; i < words.length; i++) {
                            numOfCharacters += words[i].length();
                        }
                    }
                    fileText.close();
                    System.out.println(fName + " has " + numOfLines + " lines, " + numOfWords + " words and " + numOfCharacters + " characters.");
                    System.out.println("\nDo you want to check another file? If yes please input 1, and if not please input 0.");

                } else {
                    throw new Exception("This file is not existed in the path.");
                }
            }
            scann.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
