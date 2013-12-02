import java.util.Scanner;
import java.util.Random;

public class DNO{

	public static Scanner input = new Scanner(System.in);
	
	public static int decision;
	public static int randomStory;
	public static int randomMod;
	
	public static String c1; //Choice 1
	public static String c2; //Choice 2
	public static String c3; //Choice 3
	
	public static Character player = new Character("Test",20,0,5,5,5,1,1,false);
	
	public static void main(String[] args){
	
	levelNightmareBlackJack();
	player = mainMenu();
	story(player.getStats());
	event();
	event();
	event();
	event();
	event();
	event();
	levelStranger();
	event();
	event();
	event();
	event();
	event();
	event();
	levelNightmare();
	event();
	event();
	event();
	event();
	event();
	event();
	
	}
	
	public static Character mainMenu(){

	int hp = 0;
	int gold = 0;
	int will = 0;
	int str = 0;
	int cun = 0;
	
	int hpRate = 0;
	int goldFind = 0;
	
	boolean blade = false;
	
	story("===|Dungeon of New Orleans|===");
	
	story("This is a decision-based game. Possible choices appear in all-caps.\nType these words (with lowercase letters) in order to progress.");
	
	story("I'm sure you want to CONTINUE past this crude tutorial.");
	c1 = "continue";
	decision = decisionProcess(c1);
	
	story("Would you like to BEGIN or EXIT?");
	c1 = "begin";
	c2 = "exit";
	decision = decisionProcess(c1,c2);
	
	if(decision == 2){
		story("Well, goodbye I guess."); //Array for random goodbye messages?
		System.exit(0);
	}	
	
	story("Congratulations! You've majored in Dungeoneering and minored in hacking and slashing.");
	
	story("To pass the class, you must delve through the Dungeon of New Orleans and come out bearing its many treasures!");
	
	story("You feel READY to begin your studies.");
	c1 = "ready";
	decision = decisionProcess(c1);

	//Character Creation
	
	story("You walk down the entrance stairs and into a great hall lined with columns of stone.");

	story("Across the room is a colossal gate guarded by an armored man.");

	story("KEEPER: You must answer three questions in order to pass.");

	story("KEEPER: What... is your name?\n");

	System.out.print("* Enter your name: ");
	
	String playerName = input.next();

	story("KEEPER: What... is your quest?\n* To DISCOVER many treasures.\n* To SURVIVE the dungeon's dangers.\n* To be an absolute BADASS.");
	c1 = "discover";
	c2 = "survive";
	c3 = "badass";
	decision = decisionProcess(c1,c2,c3);
	if(decision == 1){
		hp = 20;
		hpRate = 1;
		goldFind = 2;
	}
	else if(decision == 2){
		hp = 30;
		hpRate = 2;
		goldFind = 1;
	}
	else if(decision == 3){
		hp = 5;
		hpRate = 0;
		goldFind = 5;
	}

	story("KEEPER: What... is your greatest strength?\n* My physical STRENGTH.\n* My unbreakable WILLPOWER.\n* My admirable CUNNING.");
	c1 = "strength";
	c2 = "willpower";
	c3 = "cunning";
	decision = decisionProcess(c1,c2,c3);
	
	if(decision == 1){
		str = 7;
		cun = 3;
		will = 5;
	}
	
	else if(decision == 2){
		str = 3;
		will = 7;
		cun = 5;
	}
	
	else if(decision == 3){
		str = 5;
		will = 3;
		cun = 7;
	}
	
	story("The massive gate slowly opens making a heavy, metal sound.");

	story("KEEPER: Your quest begins here, " + playerName + "!");
	
	story("You enter, continuing down yet another flight of stairs.");
	
	Character newPlayer = new Character(playerName, hp, gold, str, will, cun, hpRate, goldFind, blade);
	
	return newPlayer;
	}
	
	//Random Events
	
	public static void event(){

		randomStory = randomizer(6);
		
		if(randomStory == 1){
			eventTreasure();
		}
		else if(randomStory == 2){
			eventMonster();
		}
		else if(randomStory == 3){
			eventMonster();
		}
		else{
			eventHallway();
		}
	}
	
