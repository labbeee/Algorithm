import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HJ26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            String res = sort(str);
            System.out.println(res);
        }
    }
    public static String sort(String str){
        ArrayList<Character> letters = new ArrayList<>();
        for(char ch : str.toCharArray()){
            if(Character.isLetter(ch)){
                letters.add(ch);
            }
        }
        letters.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Character.toLowerCase(o1) - Character.toLowerCase(o2);
            }
        });
        StringBuilder result = new StringBuilder();
        for (int i = 0, j = 0; i < str.length(); i++) {
            if(Character.isLetter(str.charAt(i))){
                result.append(letters.get(j++));
            }else{
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
}
