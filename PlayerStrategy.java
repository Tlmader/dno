import java.util.Scanner;

public class PlayerStrategy implements Strategy{

	public int hitOrStand(int handValue){
		Scanner input = new Scanner(System.in);
		DNO.story("Do you wish to HIT or STAND?");
		String c1 = "hit";
		String c2 = "stand";
		int decision = DNO.decisionProcess(c1, c2);
		if(decision == 2){
			decision = 0;
		}
		return decision;
	}
}