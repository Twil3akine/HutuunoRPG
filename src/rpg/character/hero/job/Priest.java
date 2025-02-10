package rpg.character.hero.job;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

import java.util.Random;

import static rpg.Print.print;
import static rpg.character.State.CORRECT;

public class Priest extends AbstractSuperHero {
    /**
     * コンストラクタ
     *
     * @param name 名前
     */
    public Priest(String name) {
        super(name, 100, 4);
        this.job = "僧侶";
        this.escaped = false;
    }

    /**
     * 特殊技
     *
     * @param targets 対象パーティ
     * @return true
     */
    public boolean special(AbstractParty targets) {
        print(this.getName() + "のヒール！\n味方全体のHPを回復した！");
        for (AbstractCharacter target : targets.getMembers()) {
            if (target.isDead() || target.isEscaped()) continue;

            int randomHeal = new Random().nextInt(20) + 10;

            target.getHeal(randomHeal);
            print(target.getName() + "は" + randomHeal + "回復した！");

            if (target.getState() != CORRECT) {
                target.setState(CORRECT);
                print(this.getName() + "は状態異常が治った！\n");
            }
        }
        print();
        return true;
    }
}