	public static void eventHallway(){
		
		randomStory = randomizer(5);
		if(randomStory == 1){
			story("You continue down a dimly-lit corridor.");
		}
		else if(randomStory == 2){
			story("As you walk, you notice how intricate the hallways' walls are built.");
			
			story("You spot an occasional stone carving or decorative pillar.");
			
			story("How much work has been invested into this 'classroom'?");
		}
		else if(randomStory == 3){
			story("During your endless hallway exploration, you begin to think of your close ones, especially 'her'.");
		
			story("You begin to think: would you even live for 'her' to see you again?");
		}
		else if(randomStory == 4){
			story("It has been hours since anything eventful has happened.");
			
			story("You begin to notice how beautiful the torch flames are, lighting your way.");
			
			story("What would you do without them?");
		}
		else{
			story("More endless traversal of dungeon hallways, you tell yourself.");
			
			story("Suddenly, a funny smell reaches your nostrils...");

			story("Oh. You just smell your own breath.");
			
			story("You must have caught a cold, since you have to breathe through your mouth.");
			
			story("Then you realize you haven't brushed your teeth in awhile.");
		}
	}
	
	public static void eventTreasure(){
	
		story("Walking further down the dungeon's dark halls, you encounter a tiny chest.");
		
		story("It sits upon a peculiar stone pedestal bearing engravings of unfamiliar creatures, brightly lit by burning torches.");
			
		story("Your curiosity tells you to open the chest, but you remain extremely cautious.");
		
		story("You could OPEN the chest, IGNORE it, or CHECK the surroundings for traps.");
			c1 = "open";
			c2 = "ignore";
			c3 = "check";
			decision = decisionProcess(c1,c2,c3);
		
		if(decision == 1){
			randomStory = randomizer(10);
			if(randomStory < 5){
				story("As you open the chest, you hear a clicking noise, and an arrow shoots to your knee!");
				
				story("You scream in pain, quickly hushing yourself in case something hears you.");
				randomMod = randomizer(10) * -1;
				player.hpMod(randomMod);
			}
			else if(randomStory >= 5){
				randomMod = randomizer(40) + 10;
				story("You open the chest, revealing a pile of " + randomMod * player.getGoldFind() + " gold! You sigh in relief as you pocket the shinies.");
				player.goldMod(randomMod);
			}
		}
		else if(decision == 2){
			story("You decide to resist the temptations of treasure and continue down the path.");
			player.willMod(1);
		}
		else if(decision == 3){
			story("You dilligently search the surroundings for any sort of dangers.");
			randomMod = randomizer(10);
			
			if(randomStory <= player.getCun()){
				
				story("To your expectatons, you spot an arrow trap against the wall, aiming to where one would stand to open the chest.");
				
				story("You open the chest from the opposite side, triggering the trap without harm.");
				randomMod = randomizer(100);
				
				story("The chest contains a pile of " + randomMod * player.getGoldFind() + " gold! You smugly pocket the treasure, having outsmarted the dungeon's follies.");
				player.goldMod(randomMod);
				player.cunMod(1);
			}
				
			else if(randomStory > player.getCun()){
				story("However, you accidentally trigger a pressure plate on the ground, springing an arrow trap! Your shoulder is met with the piercing of an arrowhead.");
				randomMod = randomizer(10);
				player.hpMod(randomMod*-1);
			}
		}
	}
	
	public static void eventMonster(){
	
		randomStory = randomizer(6);
		
		if(randomStory == 1){
			eventMonsterSpider();
		}
		else if(randomStory == 2){
			eventMonsterUndead();
		}
		else if(randomStory == 3){
			eventMonsterArmor();
		}
		else{
			eventMonsterSkeleton();
		}
	}
	
