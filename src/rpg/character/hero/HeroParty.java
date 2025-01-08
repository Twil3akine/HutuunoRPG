package rpg.character.hero;

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
		System.out.println();
	}
	
	private void printPartyStatus(Hero hero) {
		System.out.println(hero.getName() + "(" + hero.job + "): " + (hero.isEscaped() ? "逃亡" : (hero.isDead() ? "死亡" : hero.getHp())));
	}
	
	public boolean isEscapeAll() {
		for (AbstractCharacter target: this.getMembers()) {
			if (!target.isEscaped()) {
				return false;
			}
		}
		System.out.println("チームは全員逃げている！");
		return true; 
	}
	
	public void init() {
		for (AbstractCharacter target: this.getMembers()) {
			target.init();
		}
	}
}