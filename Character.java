class Character{

	private int hp;
	private int gold;
	private int will;
	private int str;
	private int cun;
	private String playerName;
	
	private int healRate;
	private int goldFind;
	
	public Character(String _playerName, int _hp, int _gold, int _str, int _will, int _cun, int _healRate, int _goldFind){
		playerName = _playerName;
		hp = _hp;
		gold = _gold;
		str = _str;
		will = _will;
		cun = _cun;
		healRate = _healRate;
		goldFind = _goldFind;
	}
	
	public void hpMod(int modifier){
		if(modifier > 0){
			hp = hp + modifier * healRate;
		}
		if(modifier <= 0){
			hp = hp + modifier;
		}
	}
	
	public void goldMod(int modifier){
		gold = gold + modifier * goldFind;
	}
	
	public void willMod(int modifier){
		will = will + modifier;
	}
	
	public void strMod(int modifier){
		str = str + modifier;
	}
	
	public void cunMod(int modifier){
		cun = cun + modifier;
	}
	
	public String getStats(){
		String stats = "\nPlayer Name: " + playerName + "\nHealth: " + hp + "\nGold: " + gold + "\nStrength: " + str + "\nWillpower: " + will + "\nCunning: " + cun + "\nHeal Rate: " + healRate + "\nGold Find: " + goldFind;
		return stats;
	}
	
}