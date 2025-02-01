package rpg.character.monster;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class MonsterParty extends AbstractParty {
    /**
     * コンストラクタ
     *
     * @param monsters モンスターの配列
     */
    public MonsterParty(AbstractCharacter[] monsters) {
        super(monsters);
    }

    /**
     * パーティのメンバー全員が逃げているかを返す
     *
     * @return 全員が逃げている場合は true, そうでない場合は false
     */
    protected boolean isEscapeAll() {
        for (AbstractCharacter monster: this.getMembers()) {
            if (!monster.isEscaped()) {
                return false;
            }
        }
        return true;
    }
}