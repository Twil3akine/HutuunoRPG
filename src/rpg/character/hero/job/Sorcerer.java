package rpg.character.hero.job;

import static rpg.Print.print;
import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

import java.util.Random;

public class Sorcerer extends AbstractSuperHero {
    public Sorcerer(String name) {
        super(name, 100, 15);
        this.job = "魔法使い";
        this.escaped = false;
    }

    public boolean special(AbstractParty targets) {
        int randomAttack = new Random().nextInt(attack) + attack;
        print(this.getName() + "のライトニング！\n相手全体に" + randomAttack + "のダメージを与えた！");

        for (AbstractCharacter target: targets.getMembers()) {
            if (target.isDead() || target.isEscaped()) continue;

            int damage = target.getDamage(randomAttack);
            target.actionStatus();
        }
        return true;
    }
}
