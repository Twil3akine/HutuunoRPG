package rpg.character.hero;

import static rpg.Print.print;
import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class HeroParty extends AbstractParty {
	// constructor
	public HeroParty(AbstractCharacter[] heros) {
		super(heros);
	}
	// methods
	public void rest() {
		for (AbstractCharacter target: this.getMembers()) {
			((Hero)target).rest();
		}
	}

	public void printPartyStatus() {
		for (AbstractCharacter target: this.getMembers()) {
			this.printPartyStatus((Hero)target);
		}
		print();
	}
	
	private void printPartyStatus(Hero hero) {
		print(hero.getName() + "(" + hero.job + "): " + (hero.isEscaped() ? "逃亡" : (hero.isDead() ? "死亡" : hero.getHp())));
	}
	
	public boolean isEscapeAll() {
		for (AbstractCharacter target: this.getMembers()) {
			if (!target.isEscaped()) {
				return false;
			}
		}
		print("チームは全員逃げている！");
		return true; 
	}
	
	public void init() {
		for (AbstractCharacter target: this.getMembers()) {
			target.init();
		}
	}
}