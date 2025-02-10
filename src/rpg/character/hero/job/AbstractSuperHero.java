package rpg.character.hero.job;

import rpg.ScanCommand;
import rpg.character.AbstractParty;
import rpg.character.Specialist;
import rpg.character.hero.Hero;

import static rpg.Print.print;

public abstract class AbstractSuperHero extends Hero implements Specialist {
    /**
     * コンストラクタ
     *
     * @param name   名前
     * @param hp     HP
     * @param attack 攻撃力
     */
    public AbstractSuperHero(String name, int hp, int attack) {
        super(name, hp, attack);
    }

    /**
     * コマンドを実行
     *
     * @param allies  味方パーティ
     * @param enemies 敵パーティ
     */
    protected void command(AbstractParty allies, AbstractParty enemies) {
        print(this.getName() + "(" + this.job + ")の行動");
        print("1: 戦う   2: 逃げる   3: 必殺技");
        int command = ScanCommand.scan();
        switch (command) {
            case (1), (3):
                while (true) {
                    if (command == 1 ? this.attack(enemies) : this.special(this.getJob().matches("僧侶") ? (allies) : (enemies))) {
                        break;
                    }
                }
                break;
            case (2):
                this.run();
                break;
            default:
                this.command(allies, enemies);
        }
    }
}