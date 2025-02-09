package rpg.character.monster.monster;

import rpg.character.monster.Monster;

public class Damon extends Monster {
    /**
     * コンストラクタ
     *
     * @param id のID
     */
    public Damon(int id) {
        super("デーモン" + id, 50, 5);
    }
}
