package rpg.character.monster.monster;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

import java.util.Random;

import static rpg.Print.print;
import static rpg.character.State.CRASH;


public class King extends BossMonster {
    /**
     * コンストラクタ
     * name: 王, hp: 300, attack: 30
     */
    public King() {
        super("王", 300, 30);
        this.escaped = false;
    }

    /**
     * 特殊技
     *
     * @param targets 対象パーティ
     * @return true
     */
    public boolean special(AbstractParty targets) {
        print(this.getName() + "のコアクラッシュ！\n");

        for (AbstractCharacter target: targets.getMembers()) {
            if (target.isDead() || target.isEscaped()) continue;

            int randomAttack = new Random().nextInt(attack) + (int)(attack*1.5);
            int damage = target.getDamage(randomAttack);
            print(target.getName() + "は" + damage + "ダメージうけた！");
            target.actionStatus();

            this.setState(CRASH);
            this.actionStatus();
        }
        return true;
    }
}
