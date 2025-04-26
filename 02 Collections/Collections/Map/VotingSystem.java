package Map;

import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteCountMap = new HashMap<>();         // Candidate -> Votes
    private Map<String, Integer> insertionOrderMap = new LinkedHashMap<>(); // Insertion Order

    public void vote(String candidate) {
        voteCountMap.put(candidate, voteCountMap.getOrDefault(candidate, 0) + 1);
        insertionOrderMap.put(candidate, voteCountMap.get(candidate));
    }

    public void displayVotesInInsertionOrder() {
        System.out.println("Votes (Insertion Order):");
        for (Map.Entry<String, Integer> entry : insertionOrderMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void displayVotesSorted() {
        TreeMap<String, Integer> sortedMap = new TreeMap<>(voteCountMap);
        System.out.println("Votes (Sorted by Candidate):");
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        VotingSystem vs = new VotingSystem();
        vs.vote("Alice");
        vs.vote("Bob");
        vs.vote("Alice");
        vs.vote("Carol");

        vs.displayVotesInInsertionOrder();
        System.out.println();
        vs.displayVotesSorted();
    }
}

