package rpg.character;

import static rpg.character.State.*;

public abstract class AbstractParty {
	// fields
	final private AbstractCharacter[] members;

	/**
	 * コンストラクタ
	 *
	 * @param members パーティのメンバー
	 */
	public AbstractParty(AbstractCharacter[] members) { this.members = members; }

	/**
	 * 全員が逃げてるかどうか
	 *
	 * @return 全員が逃げていたらtrue
	 */
	protected abstract boolean isAllEscape();

	/**
	 * 全員が死んでいるかどうか
	 *
	 * @return 全員が死んでいたらtrue
	 */
	public boolean isAllDead() {
		for (AbstractCharacter character: this.members) {
			if (!character.isDead()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 全員が戦闘不能かどうか
	 *
	 * @return 全員が戦闘不能ならtrue
	 */
	public boolean isAllFighting() {
		for (AbstractCharacter character: this.members) {
			if (!character.isDead() && !character.isEscaped()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * パーティのターン
	 *
	 * @param enemies 敵パーティ
	 * @return 結果
	 */
	public String turn(AbstractParty enemies) {
	  for (AbstractCharacter character: this.getMembers()) {
		  if (!character.isDead() && !character.isEscaped()) {
			  character.StateAbnormal();
			  if (character.getState() == CORRECT || character.getState() == POISON) character.command(this, enemies);
			  if (enemies.isAllDead()) {
				  return "BEAT";
			  }
			  if (this.isAllEscape() || enemies.isAllFighting()) {
				  return "ESCAPE";
			  }
		  }
	  }
	  return "CONTINUE";
	}

	/**
	 * パーティのメンバーを取得
	 *
	 * @return パーティのメンバー
	 */
  	public AbstractCharacter[] getMembers() { return this.members; }
}
