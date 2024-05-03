import java.util.*;

public class HJ27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String[] ss = sc.nextLine().split(" ");
            int len = Integer.parseInt(ss[0]);
            String tar = ss[ss.length - 2];
            int k = Integer.parseInt(ss[ss.length - 1]);
            ArrayList<String> list = new ArrayList<>();
            for(int i = 1; i < len; i++){
                if(isBrother(tar,ss[i])){
                    list.add(ss[i]);
                }
            }
            int size = list.size();
            System.out.println(size);
            if(size >= k){
                Collections.sort(list);
                System.out.println(list.get((k - 1)));
            }
        }
    }

    public static boolean isBrother(String x, String y){
        if(x.length() != y.length() || y.equals(x)){
            return false;
        }
        char[] s = x.toCharArray();
        char[] j = y.toCharArray();
        Arrays.sort(s);
        Arrays.sort(j);
        return new String(s).equals(new String(j));
    }

}
