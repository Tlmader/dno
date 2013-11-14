import java.util.Scanner;
import java.util.Random;

public class DNO{

	public static Scanner input = new Scanner(System.in);
	
	public static int decision;
	
	public static String choice1;
	public static String choice2;
	public static String choice3;
	
	public static void main(String[] args){
	
	mainMenu();
	}
	
	public static void mainMenu(){

	int hp = 0;
	int gold = 0;
	int will = 0;
	int str = 0;
	int cun = 0;
	
	int healRate = 0;
	int goldFind = 0;
	
	System.out.println("\n===|Dungeon of New Orleans|===");
	
	System.out.println("\nThis is a decision-based game. Possible choices appear in all-caps.\nType these words (with lowercase letters) in order to progress.");
	
	System.out.println("\nI'm sure you want to CONTINUE past this crude tutorial.");
	choice1 = "continue";
	decision = decisionProcess(choice1);
	
	System.out.println("\nWould you like to BEGIN or EXIT?");
	choice1 = "begin";
	choice2 = "exit";
	decision = decisionProcess(choice1, choice2);
	
	if(decision == 2){
		System.out.println("\nWell, goodbye I guess."); //Array for random goodbye messages?
		System.exit(0);
	}	
	
	story("Congratulations! You've majored in Dungeoneering and minored in hacking and slashing.");
	
	story("To pass the class, you must delve through the Dungeon of New Orleans and come out bearing its many treasures!");
	
	story("You feel READY to begin your studies.");
	choice1 = "ready";
	decision = decisionProcess(choice1);

	//Character Creation
	
	story("You walk down the entrance stairs and into a great hall lined with columns of stone.");

	story("Across the room is a colossal gate guarded by an armored man.");

	story("You must answer three questions in order to pass.");

	story("To whom am I speaking to?\n");

	String playerName = input.next();

	story("What is your quest?\n* To DISCOVER many treasures.\n* To SURVIVE the dungeon's dangers.\n* To be an absolute BADASS.");
	choice1 = "discover";
	choice2 = "survive";
	choice3 = "badass";
	decision = decisionProcess(choice1, choice2, choice3);
	if(decision == 1){
		hp = 20;
		healRate = 1;
		goldFind = 2;
	}
	if(decision == 2){
		hp = 20;
		healRate = 2;
		goldFind = 1;
	}
	if(decision == 3){
		hp = 10;
		healRate = 0;
		goldFind = 4;
	}

	story("What is your greatest strength?\n* My physical STRENGTH.\n* My unbreakable WILLPOWER.\n* My admirable CUNNING.");
	choice1 = "strength";
	choice2 = "willpower";
	choice3 = "cunning";
	decision = decisionProcess(choice1, choice2, choice3);
	
	if(decision == 1){
		str = 7;
		cun = 3;
		will = 5;
	}
	
	if(decision == 2){
		str = 3;
		will = 7;
		cun = 5;
	}
	
	if(decision == 3){
		str = 5;
		will = 3;
		cun = 7;
	}
	
	story("The gate slowly opens, and you enter, continuing down yet another flight of stairs.");

	story("Your quest begins here, " + playerName + "!");
	
	Character player = new Character(playerName, hp, gold, str, will, cun, healRate, goldFind);
	
	story(player.getStats());
	
	}
	
	public static void randomEvent(){
	
		randomInt = randomizer(10);
	}
	
	public static void randomHallway(){
	
		
		story(
	
	}
	
	public static void story(String dialogue){
		try{
			Thread.sleep(2000);
		}
		catch(InterruptedException ex){
		}	
		System.out.print("\n");
		System.out.println(dialogue);
	}
	
	public static int decisionProcess(String choice1){
		int decision = 0;
		while(decision == 0){
			System.out.print("\n");
			String response = input.next();
			if(response.equals(choice1)){
				decision = 1;
			}
			if(decision == 0){
				System.out.println("\nInvalid command.");
			}
		}
		return decision;
	}
		
	public static int decisionProcess(String choice1, String choice2){
		int decision = 0;
		while(decision	 == 0){
			System.out.print("\n");
			String response = input.next();
			if(response.equals(choice1)){
				decision = 1;
			}
			if(response.equals(choice2)){
				decision = 2;
			}
			if(decision == 0){
				System.out.println("\nInvalid command.");
			}
		}
		return decision;
	}
		
	public static int decisionProcess(String choice1, String choice2, String choice3){
		int decision = 0;
		while(decision == 0){
			System.out.print("\n");
			String response = input.next();
			if(response.equals(choice1)){
				decision = 1;
			}
			if(response.equals(choice2)){
				decision = 2;
			}	
			if(response.equals(choice3)){
				decision = 3;
			}
			if(decision == 0){
				System.out.println("\nInvalid command.");
			}
		}
		return decision;
	}
	
	public static int randomizer(range){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(range);
		randomInt = randomInt + 1;
		return randomInt;
	}
}