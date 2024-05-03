import java.util.*;

public class HJ23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            char[] chs = str.toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            for(char ch : chs){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            Collection<Integer> values = map.values();
            Integer min = Collections.min(values);
            for(char key : map.keySet()){
                if(map.get(key) == min){
                    str = str.replaceAll(String.valueOf(key), "");
                }
            }
            System.out.println(str);

        }
    }
}
