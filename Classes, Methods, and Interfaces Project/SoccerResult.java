
public class SoccerResult implements IResult{
    SoccerTeam team1;
    SoccerTeam team2;
    double team1points;
    double team2points;

    SoccerResult (SoccerTeam team1, SoccerTeam team2, double team1points, double team2points){
        this.team1 = team1;
        this.team2 = team2;
        this.team1points = team1points;
        this.team2points = team2points;
    }

    public boolean isValid(){
        if(team1points < 150 && team2points < 150){
            return true;
        }
        else{
            return false;
        }
    }

    public SoccerTeam getWinner (){
        if(team1points > team2points){
            return team1;

        }
        else{
            return team2;
        }
    }
}
