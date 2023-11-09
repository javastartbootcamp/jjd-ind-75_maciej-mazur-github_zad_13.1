package pl.javastart.voting;

// klasa pomocnicza, możesz ją dowolnie zmieniać, albo usunąć
public record Vote(String voter, Boolean vote) {

    @Override
    public String toString() {
        String voteResult = (vote == null) ? "WSTRZYMAŁ SIĘ" : (vote.equals(true) ? "ZA" : "PRZECIW");

        return voter + ": " + voteResult;
    }
}
