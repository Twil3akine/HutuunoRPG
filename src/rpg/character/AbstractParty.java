package rpg.character;

public abstract class AbstractParty {
	// field
	private AbstractCharacter[] members;
	// constructor
	public AbstractParty(AbstractCharacter[] members) { this.members = members; }
	// methods
	protected abstract boolean isEscapeAll();

	public boolean isAllDead() {
		boolean deadFlg = false;
		for (AbstractCharacter character: this.members) {
  			if (!character.isDead()) {
  				return false;
  			}
  		}
  		return true;
  	}

  public String turn(AbstractParty enemies) {
	  for (AbstractCharacter character: this.getMembers()) {
		  if (!character.isDead() && !character.isEscaped()) {
			  character.command(this, enemies);
			  if (enemies.isAllDead()) {
				  return "BEAT";
			  }
			  if (this.isEscapeAll()) {
				  return "ESCAPE";
			  }
		  }
	  }
	  return "CONTINUE";
  	}
  
  	public AbstractCharacter[] getMembers() { return this.members; }
}
