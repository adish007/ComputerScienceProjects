
public class SoccerTeam implements IContestant {
    String country;
    String jerseyColor;
    boolean ritual;
    int wins;
    int losses;

    SoccerTeam(String country, String jerseyColor, boolean ritual, int wins, int losses) {
        this.country = country;
        this.jerseyColor = jerseyColor;
        this.ritual = ritual;
        this.wins = wins;
        this.losses = losses;
    }

    public boolean expectToBeat(SoccerTeam givenContestant) {
        if (ritual == true && givenContestant.ritual == false) {
            return true;
        } else {
            if (ritual == false && givenContestant.ritual == true) {
                return false;
            } else {
                if (ritual == givenContestant.ritual && wins - losses > givenContestant.wins - givenContestant.losses) {
                    return true;
                } else {
                    return false;
                }
            }

        }
    }
}