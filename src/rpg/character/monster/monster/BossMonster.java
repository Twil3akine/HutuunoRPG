package rpg.character.monster.monster;

import rpg.character.AbstractParty;
import rpg.character.Specialist;
import rpg.character.monster.Monster;

import java.util.Random;

public abstract class BossMonster extends Monster implements Specialist {
    public BossMonster(String name, int hp, int attack) {
        super(name, hp, attack);
    }

    protected void command(AbstractParty allies,
                           AbstractParty enemies) {
        int command = new Random().nextInt(5);
        if (command < 4) {
            while (true) {
                if (command == 1 ? this.special(enemies) : this.attack((enemies))) {
                    break;
                }
            }
        } else {
            System.out.println(this.getName() + "はくしゃみに気をとられてしまった！");
        }
    }
}
