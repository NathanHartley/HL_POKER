package tests;

public class testinglogic {

		int evalNum = 0;
		int highcard = 0;
		int lowcard = 0;
		int tieNum = 0;
		int tieNum2 = 0;

		
	public testinglogic ()
	{
		/*
		 * The evalNum is going to be what is returned when the hand is evaluated
		 * so 1 is royal flush
		 * 2 is straight flush (tieNum will be the highest card of the straight Flush)
		 * 3 is 4 of a kind
		 * 4 is a full house (the tieNum will be the 3 of a kind value)
		 * 5 is a flush
		 * 6 is a straight
		 * 7 is three of a kind
		 * 8 is two pairs (tieNum will be the higher of the pairs)
		 * 9 is a pair (tieNum is the pair value)
		 * 10 is no hands, so tieNum is going to stay 0 
		 */
		this.evalNum = 0;
		/*
		 * The order for cards will be (card - value)
		 * 2 - 1
		 * 3 - 2
		 * 4 - 3
		 * 5 - 4
		 * 6 - 5
		 * 7 - 6
		 * 8 - 7
		 * 9 - 8
		 * 10 - 9
		 * Jack - 10
		 * Queen - 11
		 * King - 12
		 * Ace - 13
		 */
		
		this.highcard = 0;
		this.lowcard = 0;
		this.tieNum = 0;
		this.tieNum2 = 0;
	}

	

