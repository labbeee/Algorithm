import java.util.Scanner;

public class HJ21 {
    public static void main(String[] args) {
        char[] array = new char[]{'2', '2', '2', '3', '3', '3', '4', '4', '4', '5', '5', '5', '6','6', '6', '7', '7', '7', '7', '8', '8', '8', '9', '9', '9', '9'};
        StringBuilder res = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            char[] chars = str.toCharArray();
            for(char ch : chars){
                if(ch >= '0' && ch <= '9'){
                    res.append(ch);
                }else if(ch >= 'A' && ch <= 'Y'){
                    char newChar = (char) (ch + 'a' - 'A' + 1);
                    res.append(newChar);
                } else if (ch == 'Z') {
                    res.append('a');
                } else if(ch >= 'a' && ch <= 'z'){
                    res.append(array[ch - 'a']);
                }else{
                    res.append(ch);
                }
            }
        }
        System.out.println(res);
    }
}
