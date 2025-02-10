package rpg.character.hero;

import rpg.ScanCommand;
import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

import static rpg.Print.print;

public class Hero extends AbstractCharacter {
	// fields
	protected String job = "普通のヒーロー";

	/**
	 * コンストラクタ
	 *
	 * @param name 名前
	 * @param hp HP
	 * @param attack 攻撃力
	 */
	public Hero(String name, int hp, int attack) {
	  super(name, hp, attack);
	}

	/**
	 * 逃げる
	 */
	public void run() {
	  System.out.println(this.getName() + "は逃げ出した！\n");
	  this.escaped = true;
	}

	/**
	 * 休む
	 */
	public void rest() { this.setHp(this.getMaxHp()); }

	/**
	 * コマンドを実行
	 *
	 * @param allies 味方パーティ
	 * @param enemies 敵パーティ
	 */
	protected void command(AbstractParty allies, AbstractParty enemies) {
		print(this.getName() + "(" + this.job + ")の行動");
		print("1: 戦う   2: 逃げる   3: 必殺技");
		int command = ScanCommand.scan();
		switch (command) {
			case (1), (3):
				while (true) {
					if (this.attack(enemies)) {
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

	/**
	 * キャラクターの職業を取得
	 *
	 * @return 職業
	 */
	public String getJob() { return this.job; }

	/**
	 * 攻撃対象を選択
	 *
	 * @param targets 対象パーティ
	 * @return 攻撃対象
	 */
	protected AbstractCharacter selectTarget(AbstractParty targets) {
		print("対象は");
		int i=1;
		for (AbstractCharacter target: targets.getMembers()) {
			if (!(target.isDead() || target.isEscaped())) {
			  print(i + ": " + target.getName());
			}
			i++;
		}
		print();
		int targetNo = ScanCommand.scan() - 1;
		if (targetNo < targets.getMembers().length) {
		  return (!targets.getMembers()[targetNo].isDead()) ? (targets.getMembers()[targetNo]) : (selectTarget(targets));
		} else {
		  return selectTarget(targets);
		}
	}
}