	public static void results(testinglogic player1, testinglogic player2, boolean hiOrLo) 
	{
		//This is where the deciding of who wins will actually happen
		
		//for this boolean, if hiOrLo is true, then the hand ranks are normal 
		if (hiOrLo)
		{
			if (player1.evalNum < player2.evalNum)
			{
				System.out.println ("player one Wins!");
			}
			else
			{
				if (player1.evalNum > player2.evalNum)
				{
					System.out.println ("Player two Wins!");
				}
				else
				{
					if (player1.evalNum == player2.evalNum)
					{
						if (player1.evalNum == 1 || player1.evalNum == 10)
						{
							if (player1.evalNum == 10)
							{
								if (player1.highcard > player2.highcard)
									System.out.println ("player one Wins!");
								if (player1.highcard < player2.highcard)
									System.out.println ("player two Wins!");
							}
							else
							{
								if (player1.evalNum == 1)
								{
									System.out.println ("How did you manage to tie?");
								}
							}
						}
						else
						{
						if (player1.evalNum == 2 || player1.evalNum == 3 || player1.evalNum == 4 || player1.evalNum == 5 || player1.evalNum == 6 || player1.evalNum == 7)
						{
							if (player1.evalNum == 3 || player1.evalNum == 4 || player1.evalNum == 7 )
							{
								if (player1.tieNum > player2.tieNum)
									System.out.println ("player one Wins!");
								if (player1.tieNum < player2.tieNum)
									System.out.println ("player two Wins!");
							}
							else
							{
								if (player1.evalNum == 5 || player1.evalNum == 6)
								{
									if (player1.highcard > player2.highcard)
										System.out.println ("player one Wins!");
									if (player1.highcard < player2.highcard)
										System.out.println ("player two Wins!");
								}
								else
								{
									if (player1.evalNum == 2)
									{
										if (player1.highcard > player2.highcard)
											System.out.println ("player one Wins!");
										if (player1.highcard < player2.highcard)
											System.out.println ("player two Wins!");
										
										if (player1.highcard == player2.highcard)
											System.out.println ("How did you manage to tie?");
									}
								}
							}
						}
						else
						{
							if (player1.evalNum == 9)
							{
								if (player1.tieNum > player2.tieNum)
									System.out.println ("player one Wins!");
								if (player1.tieNum < player2.tieNum)
									System.out.println ("player two Wins!");
								
								if (player1.tieNum == player2.tieNum)
								{
									if (player1.highcard > player2.highcard)
										System.out.println ("player one Wins!");
									if (player1.highcard < player2.highcard)
										System.out.println ("player two Wins!");
								}
							}
							else
							{
								if (player1.evalNum == 8)
								{
									
									if (player1.tieNum > player2.tieNum)
										System.out.println ("player one Wins!");
									if (player1.tieNum < player2.tieNum)
										System.out.println ("player two Wins!");
									
									if (player1.tieNum == player2.tieNum)
									{
										
										if (player1.tieNum2 > player2.tieNum2)
											System.out.println ("player one Wins!");
										if (player1.tieNum2 < player2.tieNum2)
											System.out.println ("player two Wins!");
										
										
										if (player1.tieNum2 == player2.tieNum2)
										{
											
											if (player1.highcard > player2.highcard)
												System.out.println ("player one Wins!");
											if (player1.highcard < player2.highcard)
												System.out.println ("player two Wins!");
										}
									}
								}
							}
						
						}
						}
					}
				}
			}
		}
		else
		{

			if (player1.evalNum > player2.evalNum)
			{
				System.out.println ("player one Wins!");
			}
			else
			{
				if (player1.evalNum < player2.evalNum)
				{
					System.out.println ("Player two Wins!");
				}
				else
				{
					if (player1.evalNum == player2.evalNum)
					{
						if (player1.evalNum == 1 || player1.evalNum == 10)
						{
							if (player1.evalNum == 10)
							{
								if (player1.lowcard < player2.lowcard)
									System.out.println ("player one Wins!");
								if (player1.lowcard > player2.lowcard)
									System.out.println ("player two Wins!");
							}
							else
							{
								if (player1.evalNum == 1)
								{
									System.out.println ("How did you manage to tie?");
								}
							}
						}
						else
						{
							if (player1.evalNum == 2 || player1.evalNum == 3 || player1.evalNum == 4 || player1.evalNum == 5 || player1.evalNum == 6 || player1.evalNum == 7)
							{
								if (player1.evalNum == 3 || player1.evalNum == 4 || player1.evalNum == 7 )
								{
									if (player1.tieNum < player2.tieNum)
										System.out.println ("player one Wins!");
									if (player1.tieNum > player2.tieNum)
										System.out.println ("player two Wins!");
								}
								else
								{
									if (player1.evalNum == 5 || player1.evalNum == 6)
									{
										if (player1.lowcard < player2.lowcard)
											System.out.println ("player one Wins!");
										if (player1.lowcard > player2.lowcard)
											System.out.println ("player two Wins!");
									}
									else
									{
										if (player1.evalNum == 2)
										{
											if (player1.lowcard < player2.lowcard)
												System.out.println ("player one Wins!");
											if (player1.lowcard > player2.lowcard)
												System.out.println ("player two Wins!");
											
											if (player1.highcard == player2.highcard)
												System.out.println ("How did you manage to tie?");
										}
									}
								}
							}
						else
						{
							if (player1.evalNum == 9)
							{
								if (player1.tieNum < player2.tieNum)
									System.out.println ("player one Wins!");
								if (player1.tieNum > player2.tieNum)
									System.out.println ("player two Wins!");
								
								if (player1.tieNum == player2.tieNum)
								{
									if (player1.lowcard < player2.lowcard)
										System.out.println ("player one Wins!");
									if (player1.lowcard > player2.lowcard)
										System.out.println ("player two Wins!");
								}
							}
							else
							{
								if (player1.evalNum == 8)
								{
									if (player1.tieNum < player2.tieNum)
										System.out.println ("player one Wins!");
									if (player1.tieNum > player2.tieNum)
										System.out.println ("player two Wins!");
									
									if (player1.tieNum == player2.tieNum)
									{
										
										if (player1.tieNum2 < player2.tieNum2)
											System.out.println ("player one Wins!");
										if (player1.tieNum2 > player2.tieNum2)
											System.out.println ("player two Wins!");
										
										
										if (player1.tieNum2 == player2.tieNum2)
										{
											
											if (player1.lowcard < player2.lowcard)
												System.out.println ("player one Wins!");
											if (player1.lowcard > player2.lowcard)
												System.out.println ("player two Wins!");
										}
									}
								}
							}
						}
						}
					}
				}
			}
		}
	}
}