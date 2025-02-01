package rpg.character.monster.monster;

import rpg.character.monster.Monster;

public class BabyDragon extends Monster {
    /**
     * コンストラクタ
     *
     * @param id のID
     */
    public BabyDragon(int id) {
        super("ベビードラゴン" + id, 50, 5);
    }
}