	public static void eventMonsterSpider(){

		MonsterBattle spider = new MonsterBattle(10, 3, 20, "Cave Spider");
		
		story("As you travel through the dungeon, you encounter a large room.");
		
		story("...!");
		
		story("To your surprise, your face is met by the touch of a massive web!");
		
		story("You quickly struggle to get the web off...");
		
		story("Suddenly, you are met with glowing red eyes!");
		
		spider.battle();
		
		story("Another, larger spider crawls towards you! Will you LAST another fight or FLEE?");
		c1 = "last";
		c2 = "flee";
		decision = decisionProcess(c1, c2);
		
		if(decision == 1){
	
			spider = new MonsterBattle(15, 3, 40, "Giant Spider");	
			spider.battle();
			
			story("Having bested the eight-legged beasts, you victoriously tear though the dense webbing.");
			
			story("To your surprise, you spot a mysterious potion trapped in the webs!");
			
			story("Do you wish to DRINK it or LEAVE it be?");
			c1 = "drink";
			c2 = "leave";
			decision = decisionProcess(c1, c2);
			
			if(decision == 1){
				randomStory = randomizer(2);	
				
				if(randomStory == 1){
					story("You down the entire bottle, and feel your various injuries quickly repairing themselves!");
					player.hpMod(randomizer(10) + 10);
				}
				else{
					story("You down the entire bottle... Ouch! You feel your insides burning up!");
					
					story("Maybe you shouldn't drink out of random bottles.");
					player.hpMod((randomizer(5) + 5) * -1);
				}
			}
			else{
				story("You ignore the unknown fluid and proceed out of the web-covered room.");
			}
		}
		else{
			story("You flee, hoping to find another route through the dungeon!");
		}
	}
	
	public static void eventMonsterUndead(){
	
		story("You pass upon the corpse of a fallen adventurer. You spot a coin purse and a crude-looking sword still grasped by his lifeless hand.");
	
		story("Do you wish to LOOT the corpse or RESPECT the dead man and leave his body alone?");
		c1 = "loot";
		c2 = "respect";
		decision = decisionProcess(c1, c2);
		
		if(decision == 1){
		
			MonsterBattle undead = new MonsterBattle(30, 8, 100, "Undead Adventurer");
			
			if(player.getBlade() == false){
				story("Knowing that you need the blade more than he does, you reach down to take the weapon.");
			}
			else{
				story("Knowing that coin proves more useful to the living, you reach down for his coin purse.");
			}
			
			randomStory = randomizer(2);
			
			if(randomStory == 1){
				story("...!");
				
				story("You jump at the sight of the unliving adventurer rising up, ready to defend its peace!");
				
				undead.battle();
				
				if(player.getBlade() == false){
					story("You take the now-truly-dead adventurer's old blade.");
					player.bladeMod(true);
				}
				story("What a fight! You hope you find a way of healing yourself soon.");
			}
			else{
				if(player.getBlade() == false){
					player.bladeMod(true);
					story("Also knowing that coin proves more useful to the living, you reach down for his coin purse.");
				}
				randomMod = randomizer(90) + 10;
				story("You count " + randomMod * player.getGoldFind() + " pieces of gold!");
				player.goldMod(randomMod);
			}
		}
		else{
			story("You are better than this. Respecting the dead is far more important than loot... right?");
			player.willMod(1);
		}
	}
	
	public static void eventMonsterSkeleton(){

		MonsterBattle skeleton = new MonsterBattle(20, 7, 50, "Skeleton Warrior");
		
		story("You notice a strange shadow on the floor of the hallway. Something is there!");
		
		story("An armed, spooky, scary skeleton blocks your path!");
		
		story("It charges towards you, making rattling noises with every step!");
		
		skeleton.battle();
		
		story("You emerge triumphant over the pile of bones. Nothing can stop you... right?");
	}
	
	public static void eventMonsterArmor(){
	
		MonsterBattle armor = new MonsterBattle(50, 10, 500, "Cursed Armor");
		
		story("After walking for some time, you enter an elegantly built room - one fit for royalty.");
		
		story("The first thing you spot is a massive, golden chest behind an idle suit of armor.");
		
		story("You believe the gold chest cannot simply be for grabs.");
		
		story("Do you wish to APPROACH the golden chest or avoid it and CARRY on?");
		c1 = "approach";
		c2 = "carry";
		decision = decisionProcess(c1, c2);
		
		if(decision == 1){
			story("You cautiously approach the treasure, hoping nothing happens.");
			
			story("You open the chest, revealing piles over piles of gold!");
				
			story("To your actual surprise, the golden chest appears to be free of traps!");
			
			story("You pocket as much gold as humanly possible! You're rich!");
			
			player.goldMod(randomizer(1000));
			
			story("...!");
			
			story("Your euphoria is interrupted by a loud, metal, clanking noise.");
			
			story("Behind you - the suit of armor no longer remains idle, bearing a large mace!");
			
			armor.battle();
			
			story("The suit of armor, along with its massive weapon, crumbles into dust.");
			
			story("Incredible. You survived what seemed to be an impossible fight...");
			
			story("Gravely wounded, you rest for awhile in the room...");
			
			player.hpMod(randomizer(5) + 5);
			
			story("You wake up slightly rejuvenated with several of your injuries healed.");
			
			story("This room must be sacred, since you have recovered so quickly.");
			
			story("You get on your legs and leave bearing more teasure than you have imagined.");
		}
		else{
			story("Worried by a trap or curse tied with the treasure, you continue onward.");
			
			story("Survival over treasure seems the best strategy to you.");
		}
	}
	
