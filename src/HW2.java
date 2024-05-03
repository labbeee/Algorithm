import java.util.*;

class Player implements Comparable<Player> {
    int id;
    int goals;
    int maxConsecutiveGoals;
    List<Integer> missOrder;

    public Player(int id) {
        this.id = id;
        this.goals = 0;
        this.maxConsecutiveGoals = 0;
        this.missOrder = new ArrayList<>();
    }

    // Implement Comparable interface for custom sorting
    @Override
    public int compareTo(Player other) {
        // Implement comparison logic here based on the rules
        // Return -1 if this player should come before other, 1 if after, 0 if equal
        return 0;
    }
}

public class HW2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Number of players
        int m = scanner.nextInt(); // Number of training sessions

        // Create an array to store players
        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {
            players[i] = new Player(i + 1);
        }

        // Read input and preprocess player data
        for (int i = 0; i < n; i++) {
            String shots = scanner.next();
            int consecutiveGoals = 0;
            for (int j = 0; j < m; j++) {
                if (shots.charAt(j) == '1') {
                    players[i].goals++;
                    consecutiveGoals++;
                    players[i].maxConsecutiveGoals = Math.max(players[i].maxConsecutiveGoals, consecutiveGoals);
                } else {
                    consecutiveGoals = 0;
                    players[i].missOrder.add(j + 1); // Note the miss order
                }
            }
        }

        // Sort the players
        Arrays.sort(players);

        // Output the sorted player IDs
        for (Player player : players) {
            System.out.print(player.id + " ");
        }
    }
}
