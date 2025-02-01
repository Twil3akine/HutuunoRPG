package rpg.character.monster.monster;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;
import static rpg.Print.print;

import java.util.Random;


public class Dragon extends BossMonster {
    /**
     * コンストラクタ
     * name: ドラゴン, hp: 200, attack: 30
     */
    public Dragon() {
        super("ドラゴン", 200, 30);
        this.escaped = false;
    }

    /**
     * 特殊技
     *
     * @param targets 対象パーティ
     * @return true
     */
    public boolean special(AbstractParty targets) {
        print(this.getName() + "の流星群！");

        for (AbstractCharacter target: targets.getMembers()) {
            if (target.isDead() || target.isEscaped()) continue;

            int randomAttack = new Random().nextInt(attack) + attack;
            int damage = target.getDamage(randomAttack);
            print(target.getName() + "は" + damage + "ダメージうけた！");
            target.actionStatus();
        }
        return true;
    }
}
