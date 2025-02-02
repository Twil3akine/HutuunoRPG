package rpg.character.hero;

import static rpg.Print.print;
import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class HeroParty extends AbstractParty {
	/**
	 * コンストラクタ
	 *
	 * @param heroes ヒーローの配列
	 */
	public HeroParty(AbstractCharacter[] heroes) {
		super(heroes);
	}

	/**
	 * 休む
	 */
	public void rest() {
		for (AbstractCharacter target: this.getMembers()) {
			((Hero)target).rest();
		}
	}

	/**
	 * パーティのステータスを表示
	 */
	public void printPartyStatus() {
		for (AbstractCharacter target: this.getMembers()) {
			this.printPartyStatus((Hero)target);
		}
		print();
	}

	/**
	 * ヒーローのステータスを表示
	 *
	 * @param hero ヒーロー
	 */
	private void printPartyStatus(Hero hero) {
		print(hero.getName() + "(" + hero.job + "): " + (hero.isEscaped() ? "逃亡" : (hero.isDead() ? "死亡" : hero.getHp())));
	}

	/**
	 * パーティのメンバー全員が逃げているかを返す
	 *
	 * @return 全員が逃げている場合は true, そうでない場合は false
	 */
	public boolean isAllEscape() {
		for (AbstractCharacter target: this.getMembers()) {
			if (!target.isEscaped()) {
				return false;
			}
		}
		print("チームは全員逃げている！");
		return true; 
	}

	/**
	 * パーティ全員の逃走フラグを初期化
	 */
	public void init() {
		for (AbstractCharacter target: this.getMembers()) {
			target.init();
		}
	}
}