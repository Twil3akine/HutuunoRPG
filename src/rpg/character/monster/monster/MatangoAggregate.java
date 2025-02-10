package rpg.character.monster.monster;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

import java.util.Random;

import static rpg.Print.print;
import static rpg.character.State.SLEEP;


public class MatangoAggregate extends BossMonster {
    /**
     * コンストラクタ
     * マタンゴの集合体
     */
    public MatangoAggregate() {
        super("集合体マタンゴ", 250, 25);
        this.escaped = false;
    }

    /**
     * 特殊技
     *
     * @param targets 対象パーティ
     * @return true
     */
    public boolean special(AbstractParty targets) {
        print(this.getName() + "のスリープグッドナイト！\n");

        for (AbstractCharacter target : targets.getMembers()) {
            if (target.isDead() || target.isEscaped()) continue;

            int randomAttack = new Random().nextInt(this.attack);
            int damage = target.getDamage(randomAttack);

            int setAbnormal = new Random().nextInt(10);
            if (setAbnormal <= 5) {
                target.setState(SLEEP);
            }

            print(target.getName() + "は" + damage + "ダメージうけた！");
            target.actionStatus();
        }

        return true;
    }
}
