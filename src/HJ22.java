import java.util.Scanner;

public class HJ22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            if(num == 0){
                break;
            }else{
                countCola(num, 0);
            }

        }
    }

    private static void countCola(int num, int count) {
        int chuShu = num / 3;  //如： 10 / 3 = 3
        int yuShu = num % 3;   // 10 % 3 = 1
        count = count + chuShu;  //3
        num = chuShu + yuShu;    //4
        if(num == 1){
            System.out.println(count);
            return;
        }
        if(num == 2 || num == 3){
            count++;
            System.out.println(count);
        }else{
            countCola(num, count);
        }
    }
}
