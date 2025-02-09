package rpg.character;

import java.util.Random;
import static rpg.Print.print;
import static rpg.character.State.CORRECT;

import rpg.character.State;

public abstract class AbstractCharacter {
	// fields
	protected int attack;
	protected boolean escaped;
	private int hp;
	private int maxHp;
//	private int mp;
//	private int maxMp;
//	private int speed;
	private State state;
	private String name;
	/**
	 * コンストラクタ
	 *
	 * @param name キャラクター名
	 * @param hp HP
	 * @param mp MP
	 * @param attack 攻撃力
	 * @param speed 速さ
	 */
	protected AbstractCharacter(String name, 
																 int hp,
																 //int mp,
																 int attack
																 //int speed
																 )
	{
		this.attack = attack;
		this.escaped = false;
		this.hp = hp; this.maxHp = hp;
		//this.mp = mp; this.maxMp = mp;
		//this.speed = speed;
		this.state = CORRECT;
		this.name = name;
	}

	/**
	 * コマンドを実行
	 *
	 * @param allies 味方パーティ
	 * @param enemies 敵パーティ
	 */
	protected abstract void command(AbstractParty allies,
									AbstractParty enemies);

	/**
	 * 攻撃対象を選択
	 *
	 * @param targets 対象パーティ
	 * @return 攻撃対象
	 */
	protected abstract AbstractCharacter selectTarget(AbstractParty targets);

	/**
	 * キャラクターの各要素を取得
	 *
	 * @return キャラクターの各要素
	 */
	public int getAttack() { return this.attack; }
	public int getHp() { return this.hp; }
	public int getMaxHp() { return this.maxHp; }
	//public int getMp() { return this.mp; }
	//public int getMaxMp() { return this.maxMp; }
	//public int getSpeed() { return this.speed; }
	public State getState() { return this.state; }
	public String getName() { return this.name; }

	/**
	 * キャラクターの各要素を設定
	 *
	 * @param params キャラクターの各パラメータ
	 */
	public void setAttack(int attack) { this.attack = attack; }
	public void setHp(int hp) { this.hp = hp; }
	public void setMaxHp(int maxHp) { this.maxHp = maxHp; }
	//public void setMp(int mp) { this.mp = mp; }
	//public void setMaxMp(int maxMp) { this.maxMp = maxMp; }
	//public void setSpeed(int speed) { this.speed = speed; }
	public void setState(State state) { this.state = state; }
	public void setName(String name) { this.name = name; }

	/**
	 * 生死を返す
	 *
	 * @return キャラクターの生死
	 */
	public boolean isDead() { return this.hp <= 0; }

	/**
	 * 攻撃を行う
	 *
	 * @param enemies 敵パーティ
	 * @return 攻撃が成功したかどうか
	 */
	public boolean attack(AbstractParty enemies) {
		AbstractCharacter target = this.selectTarget(enemies);
		if (target.isDead() || target.isEscaped()) {
			return false;
		}
		Random random = new Random();
		int randomDamage = random.nextInt(this.attack) + this.attack;
		target.getDamage(randomDamage);
		print(this.name + "の攻撃、" + target.name + "に" + randomDamage + "のダメージ！\n");
		target.actionStatus();
		return true;
	}

	/**
	 * キャラクターのHPを減少
	 *
	 * @param damage ダメージ量
	 * @return 実際に与えたダメージ
	 */
	public int getDamage(int damage) {
		damage = Math.min(this.getHp(), damage);
		this.hp -= damage;

		return damage;
	}

	/**
	 * キャラクターのHPを回復
	 *
	 * @param heal 回復量
	 */
	public void getHeal(int heal) {
		this.hp += heal;
		this.hp = Math.min(this.hp, this.maxHp);
	}

	/**
	 * 逃走したかどうかを返す
	 *
	 * @return 逃げることができたかどうか
	 */
	public boolean isEscaped() { return this.escaped; }

	/**
	 * 各キャラクターの isEscape を初期化
	 */
	public void init() { this.escaped = false; }

	/**
	 * キャラクターのステータスを表示
	 */
	public void actionStatus() {
		if (this.isDead()) {
			print(this.name + "は倒れた。\n");
		}

		if (!(this.state == CORRECT)) {
			print(this.name + "は" + switch (this.state) {
				case SLEEP -> "眠ってしまった\n";
				default -> null;
			} + "!");
		}
	}

	public void StateAbnormal() {
		if (!(this.state == CORRECT)) {
			switch (this.state) {
				case SLEEP:
					int recovery = new Random().nextInt(10);
					if (recovery <= 4) this.setState(CORRECT);
					print(this.name + "は" + (this.state.equals(CORRECT) ? "目を覚ました！" : "眠っている..."));
					print();
			}
		}
	}
}