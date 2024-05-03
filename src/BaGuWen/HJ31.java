package BaGuWen;

import java.util.Scanner;

public class HJ31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputStr = null;
        String outputStr = null;
        while (sc.hasNextLine()){
            inputStr = sc.nextLine();
            String[] splitStr = inputStr.split("[^a-zA-Z]");
            StringBuilder reverseStr = new StringBuilder();
            for (int i = splitStr.length - 1; i >= 0; i--){
                reverseStr.append(splitStr[i]).append(" ");
            }
            outputStr = reverseStr.toString().trim();
            System.out.println(outputStr);
        }
    }
}
