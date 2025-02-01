package rpg.character.hero.job;

import static rpg.Print.print;
import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

import java.util.Random;
import java.util.regex.Pattern;

public class Warrior extends AbstractSuperHero {
    /**
     * コンストラクタ
     *
     * @param name 名前
     */
    public Warrior(String name) {
        super(name, 200, 30);
        this.job = "戦士";
        this.escaped = false;
    }

    /**
     * 特殊技
     *
     * @param targets 対象パーティ
     * @return true
     */
    public boolean special(AbstractParty targets) {
        AbstractCharacter target = selectTarget(targets);
        if (target.isDead()) return false;

        int randomAttack = new Random().nextInt(attack) + attack + (Pattern.matches(".*ドラゴン.*", target.getName()) ? 30 : 0);
        int damage = target.getDamage(randomAttack);

        print(this.getName() + "のドラゴンキック！ " + target.getName() + "は" + randomAttack + "のダメージを受けた！");
        target.actionStatus();

        return true;
    }
}
