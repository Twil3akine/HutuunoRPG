package rpg.character.monster.monster;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

import java.util.Random;

import static rpg.Print.print;


public class MatangoAggregate extends BossMonster {
    /**
     * コンストラクタ
     * マタンゴの集合体
     */
    public MatangoAggregate() {
        super("マタンゴの集合体", 250, 25);
        this.escaped = false;
    }

    /**
     * 特殊技
     *
     * @param targets 対象パーティ
     * @return true
     */
    public boolean special(AbstractParty targets) {
        print(this.getName() + "のスリープグッドナイト！");

        int currentHp = this.getHp();
        for (AbstractCharacter target: targets.getMembers()) {
            if (target.isDead() || target.isEscaped()) continue;

            int randomAttack = new Random().nextInt(this.attack) + this.attack;
            int damage = target.getDamage(randomAttack);

            print(target.getName() + "は" + damage + "ダメージうけた！");
            target.actionStatus();
        }

        this.getHeal(drainDamage);
        print(this.getName() + "は" + (this.getHp()-currentHp) + "回復した！");

        return true;
    }
}
