package rpg.character.monster.monster;

import rpg.character.AbstractParty;
import rpg.character.Specialist;
import rpg.character.monster.Monster;

import java.util.Random;

import static rpg.Print.print;

public abstract class BossMonster extends Monster implements Specialist {
    /**
     * コンストラクタ
     *
     * @param name モンスター名
     * @param hp HP
     * @param attack 攻撃力
     */
    public BossMonster(String name, int hp, int attack) {
        super(name, hp, attack);
    }

    /**
     * コマンドを実行
     *
     * @param allies 味方パーティ
     * @param enemies 敵パーティ
     */
    protected void command(AbstractParty allies,
                           AbstractParty enemies) {
        int command = new Random().nextInt(11);
        if (command < 10) {
            while (true) {
                if (command <= 4 ? this.special(enemies) : this.attack((enemies))) {
                    break;
                }
            }
        } else {
            print(this.getName() + "は我々を見下している！\n");
        }
    }
}
