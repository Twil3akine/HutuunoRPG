package rpg.character;

public abstract class AbstractParty {
	// fields
	private AbstractCharacter[] members;

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
	protected abstract boolean isEscapeAll();

	/**
	 * 全員が死んでいるかどうか
	 *
	 * @return 全員が死んでいたらtrue
	 */
	public boolean isAllDead() {
		boolean deadFlg = false;
		for (AbstractCharacter character: this.members) {
			if (!character.isDead()) {
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
			  character.command(this, enemies);
			  if (enemies.isAllDead()) {
				  return "BEAT";
			  }
			  if (this.isEscapeAll()) {
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