	//Random Levels
	
	public static void level(){
	
		randomStory = randomizer(5);
		
		if(randomStory == 1){
			levelStranger();			
		}
		else if(randomStory == 2){
			//levelDarby();
		}
		else if(randomStory == 3){
			//levelBeth();
		}
		else if(randomStory == 4){
			//levelBen();
		}
		else{
			//levelMatt();
		}
	}
	
	public static void levelStranger(){
	
		story("After an hour of exploring in silence, you feel the need to take a BREAK from exploring. Or you could WALK further");
		c1 = "break";
		c2 = "walk";
		decision = decisionProcess(c1,c2);
		
		if(decision == 1){
			story("You reward yourself with hard-earned rest.");
			
			story("Exhausted from your efforts, you go into a deep sleep.");
		}
		else if(decision == 2){
			story("You resist the urge to nap and continue walking... drowsily...");
		}
		
		story("...");
		
		story("...");
		
		story("...");
		
		if(player.getBlade() == false){
			story("You awaken to the pressing of a sharp blade against your neck!");
		} 
		else{
			story("You awaken to the pressing of your own weapon against your neck!");
			player.bladeMod(false);
		}
		
		story("STRANGER: Don't move a muscle.");
		
		story("* WHAT do you want from me?\n* WHO are you?");
		c1 = "what";
		c2 = "who";
		decision = decisionProcess(c1,c2);
		
		if(decision == 1){
			
			story("STRANGER: We came here for the same reason. Gold. Hand it over or die.");
		}
		else if(decision == 2){
		
			story("STRANGER: My name is of no importance. What matters is that you hand over your treasures.");
			
			story("Otherwise, you will have neither your gold nor your life.");
		}
		
		story("You could SURRENDER your gold to the stranger, attempt to break free and FIGHT back.");
		
		story("Maybe you could attempt to talk it over and NEGOTIATE working together.");
		c1 = "surrender";
		c2 = "fight";
		c3 = "negotiate";
		decision = decisionProcess(c1,c2,c3);
		
		if(decision ==  1){ //Surrender gold to stranger
		
			levelStrangerSurrender();	
		}
		else if(decision == 2){ //Fight back the stranger
			
			levelStrangerFight();
		}
		else if(decision == 3){ //Negotiate with the stranger
			
			story("You attempt to talk yourself out of the situation and into an alliance with the stranger.");
			
			story("STRANGER: So, you propose working together. What a fine idea.");
		
			story("STRANGER: However, I don't see how I could profit through such an arrangement.");
			
			story("There are two things left to do: either you could HAND over the gold or FIGHT back.");
			c1 = "surrender";
			c2 = "fight";
			decision = decisionProcess(c1,c2);
			
			if(decision ==  1){ //Surrender gold to stranger
			
				levelStrangerSurrender();
			}
			else if(decision == 2){ //Fight back the stranger
			
				levelStrangerFight();
			}
		}	
	}
	
	public static void levelStrangerSurrender(){

		player.goldMod(player.getGold() * -1);
		
		story("You reluctantly empty your pockets of every last piece of gold.");
		
		story("STRANGER: You made the right decision. I said I would spare your life.");
		
		story("STRANGER: But not your thoughts.");
		
		story("Your head is met with the blow of the hilt of the thief's blade.");
		
		story("You fade into unconsciousness...");
		
		story("...");
		
		story("...");
	
		story("...");
		
		randomMod = randomizer(4) + 2;
		
		player.hpMod(randomMod * -1);
		
		story("You awaken, dazed, unsure of how long you were knocked out.");
		
		story("Your pockets remain empty. The encounter was no dream.");
		
		story("Despite the loss, you vigilantly get on your feet, ready for the next challenge.");	
	}
	
