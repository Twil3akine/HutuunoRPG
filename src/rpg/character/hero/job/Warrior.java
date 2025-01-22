package rpg.character.hero.job;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

import java.util.Random;

public class Warrior extends AbstractSuperHero {
    public Warrior(String name) {
        super(name, 200, 30);
        this.job = "戦士";
        this.escaped = false;
    }

    public boolean special(AbstractParty targets) {
        AbstractCharacter target = selectTarget(targets);
        if (target.isDead()) return false;

        int randomAttack = new Random().nextInt(attack) + attack + (target.getName().equals("ドラゴン") ? 30 : 0);
        int damage = target.getDamage(randomAttack);

        System.out.println(this.getName() + "のドラゴンキック！ " + target.getName() + "は" + randomAttack + "のダメージを受けた！");
        target.actionStatus();

        return true;
    }
}
