import java.util.Scanner;

public class HJ29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            System.out.println(encode(sc.nextLine()));
            System.out.println(decode(sc.nextLine()));
        }
    }

    //加密函数
    private static String encode(String code){
        char[] ch = code.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] >= 'a' && ch[i] < 'z'){
                ch[i] = (char)(ch[i] -'a' + 'A' + 1);
            }else if (ch[i] == 'z'){
                ch[i] = 'A';
            }else if (ch[i] == 'Z'){
                ch[i] = 'a';
            }else if (ch[i] >= '0' && ch[i] < '9'){
                ch[i] = (char) (ch[i] + 1);
            } else if (ch[i] == '9') {
                ch[i] = '0';
            }
        }
        return String.valueOf(ch);
    }

    //解密函数
    private static String decode(String password){
        char[] ch = password.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] > 'a' && ch[i] <= 'z'){
                ch[i] = (char) (ch[i] - 'a' + 'A' -1);
            } else if (ch[i] == 'a') {
                ch[i] = 'Z';
            }else if (ch[i] > 'A' && ch[i] <= 'Z'){
                ch[i] = (char) (ch[i] - 'A' + 'a' - 1);
            }else if (ch[i] == 'A'){
                ch[i] = 'z';
            }else if(ch[i] > '0' && ch[i] <= '9'){
                ch[i] = (char) (ch[i] - 1);
            }else if (ch[i] == '0'){
                ch[i] = '9';
            }
        }
        return String.valueOf(ch);
    }
}