	public static void levelStrangerFight(){
	
		story("Confident in your own strength, you attempt to break free and turn the tables against the attacker.");
						
		randomStory = randomizer(5) + 4;
		
		story("You gather yourself and try your hardest to break free from the hold.");
			
		if(randomStory <= player.getStr()){
			
			story("In a flash, you drive his blade-arm away from you and knock him on the ground.");
			
			player.strMod(1);
			
			story("STRANGER: Ugh... You are a formidable one, adventurer. I do enjoy a challenge, however.");
			
			story("Your enemy has his back to the ground! You can either go for the BLADE or try to FINISH him off!");
			c1 = "blade";
			c2 = "finish";
			decision = decisionProcess(c1, c2);
			
			if(decision == 1){
				
				story("Following your instinct, you sprint towards the shiny metal blade.");
				
				randomStory = randomizer(5) + 4;
				
				if(randomStory <= player.getStr()){
				
					story("The stranger springs up and runs for the weapon as well, but fails to beat you to it.");
				
					story("Seeing that you now wield the blade, he hurriedly takes off down the hallway.");
					
					player.bladeMod(true);
				}
				
				else if(randomStory > player.getStr()){
				
					story("However, the stranger springs up and beats you to the weapon.");
					
					story("You are unable to react quickly enough, and he cuts you down with a single blow!");
					
					story("Your killer greedily pockets all your hard-earned gold with no regrets of your expense.");
					
					player.gameOver();
				}
		 	}
			else if(decision == 2){
				
				story("Ignoring the shiny metal weapon, you forcefully pin the attacker against the ground.");
				
				story("You both exchange blows, leaving yourself with a bloody face and fists.");
				
				randomMod = randomizer(3) + 3;
				player.hpMod(randomMod * -1);
				
				story("However, you manage to finish off your adversary by breaking his neck!");
				
				
				story("Relieved that you survived the encounter, you take the dead stranger's gold and the weapon.");
				
				randomMod = randomizer(200) + 50;
				player.goldMod(randomMod);
				
				player.bladeMod(true);
				
				story("You brush the dust off your clothes with your hands and delve deeper into the dungeon's darkly-lit corridors.");
			}
		}
		else if(randomStory > player.getStr()){
		
			story("You gather yourself and try your hardest to break free from the hold.");
			
			story("Unfortunately, your strength failed you and the stranger slices open your throat.");
			
			story("Your killer greedily pockets all your hard-earned gold with no regrets of your expense.");
			
			player.gameOver();
		}
	}
	
	public static void levelNightmare(){
	
		story("After hours of seemingly endless walking, you notice something unsettling.");
		
		story("The hallway becomes decreasingly lit and a strange, fleshy substance lines the cracks in the stone.");
	
		story("You walk upon a crooked, decaying sign, only barely able to read its crudely scribed letters.");
		
		story("A GrEaT PEril aWAitS YoU, ViSitOr, aND tHerE iS nO TuRniNg BaCk.");
		
		story("yOU HaVE wAlkEd BeyOnD thE POinT OF nO RetURn, OnLy tO bE ChAsEd bY A nIGhtmaRE.");
		
		story("ProCeED SWiFtlY, FOr hE AlReaDy kNowS yOuR PrEseNcE.");
		
		story("Worried from what you read, you have the urge to TURN back, but the sign says you can only go FORWARD.");
		c1 = "turn";
		c2 = "forward";
		decision = decisionProcess(c1, c2);
		
		if(decision == 1){
		
			story("Afraid of facing certain doom, you turn back and hope for a less threatening passage.");
			
			story("Strangely, the way back becomes increasingly darker. Something is different.");
			
			story("You don't know whether to WALK on, or turn back and FACE your fears.");
			c1 = "walk";
			c2 = "face";
			decision = decisionProcess(c1, c2);
			
			if(decision == 1){
			
				story("You tell yourself to stop worrying and keep walking. It's all in your head, you tell yourself.");
		
				story("Suddenly, the ground gets incredibly fleshy and seemingly alive!");
				
				story("Fear and instinct take over you, and you take off running!");
				
				story("The darkness lining the walls shoots past you, and what used to be a stone floor now feels like the insides of a beast!");
				
				story("Down what used to be a stone corridor, to your disbelief...");
			
				story("Enormous teeth sprout from the ceiling and floor and begin quickly closing on each other! There is no escape...");
				
				story("The last thing you ever see is the light between the teeth's closing gaps.");

				player.gameOver();
			}
			else if(decision == 2){
				
				story("You stop for a moment and gather yourself. The sign said not to turn back.");
				
				story("Ultimately, you decide to proceed back towards the creepy sign and past it.");
			}
		}
		
		story("You walk onwards, and the halls are no longer lit by dim, orange flames. Bright, green, seemingly cursed flames light the path.");
		
		story("Soon, you encounter a room containing three large, wooden doors.");
		
		story("...!");
		
		story("You hear a long, sustained moan, and you remember the 'nightmare' mentioned by the sign.");

		story("One of these doors must lead the way. If you are surely being followed, you have no choice but to pick one.");
		
		story("You must quickly decide - Which door should you enter? LEFT, CENTER, or RIGHT?");
		c1 = "left";
		c2 = "center";
		c3 = "right";
		decision = decisionProcess(c1, c2, c3);
		
		if(decision == 1){
			story("You enter the left door, hoping you make it through alive.");
		}
		else if(decision == 2){
			story("You enter the center door, hoping you make it through alive.");
		}
		else{
			story("You enter the right door, hoping you make it through alive.");
		}
		
		randomStory = randomizer(3);
		
		if(randomStory == 1){
			levelNightmareBattle();
		}
		else if(randomStory == 2){
			levelNightmareBlackJack();
		}
		else if(randomStory == 3){
			levelNightmareBlackJack();
		}
	}
	
