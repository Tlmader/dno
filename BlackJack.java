import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackJack{

	private DeckOfCards myDeck;
	private BlackJackPlayer dealer;
	private BlackJackPlayer player;
	
	public static boolean playRound(){
		Scanner input = new Scanner(System.in);
		DealerStrategy dealerStrat = new DealerStrategy();
		PlayerStrategy playerStrat = new PlayerStrategy();
		BlackJackPlayer player = new BlackJackPlayer(playerStrat);
		BlackJackPlayer dealer = new BlackJackPlayer(dealerStrat);
		Card newCard = new Card("", "");
		int playerTurn = 0;
		int playerRound = -1;
		int dealerRound = -1;
		int strategyChoice = 0;
		boolean unsuccessful = true;
		boolean playing = true;
		boolean playerWin = false;
		DeckOfCards myDeck = new DeckOfCards();
		while(playing == true || dealer.takeTurn() == 1){
			if(playing == true){
				playerTurn = player.takeTurn();
				if(playerTurn == 1){ 
					playerRound = playerRound + 1;
					newCard = myDeck.dealCard();
					DNO.story("You receive the " + newCard.toString() + ".");
					player.giveCard(newCard, playerRound);
					player.printHand(playerRound);
					if(player.getHandValue(playerRound) > 21){
						DNO.story("You bust!");
						playing = false;
					}
				}
				if(playerTurn == 0 && playing == true){
					DNO.story("You stand.");
					playing = false;
				}
			}
			if(dealer.takeTurn() == 1){
				dealerRound = dealerRound + 1;
				newCard = myDeck.dealCard();
				dealer.giveCard(newCard, dealerRound);
			}
		}
		DNO.story("Your hand: " + player.getHandValue(playerRound));
		if(player.getHandValue(playerRound) <= 21){
			DNO.story("THE DEALER's hand: " + dealer.getHandValue(dealerRound));
		}
		if((player.getHandValue(playerRound) > dealer.getHandValue(dealerRound) && player.getHandValue(playerRound) <= 21) || (player.getHandValue(playerRound) < dealer.getHandValue(dealerRound) && dealer.getHandValue(dealerRound) > 21 && player.getHandValue(playerRound) <= 21)){
			if(dealer.getHandValue(dealerRound) > 21){
				DNO.story("THE DEALER bust!");
			}
			DNO.story("You win this round!");
			playerWin = true;
		}
		if(player.getHandValue(playerRound) > 21 || (dealer.getHandValue(dealerRound) <= 21 && dealer.getHandValue(dealerRound) > player.getHandValue(playerRound))){
			DNO.story("THE DEALER wins this round!");
		}
		if(player.getHandValue(playerRound) <= 21 && player.getHandValue(playerRound) == dealer.getHandValue(dealerRound)){
			DNO.story("THE DEALER: A tie! Let us play again!");
			playerWin = playRound();
		}
		return playerWin;
	}
}