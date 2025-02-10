package rpg.character.monster;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

import java.util.Random;
import java.util.regex.Pattern;

import static rpg.Print.print;

public class Monster extends AbstractCharacter {
    // Constructor

    /**
     * コンストラクタ
     *
     * @param name   モンスター名
     * @param hp     HP
     * @param attack 攻撃力
     */
    public Monster(String name, int hp, int attack) {
        super(name, hp, attack);
    }

    // Methods

    /**
     * 逃げる
     */
    public void run() {
        print(this.getName() + "は逃げ出した！\n");
        this.escaped = true;
    }

    /**
     * コマンドを実行
     *
     * @param allies  味方パーティ
     * @param enemies 敵パーティ
     */
    protected void command(AbstractParty allies,
                           AbstractParty enemies) {
        int command = new Random().nextInt(5);
        if (Pattern.matches(".*ドラゴン.*", this.getName())) {
            print(this.getName());
            if (command == 0) {
                while (true) {
                    if (this.attack(enemies)) {
                        break;
                    }
                }
            } else {
                print(this.getName() + "はボッーとしている\n");
            }
        } else {
            if (command != 0) {
                while (true) {
                    if (this.attack(enemies)) {
                        break;
                    }
                }
            } else {
                print(this.getName() + "はへばっている\n");
            }
        }
    }

    /**
     * 攻撃対象を選択
     *
     * @param targets 対象パーティ
     * @return 攻撃対象
     */
    protected AbstractCharacter selectTarget(AbstractParty targets) {
        int targetNo = new Random().nextInt(targets.getMembers().length);
        if (!targets.getMembers()[targetNo].isDead()) {
            return targets.getMembers()[targetNo];
        } else {
            return selectTarget(targets);
        }
    }
}