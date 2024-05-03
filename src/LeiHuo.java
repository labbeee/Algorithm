import java.util.*;

public class LeiHuo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        while (sc.hasNextLine()){
            //sb.append(sc.nextLine() + " ");
            list.add(sc.nextLine());
        }
        //System.out.println(list);
        //System.out.println(list.get(0));

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String[] s = str.split(" ");
            int key = Integer.parseInt(s[0]);
            ArrayList<Integer> actionList = new ArrayList<>();
            List<Integer> action = map.getOrDefault(key, actionList);
            action.add(Integer.parseInt(s[1]));
            map.put(key, action);
        }
//        for (int k : map.keySet()){
//            System.out.println(k);
//            System.out.println(map.get(k));
//        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int k : map.keySet()){
            List<Integer> a = map.get(k);
            for (int i = 0; i < a.size()-1; i++) {
                if(a.get(i) == 0 && a.get(i+1) == 0){
                    res.add(k);
                    System.out.println(res.toString());
                }
            }
        }
    }
}
