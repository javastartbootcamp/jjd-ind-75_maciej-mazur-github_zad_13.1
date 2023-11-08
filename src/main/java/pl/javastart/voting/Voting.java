package pl.javastart.voting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Voting {

    public static void main(String[] args) {
        List<String> voters = new ArrayList<>();

        // możesz dowolnie dodawać / usuwać dane testowe
        voters.add("Jan Kowalski");
        voters.add("Zigniew Siobro");
        voters.add("Zbyszek Stonoga");

        Voting voting = new Voting();

        VotingResult votingResult = voting.executeVoting(voters, new Scanner(System.in));
        votingResult.printResults();

        votingResult.printVoteForVoter("Jan Kowalski");
        votingResult.printVoteForVoter("Zigniew Siobro");
        votingResult.printVoteForVoter("Zbyszek Stonoga");
    }

    /**
     * Uzupełnij metodę metodę, ale nie zmieniaj jej sygnatury! (typu tego, co przyjmuje i zwraca).
     * do wczytywania danych od użytkownika użyj scannera z parametru
     * Metoda powinna pobrać głos dla każdego przekazanego głosującego i zapisać wyniki głosowania do VotingResult
     */
    VotingResult executeVoting(List<String> voters, Scanner scanner) {
        List<Vote> results = new ArrayList<>();
        Boolean vote;
        int numberOfVotesFor = 0;
        int numberOfVotesAgainst = 0;
        int numberOfVotesAbstain = 0;

        if (!voters.isEmpty()) {
            for (String voter : voters) {
                System.out.printf("Jak głosuje %s? (z - za, p - przeciw, w - wstrzymanie się)%n", voter);
                vote = readVote(scanner);
                results.add(new Vote(voter, vote));

                /*/
                Poniżej "trick" optymalizacyjny, dzięki któremu nie trzeba później do statystyk
                "za", "przeciw" i "wstrzymał się" skanować za każdym razem całej listy
                 */
                if (vote == null) {
                    numberOfVotesAbstain++;
                } else if (vote.equals(false)) {
                    numberOfVotesAgainst++;
                } else if (vote.equals(true)) {
                    numberOfVotesFor++;
                }
            }
        }

        return new VotingResult(results, numberOfVotesFor, numberOfVotesAgainst, numberOfVotesAbstain);
    }

    private Boolean readVote(Scanner scanner) {
        String vote;

        while (true) {
            vote = scanner.nextLine();

            switch (vote) {
                case "z" -> {
                    return true;
                }
                case "p" -> {
                    return false;
                }
                case "w" -> {
                    return null;
                }
                default -> {
                    System.out.println("Zagłosowałeś niepoprawnie. Spróbuj ponownie (z - za, p - przeciw, w - wstrzymanie się)");
                }
            }
        }
    }
}
