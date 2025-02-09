package rpg.character.monster.monster;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

import java.util.Random;

import static rpg.Print.print;
import static rpg.character.State.POISON;


public class SlimeSwamp extends BossMonster {
    /**
     * コンストラクタ
     * name: 沼スライム, hp: 300, attack: 10
     */
    public SlimeSwamp() {
        super("沼スライム", 300, 5);
        this.escaped = false;
    }

    /**
     * 特殊技
     *
     * @param targets 対象パーティ
     * @return true
     */
    public boolean special(AbstractParty targets) {
        print(this.getName() + "のポイポイポイズン！\n");

        for (AbstractCharacter target: targets.getMembers()) {
            if (target.isDead() || target.isEscaped()) continue;

            int randomAttack = new Random().nextInt(attack) + attack;
            int damage = target.getDamage(randomAttack);
            print(target.getName() + "は" + damage + "ダメージうけた！");

            int setAbnormal = new Random().nextInt(10);
            if (setAbnormal <= 3) {
                target.setState(POISON);
            }

            target.actionStatus();
        }
        return true;
    }
}
