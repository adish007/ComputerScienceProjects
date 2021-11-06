
import static org.junit.Assert.*;
        import org.junit.Test;

public class Examples {
    public Examples() {}

    SoccerTeam Futbol = new SoccerTeam ("India", "Blue", true, 90, 1);
    SoccerTeam JAdish = new SoccerTeam ("Pakistan", "Green", false,70, 29);
    SoccerTeam Jai = new SoccerTeam ("India", "Blue", false, 95, 5);
    SoccerTeam Dish = new SoccerTeam ("Pakistan", "Green", false,65, 22);
    SoccerTeam Man = new SoccerTeam ("Germany", "Black", false, 30, 23 );
    LegoRobotTeam JAT = new LegoRobotTeam ("WHS", "ChopperClaws", 9);
    LegoRobotTeam TAJ = new LegoRobotTeam ("BMHS", "Indians", 11);
    SoccerResult soccerresult1 = new SoccerResult (Futbol, JAdish, 60 , 20 );
    LegoRobotResult legorobotresult1 = new LegoRobotResult (JAT, TAJ, 15, 4, false, 12, 2, true);
    LegoRobotResult legorobotresultdouble = new LegoRobotResult (JAT, TAJ, 15, 4, false, 12.1, 2, true);
    SoccerResult soccerresult2 = new SoccerResult (Futbol, JAdish, 190, 80);
    LegoRobotResult legorobotresult2 = new LegoRobotResult (JAT, TAJ, 18, 7, true, 14, 4, true );
    Match soccermatch1 = new Match (Futbol, JAdish, soccerresult1);
    Match soccermatch2 = new Match (Futbol, JAdish, soccerresult2);
    Match legorobotmatch1 = new Match (JAT, TAJ, legorobotresult1);
    Match legorobotmatch2 = new Match (JAT, TAJ, legorobotresult2);
    LegoRobotResult legorobotresult3 = new LegoRobotResult (JAT, TAJ, 18, 7, true, 30, 4, true );
    SoccerResult soccerresult3 = new SoccerResult (Futbol, JAdish, 80, 190);

    @Test
    public void testSocRes1(){ // points are valid
        assertTrue(soccerresult1.isValid());
    }
    @Test
    public void testLegRobRes1(){ // points-tasks-fell is valid
        assertTrue(legorobotresult1.isValid());
    }
    @Test
    public void testSocRes2(){ // points are not valid
        assertFalse(soccerresult2.isValid());
    }
    @Test
    public void testLegRobRes2(){ // points-tasks-fell is not valid
        assertFalse(legorobotresult2.isValid());
    }
    @Test
    public void testGetScore(){
        assertEquals(19,legorobotresult1.getScore(15,4,false),0.1);
    }
    @Test
    public void testGetScore2(){
        assertEquals(10,legorobotresult1.getScore(11,4,true),0.1);
    }
    @Test
    public void testGetScore3(){
        assertEquals(14.1,legorobotresultdouble.getScore(12.1,2,false),0.1);
    }
    @Test
    public void testGetScore4(){
        assertEquals(9.1,legorobotresultdouble.getScore(12.1,2,true),0.1);
    }
    @Test
    public void testgetWinnerLegoOne() { // getScore of JAT > getScore of TAJ
        assertEquals(JAT, legorobotresult1.getWinner());
    }
    @Test
    public void testgetWinnerLegoTwo() { // getScore of TAJ > getScore of JAT
        assertEquals(TAJ, legorobotresult3.getWinner());
    }
    @Test
    public void testgetWinnerSoccerOne() { // Futbol points > JAdish points
        assertEquals(Futbol, soccerresult1.getWinner());
    }
    @Test
    public void testgetWinnerSoccerTwo() { // JAdish points > Futbol points
        assertEquals(JAdish, soccerresult3.getWinner());
    }
    @Test
    public void expecttoBeatTestRobotOne() { // Team has a lower previous score than input team
        assertFalse(JAT.expectToBeat(TAJ));
    }
    @Test
    public void expecttoBeatTestRobotTwo() { // Team has a higher previous score than input team
        assertTrue(TAJ.expectToBeat(JAT));
    }
    @Test
    public void expecttoBeatTestSoccerOne() { // if ritual for first team is true and second team is false
        assertTrue(Futbol.expectToBeat(JAdish));
    }
    @Test
    public void expecttoBeatTestSoccerTwo() { // if ritual for first team is false and second team is true
        assertFalse(JAdish.expectToBeat(Futbol));
    }
    @Test
    public void expecttoBeatTestSoccerThree() { // if rituals are both false and the score of the first team is greater than score of second team
        assertTrue(Jai.expectToBeat(Dish));
    }
    @Test
    public void expecttoBeatTestSoccerFour() { // if rituals are both false or both true and the score of the first team is less than score of second team
        assertFalse(Dish.expectToBeat(Jai));
    }
    @Test
    public void winnerTestSoc() { // More points than other team
        assertEquals(Futbol, soccermatch1.winner());
    }
    @Test
    public void winnerTestTwoSoc() { // Results aren't valid
        assertEquals(null, soccermatch2.winner());
    }
    @Test
    public void winnerTestLeg() { // Higher score than other team based off getScore
        assertEquals(JAT, legorobotmatch1.winner());
    }
    @Test
    public void winnerTestLeg2() { // Results aren't valid
        assertEquals(null, legorobotmatch2.winner());
    }
}