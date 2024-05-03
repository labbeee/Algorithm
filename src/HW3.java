import java.util.*;

public class HW3 {

    static int[] findCohesiveGroups(int n, int[] edges) {
        List<List<Integer>> groups = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> group = new ArrayList<>();
                int current = i;
                while (!visited[current]) {
                    visited[current] = true;
                    group.add(current);
                    current = edges[current];
                }
                groups.add(group);
            }
        }
        return groups.stream()
                .sorted((g1, g2) -> {
                    int minId1 = Collections.min(g1);
                    int minId2 = Collections.min(g2);
                    int maxId1 = Collections.max(g1);
                    int maxId2 = Collections.max(g2);
                    int cohesion1 = g1.size() - countAccessible(g1, edges);
                    int cohesion2 = g2.size() - countAccessible(g2, edges);
                    if (cohesion1 != cohesion2) {
                        return cohesion2 - cohesion1; // Sort by cohesion
                    } else if (maxId1 != maxId2) {
                        return maxId2 - maxId1; // If cohesion is equal, sort by maximum id
                    } else {
                        return minId1 - minId2; // If maximum id is equal, sort by minimum id
                    }
                })
                .findFirst()
                .orElse(new ArrayList<>())
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    static int countAccessible(List<Integer> group, int[] edges) {
        Set<Integer> reachable = new HashSet<>(group);
        for (int service : group) {
            reachable.add(edges[service]);
        }
        return reachable.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] edges = new int[n];
        for (int i = 0; i < n; i++) {
            edges[i] = scanner.nextInt();
        }

        int[] result = findCohesiveGroups(n, edges);
        for (int service : result) {
            System.out.print(service + " ");
        }
    }
}
