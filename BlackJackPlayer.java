public class BlackJackPlayer{

	private Card[] hand;
	private Strategy myStrategy;
	private int handValue;
	
	public BlackJackPlayer(Strategy strategy){
		myStrategy = strategy;
		hand = new Card[21];
	}
	
	public void giveCard(Card newCard, int round){
		hand[round] = newCard;
		getHandValue(round);
	}
	
	public int getHandValue(int round){
		boolean hasAce = false;
		int newHandValue = 0;
		for(int i = 0; i <= round; i++){
			newHandValue = newHandValue + hand[i].getValue();
			if(hand[i].getValue() == 1){
				hasAce = true;
			}
		}
		handValue = newHandValue;
		if(hasAce == true && handValue <= 11){
			handValue = handValue + 10;
		}
		return handValue;
	}
	
	public void printHand(int round){
		System.out.println("Current hand:");
		for(int i = 0; i <= round; i++){
			System.out.println(hand[i].toString());
		}
	}
	
	public int takeTurn(){
		return myStrategy.hitOrStand(handValue);
	}
}