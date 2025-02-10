package rpg.character.hero.job;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

import java.util.Random;

import static rpg.Print.print;
import static rpg.character.State.PARALYSIS;

public class Sorcerer extends AbstractSuperHero {
    /**
     * コンストラクタ
     *
     * @param name 名前
     */
    public Sorcerer(String name) {
        super(name, 100, 15);
        this.job = "魔法使い";
        this.escaped = false;
    }

    /**
     * 特殊技
     *
     * @param targets 対象パーティ
     * @return true
     */
    public boolean special(AbstractParty targets) {
        int randomAttack = new Random().nextInt(attack) + attack;
        print(this.getName() + "のライトニング！\n相手全体に" + randomAttack + "のダメージを与えた！\n");

        for (AbstractCharacter target: targets.getMembers()) {
            if (target.isDead() || target.isEscaped()) continue;

            target.getDamage(randomAttack);

            int setAbnormal = new Random().nextInt(10);
            if (setAbnormal <= 3) {
                target.setState(PARALYSIS);
            }
        }
        return true;
    }
}
