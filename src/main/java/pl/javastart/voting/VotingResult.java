package pl.javastart.voting;

import java.util.List;

/**
 * Możesz dodać kolejne metody i pola do klasy. Nie zmieniaj istniejących metod.
 */
public class VotingResult {
    private final List<Vote> results;
    private final int numberOfVotesFor;
    private final int numberOfVotesAgainst;
    private final int numberOfVotesAbstain;

    public VotingResult(List<Vote> results, int numberOfVotesFor, int numberOfVotesAgainst, int numberOfVotesAbstain) {
        this.results = results;
        this.numberOfVotesFor = numberOfVotesFor;
        this.numberOfVotesAgainst = numberOfVotesAgainst;
        this.numberOfVotesAbstain = numberOfVotesAbstain;
    }

    /**
     * Metoda powinna drukować wyniki głosowania w takiej postaci:
     * Głosów za: 56.53%
     * Głosów przeciw: 35.00%
     * Wstrzymało się: 8.47%
     */
    public void printResults() {
        // metoda powinna drukować wyniki głosowania
        int totalNumberOfVotes = numberOfVotesFor + numberOfVotesAgainst + numberOfVotesAbstain;
        System.out.printf("""
                        Głosów za: %.2f%%
                        Głosów przeciw: %.2f%%
                        Wstrzymało się: %.2f%%

                        """,
                (double) numberOfVotesFor / totalNumberOfVotes * 100,
                (double) numberOfVotesAgainst / totalNumberOfVotes * 100,
                (double) numberOfVotesAbstain / totalNumberOfVotes * 100);
    }

    /**
     * Metoda przyjmuje imię i nazwisko głosującego, np "Zigniew Siobro".
     * Uzupełnij tę metodę, żeby drukowała informację w formie:
     * Zigniew Siobro: ZA
     * Nie zmieniaj sygnatury tej metody!
     */
    public void printVoteForVoter(String voterName) {
        for (Vote result : results) {
            if (result.getVoter().equals(voterName)) {
                System.out.println(result);
                return;     // zakładam, że w liście żaden głosujący nie pojawi się więcej niż raz
            }
        }
    }
}
