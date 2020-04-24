package tests;

public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		testinglogic player1 = new testinglogic();	
		testinglogic player2 = new testinglogic();
		boolean hiOrLo;
		hiOrLo = true;
		
		player1.evalNum = 5;
		player1.highcard = 11;
		player1.lowcard = 8;
		player1.tieNum = 13;
		player1.tieNum2 = 2;
		
		player2.evalNum = 5;
		player2.highcard = 12;
		player2.lowcard = 7;
		player2.tieNum = 13;
		player2.tieNum2 = 2;
		
		testinglogic.results (player1, player2, hiOrLo);
	}

}
