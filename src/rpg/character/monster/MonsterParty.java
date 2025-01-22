package rpg.character.monster;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class MonsterParty extends AbstractParty {
    // Constructor
    public MonsterParty(AbstractCharacter[] monsters) {
        super(monsters);
    }

    // Methods
    protected boolean isEscapeAll() {
        for (AbstractCharacter monster: this.getMembers()) {
            if (!monster.isEscaped()) {
                return false;
            }
        }
        return true;
    }
}