	public static void levelNightmareBattle(){
	}
	
	public static void levelNightmareBlackJack(){
		
		story("After stepping into what seems to be an old, rustic casino room, the door behind you closes shut.");
		
		story("In front of you is a dimly lit tabletop, and behind it sits a man.");
		
		story("You can't quite make out his features with the poor lighting.");
		
		story("THE DEALER: Welcome, sir. You may call me THE DEALER. May I offer you a wager you surely cannot refuse?");
		
		story("* Continue to LISTEN to the dealer.\n* QUESTION him about the wager.");
		c1 = "listen";
		c2 = "question";
		decision = decisionProcess(c1, c2);
		
		if(decision == 2){
			story("THE DEALER: Ah good sir, I am just getting to that.");
		}
		
		story("THE DEALER: As you see, I hold the key to your escape.");
		
		story("The man slowly holds out a rusty key with his gloved hand.");
		
		story("THE DEALER: Similarly, you hold the key to my own escape.");
		
		story("THE DEALER: I am a cursed man, cursed to forever be the dealer of this forsaken place.");
		
		story("THE DEALER: The only way to break my curse is to offer my position to another... willing.");
		
		story("THE DEALER: So what will it be, will you PLAY?\n* You also have the option to KILL the dealer for the key.");
		c1 = "play";
		c2 = "kill";
		decision = decisionProcess(c1, c2);
		
		if(decision == 2){
		
			if(player.getBlade() == true){
				story("You brandish your trusty blade and slowly approach the dealer.");
			}
			else{
				story("You crack your knuckles and slowly approach the dealer.");
			}
			
			story("THE DEALER: You have no power here, naive sir. Do you truly want to do this?\n* Sit down and PLAY the game.\n* FINISH the job.");
			c1 = "play";
			c2 = "finish";
			decision = decisionProcess(c1, c2);
				
			if(decision == 1){
				story("Not willing to take the risk, you stand down.");
				
				story("THE DEALER: Smart move, sir. Hopefully it reflects in your card game.");
			}
			else{
				story("You call the dealer's bluff and charge at him!");
				
				if(player.getBlade() == true){
					story("Ready to obtain your prize, you drive your blade into his body...");
					
					story("Instantly, you feel a sharp drive of metal in your own gut!");
					
					story("You quickly bleed to death from your self-inflicted wound.");
					
					story("THE DEALER: Good night... sir.");
					
					player.gameOver();					
				}
				else{
					story("You crack your knuckles and slowly approach the dealer.");
					
					story("He only sits there as you press both you hands on the sides of his head.");
					
					story("With a sudden jerk, you twist his neck...");
					
					story("In a single motion your own neck breaks, instantly killing you!");
					
					story("THE DEALER: Good night... sir.");
					
					player.gameOver();	
				}
			}
		}
		
		story("You take a seat, and the dealer pulls out a deck of cards.");
		
		story("THE DEALER: The game for tonight is Blackjack! Do you know how to play?\n* YES.\n* NO.");
		c1 = "yes";
		c2 = "no";
		decision = decisionProcess(c1, c2);
		
		if(decision == 1){
			story("Good. let us begin then.");
		}
		else{
			story("THE DEALER: The goal of blackjack is to beat the dealer's hand without going over 21.");
			
			story("THE DEALER: Face cards are worth 10. Aces are worth 1 or 11, whichever makes a better hand.");
			
			story("THE DEALER: With that being said, let us begin.");
		}
		
		story("First to three wins the wager!");
		
		int playerScore = 0;
		int dealerScore = 0;

		while(playerScore < 3 && dealerScore < 3){
			if(playerScore == 2 && dealerScore == 2){
				story("THE DEALER: The wager of a millennium! It all goes down to this game!");
			}
			BlackJack blackJackGame = new BlackJack();
			boolean playerWin = BlackJack.playRound();
			if(playerWin == true){
				playerScore = playerScore + 1;
				if(playerScore == 1 && dealerScore == 0){
					story("THE DEALER: Let's hope lady luck stays faithful to you. Again!");
				}
				else if(playerScore == 2){
					story("THE DEALER: Another win for you, good sir! Very good!");
				}
			}
			else{
				dealerScore = dealerScore + 1;
				if(dealerScore == 1){
					story("THE DEALER: Aha! This game belongs to me!");
				}
				else if(dealerScore == 2){
					story("THE DEALER: Another win for THE DEALER! I wish you the best of luck, sir.");
				}
			}
			story("SCORE:\nYou: " + playerScore + "\nTHE DEALER: " + dealerScore);
		}
		
		if(playerScore == 3){
			story("You won the wager!");
			
			player.cunMod(1);
			
			story("THE DEALER: Well, a wager's a wager, and my curse bounds me to my word.");
			
			story("The dealer places the key upon the table.");
			
			story("The exit is behind me. Good luck on your further adventures, sir.");
		}
		else{
			story("You lost the wager!");
			
			story("THE DEALER: Well, a wager's a wager, and my curse belongs to you now!");
			
			story("You suddenly lose consciousness, and your body becomes possessed of the dealer's curse!");
			
			story("No longer caring for gold and adventure, you take the dealer's seat.");
			
			story("EX-DEALER: I'm free! How long has it been...?");
			
			player.gameOver();
		}
	}
	
