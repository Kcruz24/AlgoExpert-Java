package TournamentWinner;

import java.util.*;

public class TournamentWinnerApp
{
    public static void main(String[] args) {
        List<List<String>> competitions = new ArrayList<>();
        List<String> innerList = Arrays.asList("HTML", "C#");
        competitions.add(innerList);

        innerList = Arrays.asList("C#", "Python");
        competitions.add(innerList);

        innerList = Arrays.asList("Python", "HTML");
        competitions.add(innerList);

        List<Integer> results = Arrays.asList(0, 0, 1);

        System.out.println(tournamentWinner(competitions, results));
    }

    public static void testEntrySet() {
        Map<String, Integer> map = new HashMap<>() {{
            put("Paola", 9);
            put("Peola", 9);
            put("Diego", 25);
            put("Hector", 5);
            put("David", 0);
        }};

        System.out.println(map.entrySet());
    }

    // O(N) time - where N is the size of the competitions || O(K) space - where K is the number of teams
    public static String tournamentWinner(List<List<String>> competitions, List<Integer> results) {
        List<String> winnerTeams = new ArrayList<>();
        Map<String, Integer> scores = new HashMap<>();

        for (int i = 0; i < competitions.size(); i++) {
            if (results.get(i) == 1) {
                winnerTeams.add(competitions.get(i).get(0));
            } else if (results.get(i) == 0) {
                winnerTeams.add(competitions.get(i).get(1));
            }
        }

        for (int i = 0; i < competitions.size(); i++) {
            scores.put(winnerTeams.get(i), Collections.frequency(winnerTeams, winnerTeams.get(i)));
        }

        return Collections.max(scores.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static String tournamentWinnerV2(List<List<String>> competitions, List<Integer> results) {
        Map<String, Integer> scores = new HashMap<>();
        int points = 0;

        for (int i = 0; i < competitions.size(); i++) {
            for (int j = 0; j < 1; j++) {
                if (results.get(i) == 1) {
                    points += 3;
                    scores.put(competitions.get(i).get(0), points);
                } else if (results.get(i) == 0) {
                    points += 3;
                    scores.put(competitions.get(i).get(1), points);
                }
            }
        }

        return Collections.max(scores.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
