class Character{

	private int hp;
	private int gold;
	private int will;
	private int str;
	private int cun;
	private String playerName;
	
	private int hpRate;
	private int goldFind;
	
	private int score;
	
	private boolean blade;
	
	public Character(String _playerName, int _hp, int _gold, int _str, int _will, int _cun, int _hpRate, int _goldFind, boolean _blade){
		playerName = _playerName;
		hp = _hp;
		gold = _gold;
		str = _str;
		will = _will;
		cun = _cun;
		hpRate = _hpRate;
		goldFind = _goldFind;
		blade = _blade;
	}
	
	public void hpMod(int modifier){
		if(modifier > 0){
			hp = hp + (modifier * hpRate);
			DNO.story("You now have " + hp + " health!");
		}
		else if(modifier <= 0){
			hp = hp + modifier;
			if(hp < 0){
				DNO.story("You have 0 health remaining.");
			}
			else{
				DNO.story("You have " + hp + " health remaining.");
			}
		}
		if(hp <= 0){
			gameOver();
		}
	}
	
	public void fastHpMod(int modifier){
		if(modifier > 0){
			hp = hp + (modifier * hpRate);
			DNO.fastStory("You now have " + hp + " health!");
		}
		else if(modifier <= 0){
			hp = hp + modifier;
			if(hp < 0){
				DNO.fastStory("You have 0 health remaining.");
			}
			else{
				DNO.fastStory("You have " + hp + " health remaining.");
			}
		}
		if(hp <= 0){
			gameOver();
		}
	}
	
	public void goldMod(int modifier){
		if(modifier > 0){
			gold = gold + modifier * goldFind;
			DNO.story("You now carry " + gold + " gold.");
		}
		if(modifier <= 0){
			gold = gold + modifier;
			DNO.story(gold+" gold remains in your pockets!");
		}
	}
	
	public void strMod(int modifier){
		str = str + modifier;
		DNO.story("Your strength icreases to " + str + "!");
	}
	
	public void willMod(int modifier){
		will = will + modifier;
		DNO.story("Your willpower icreases to " + will + "!");
	}
	
	public void cunMod(int modifier){
		cun = cun + modifier;
		DNO.story("Your cunning icreases to " + cun + "!");
	}
	
	public void bladeMod(boolean modifier){
		blade = modifier;
		if(blade == true){
			DNO.story("You now carry a weapon with you!");
		}
		if(blade == false){
			DNO.story("You no longer carry a weapon!");
		}
	}
	
	public int getStr(){
		return str;
	}
	
	public int getWill(){
		return will;
	}
	
	public int getCun(){
		return cun;
	}
	
	public int getHp(){
		return hp;
	}
	
	public int getGold(){
		return gold;
	}
	
	public int getHpRate(){
		return hpRate;
	}
	
	public int getGoldFind(){
		return goldFind;
	}
	
	public boolean getBlade(){
		return blade;
	}
	
	public String getName(){
		return playerName;
	}
	
	public String getStats(){
		String stats = "\nPlayer Name: " + playerName + "\nHealth: " + hp + "\nGold: " + gold + "\nStrength: " + str + "\nWillpower: " + will + "\nCunning: " + cun + "\nHeal Rate: " + hpRate + "\nGold Find: " + goldFind;
		return stats;
	}
	
	public void gameOver(){
		DNO.story("Your story ends here, " + playerName + ". Maybe you'll pass the class when you try again next semester.");
		int score = gold + (str * 20) + (will * 20) + (cun * 20);

		DNO.story("Final score: " + score);
		
		if(score > 1000){
			DNO.story("I'm still not impressed.");
		}
		else if(score > 500){
			DNO.story("You could have done better than that, dead man.");
		}
		else if(score > 200){
			DNO.story("That was quite... the academic performance.");
		}
		else if(score > 0){
			DNO.story("Learn to dungeon.");
		}
		
		System.exit(0);
	}
	
	public void endGame(){
	
		DNO.story("Final score: " + score);
		
		if(score > 3000){
			DNO.story("A: Not a bad job.");
		}		
		if(score > 1000){
			DNO.story("B: I'm still not impressed.");
		}
		else if(score > 500){
			DNO.story("C: You could have done better than that, dead man.");
		}
		else if(score > 200){
			DNO.story("D: That was quite... the academic performance.");
		}
		else if(score > 0){
			DNO.story("F: Learn to dungeon.");
		}	
		System.exit(0);
	}
	
}