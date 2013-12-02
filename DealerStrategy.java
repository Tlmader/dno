public class DealerStrategy implements Strategy{
	
	public int hitOrStand(int handValue){
		int decision = 1;
		if(handValue >= 17){
			decision = 0;
		}
		return decision;
	}
}