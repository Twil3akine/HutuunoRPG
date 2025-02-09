package rpg.character.monster.monster;

import rpg.character.monster.Monster;

public class Slime extends Monster {
    /**
     * コンストラクタ
     *
     * @param id のID
     */
    public Slime(int id) {
        super("スライム" + id, 50, 5);
    }
}
