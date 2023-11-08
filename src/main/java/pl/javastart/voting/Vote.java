package pl.javastart.voting;

// klasa pomocnicza, możesz ją dowolnie zmieniać, albo usunąć
public class Vote {

    private final String voter;
    private final Boolean vote; // true - ZA, false - PRZECIW, null - wstrzymanie się

    public Vote(String voter, Boolean vote) {
        this.voter = voter;
        this.vote = vote;
    }

    public String getVoter() {
        return voter;
    }

    @Override
    public String toString() {
        String voteResult = (vote == null) ? "WSTRZYMAŁ SIĘ" : (vote.equals(true) ? "ZA" : "PRZECIW");

        return voter + ": " + voteResult;
    }
}
