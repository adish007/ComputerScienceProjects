
public interface IResult {
    public IContestant getWinner ();
    public boolean isValid();
    /*class SoccerResult implements IResult{
        SoccerTeam team1;
        SoccerTeam team2;
        double team1points;
        double team2points;

    }

    class LegoRobotResult implements IResult{
        LegoRobotTeam team1;
        LegoRobotTeam team2;
        double team1points;
        int team1tasks;
        boolean team1fell;
        double team2points;
        int team2tasks;
        boolean team2fell;
    }*/

}