	public static void levelNightmareTemptation(){
	
	}
	
	//Boss Levels
	
	public static void boss(){
		
		randomStory = randomizer(2);
		
		if(randomStory == 1){
			//bossRidge();
		}
		if(randomStory == 2){
			//bossIbs();
		}
	}
	
	//Technical Methods
	
	public static void story(String dialogue){
		try{
			Thread.sleep(1000);
		}
		catch(InterruptedException ex){
		}	
		System.out.print("\n");
		System.out.println(dialogue);
	}
	
	public static void fastStory(String dialogue){
		try{
			Thread.sleep(500);
		}
		catch(InterruptedException ex){
		}	
		System.out.print("\n");
		System.out.println(dialogue);
	}
	
	public static int decisionProcess(String c1){
		int decision = 0;
		while(decision == 0){
			System.out.print("\n");
			String response = input.next();
			if(response.equals(c1)){
				decision = 1;
			}
			if(decision == 0){
				System.out.println("\nInvalid command.");
			}
		}
		return decision;
	}
		
	public static int decisionProcess(String c1, String c2){
		int decision = 0;
		while(decision	 == 0){
			System.out.print("\n");
			String response = input.next();
			if(response.equals(c1)){
				decision = 1;
			}
			if(response.equals(c2)){
				decision = 2;
			}
			if(decision == 0){
				System.out.println("\nInvalid command.");
			}
		}
		return decision;
	}
		
	public static int decisionProcess(String c1, String c2, String c3){
		int decision = 0;
		while(decision == 0){
			System.out.print("\n");
			String response = input.next();
			if(response.equals(c1)){
				decision = 1;
			}
			if(response.equals(c2)){
				decision = 2;
			}	
			if(response.equals(c3)){
				decision = 3;
			}
			if(decision == 0){
				System.out.println("\nInvalid command.");
			}
		}
		return decision;
	}
	
	public static int randomizer(int range){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(range);
		randomInt = randomInt + 1;
		return randomInt;
	}

}