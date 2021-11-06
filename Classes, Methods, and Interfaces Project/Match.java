
public class Match implements IContestant {
    IContestant team1;
    IContestant team2;
    IResult result;

Match (IContestant team1, IContestant team2, IResult result) {
    this.team1 = team1;
    this.team2 = team2;
    this.result= result;
}

public IContestant winner (){
    if(result.isValid()){
       return result.getWinner();}
    else{
        return null;
       }
    }
}