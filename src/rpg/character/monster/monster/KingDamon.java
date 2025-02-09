package rpg.character.monster.monster;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;
import static rpg.Print.print;

import java.util.Random;


public class KingDamon extends BossMonster {
    /**
     * コンストラクタ
     * name: キングデーモン, hp: 250, attack: 15
     */
    public KingDamon() {
        super("キングデーモン", 250, 15);
        this.escaped = false;
    }

    /**
     * 特殊技
     *
     * @param targets 対象パーティ
     * @return true
     */
    public boolean special(AbstractParty targets) {
        print(this.getName() + "のギガドレイン！\n");

        int drainDamage = 0;
        int currentHp = this.getHp();
        for (AbstractCharacter target: targets.getMembers()) {
            if (target.isDead() || target.isEscaped()) continue;

            int randomAttack = new Random().nextInt(attack) + attack;
            int damage = target.getDamage(randomAttack);
            drainDamage += damage;
            print(target.getName() + "は" + damage + "ダメージうけた！");
            target.actionStatus();
        }

        this.getHeal(drainDamage);
        print(this.getName() + "は" + (this.getHp()-currentHp) + "回復した！\n");

        return true;
    }
}
