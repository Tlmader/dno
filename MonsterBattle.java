public class MonsterBattle{

	private int monsterMaxHp;
	private int monsterHp;
	private int monsterStr;
	private int monsterLoot;
	
	private int playerStance;
	private int monsterStance;
	
	private int damage;
	
	private String monsterName;

	public MonsterBattle(int _monsterHp, int _monsterStr, int _monsterLoot, String _monsterName){
		monsterMaxHp = _monsterHp * 2 / 3 + DNO.randomizer(_monsterHp) * 2 / 3;
		monsterHp = monsterMaxHp;
		monsterStr = _monsterStr * 2 / 3 + DNO.randomizer(_monsterStr) * 2 / 3;
		monsterLoot = _monsterLoot * 2 / 3 + DNO.randomizer(_monsterLoot) * 2 / 3;;
		monsterName = _monsterName;
	}
	
	public void battle(){
	
		DNO.story("A hostile " + monsterName + " appeared!");
		
		while(DNO.player.getHp() > 0 && monsterHp > 0){

			DNO.fastStory("Choose your attack stance:\n* AGGRESSIVE\n* DEFENSIVE\n* QUICK");
			String c1 = "aggressive";
			String c2 = "defensive";
			String c3 = "quick";
			playerStance = DNO.decisionProcess(c1,c2,c3);
			monsterStance = DNO.randomizer(3);
			
			if(playerStance == monsterStance){
				if(playerStance == 1){
					DNO.story("You and the " + monsterName + " exchange blows and block each others' attacks!");
				}
				else if(playerStance == 2){
					DNO.story("You and the " + monsterName + " stand apart, ready to defend against each other!");
				}
				else{
					DNO.story("You and the " + monsterName + " dodge each others' blows!");
				}
			}
			else if(playerStance == 1){ //Aggressive
				if(monsterStance == 3){	//Success
					if(DNO.player.getBlade() == true){
						damage = DNO.randomizer(DNO.player.getStr() * 2);
						DNO.story("You slash the " + monsterName + " with your blade for " + damage + " damage!");
						monsterHp = monsterHp - damage;
					}
					else{
						damage = DNO.randomizer(DNO.player.getStr());
						DNO.story("You attack the " + monsterName + " with your fists for " + damage + " damage!");
						monsterHp = monsterHp - damage;
					}
				}
				else{					//Fail
					damage = DNO.randomizer(monsterStr);
					DNO.story("The " + monsterName + " counters your attack for " + damage + " damage!");
					DNO.player.fastHpMod(damage * -1);
				}
			}
			else if(playerStance == 2){ //Defensive
				if(monsterStance == 1){	//Success
					if(DNO.player.getBlade() == true){
						damage = DNO.randomizer(DNO.player.getWill() * 2);
						DNO.story("You parry the " + monsterName + " with your blade for " + damage + " damage!");
						monsterHp = monsterHp - damage;
					}
					else{
						damage = DNO.randomizer(DNO.player.getWill());
						DNO.story("You counter the " + monsterName + "'s attack for " + damage + " damage!");
						monsterHp = monsterHp - damage;
					}
				}
				else{					//Fail
					damage = DNO.randomizer(monsterStr);
					DNO.story("The " + monsterName + " attacks before you can defend yourself, dealing " + damage + " damage!");
					DNO.player.fastHpMod(damage * -1);
				}
			}
			else if(playerStance == 3){ //Quick
				if(monsterStance == 2){	//Success
					if(DNO.player.getBlade() == true){
						damage = DNO.randomizer(DNO.player.getCun() * 2);
						DNO.story("You quickly stab the " + monsterName + " with your blade before it can defend itself for " + damage + " damage!");
						monsterHp = monsterHp - damage;
					}
					else{
						damage = DNO.randomizer(DNO.player.getCun());
						DNO.story("You quickly attack the " + monsterName + " before it can defend itself for " + damage + " damage!");
						monsterHp = monsterHp - damage;
					}
				}
				else{					//Fail
					damage = DNO.randomizer(monsterStr);
					DNO.story("The " + monsterName + " overpowers you, inflicting " + damage + " damage!");
					DNO.player.fastHpMod(damage * -1);
				}
			}
			
			if(monsterHp < monsterMaxHp / 4 && monsterHp > 0){
				DNO.story("The " + monsterName + " can't last much longer.");
			}
			else if(monsterHp < monsterMaxHp / 2 && monsterHp > 0){
				DNO.story("The " + monsterName + " looks to be in pain.");
			}
			
			if(monsterHp < 1){
				DNO.story("You defeated the " + monsterName + "!");	
				DNO.story("You loot " + monsterLoot * DNO.player.getGoldFind() + " gold from its remains!");
				DNO.player.goldMod(monsterLoot);
			}
		}
	}
}