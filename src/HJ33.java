import java.util.Scanner;

public class HJ33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            String res = convert(str);
            System.out.println(res);
        }
    }
    public static String convert(String str) {
        int N = 4;
        // ipv4 -> int
        if (str.contains(".")) {
            String[] fields = str.split("\\.");
            long result = 0;
            for (int i = 0; i < N; i++) {
                result = result * 256 + Integer.parseInt(fields[i]);  // n*256 可以理解为在2进制下将n左移8位右补0， 因为2^8 = 256。可以对比十进制理解， n * 1000 相当于 n在十进制下整体左移3位(10^3 = 1000)，右补3个0
            }
            return "" + result;
        }
        // int -> ipv4
        else {
            long ipv4 = Long.parseLong(str);
            String result = "";
            for (int i = 0; i < N; i++) {
                result = ipv4 % 256 + "." + result;
                ipv4 /= 256;
            }
            return result.substring(0, result.length() - 1);
        }
    }

}
