
public class LegoRobotTeam implements IContestant{
    String school;
    String specialFeature;
    int previousScore;

    LegoRobotTeam (String school, String specialFeature, int previousScore){
        this.school = school;
        this.specialFeature = specialFeature;
        this.previousScore = previousScore;
    }

public boolean expectToBeat(LegoRobotTeam givenContestant){
   if (previousScore > givenContestant.previousScore){
       return true;
   }
   else{
       return false;
   }

}

}