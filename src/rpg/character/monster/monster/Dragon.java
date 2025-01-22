package rpg.character.monster.monster;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

import java.util.Random;

public class Dragon extends BossMonster {
    public Dragon() {
        super("ドラゴン", 200, 30);
        this.escaped = false;
    }

    public boolean special(AbstractParty targets) {
        System.out.println(this.getName() + "の流星群！");

        for (AbstractCharacter target: targets.getMembers()) {
            if (target.isDead() || target.isEscaped()) continue;

            int randomAttack = new Random().nextInt(attack) + attack;
            int damage = target.getDamage(randomAttack);
            System.out.println(target.getName() + "は" + damage + "ダメージうけた！");
            target.actionStatus();
        }
        return true;
    }
}
