package rpg.character.monster.monster;

import rpg.character.monster.Monster;

public class ImperialGuard extends Monster {
    /**
     * コンストラクタ
     *
     * @param id のID
     */
    public ImperialGuard(int id) {
        super("王の近衛兵" + id, 200, 15);
    }
}
