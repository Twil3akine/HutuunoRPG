package rpg.character;

import java.util.Random;
import static rpg.Print.print;

public abstract class AbstractCharacter extends Object {
	// fields
	protected int attack;
	protected boolean escaped;
	private int hp;
	private int maxHp;
//	private int mp;
//	private int maxMp;
//	private int speed;
//	private State state;
	private String name;
	// constructor
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
		//this.state = State.NONE;
		this.name = name;
	}
	// methods
	protected abstract void command(AbstractParty allies,
									AbstractParty enemies);
	
	protected abstract AbstractCharacter selectTarget(AbstractParty targets);
	
	public int getAttack() { return this.attack; }
	public int getHp() { return this.hp; }
	public int getMaxHp() { return this.maxHp; }
	//public int getMp() { return this.mp; }
	//public int getMaxMp() { return this.maxMp; }
	//public int getSpeed() { return this.speed; }
	//public State getState() { return this.state; }
	public String getName() { return this.name; }
	
	public void setAttack(int attack) { this.attack = attack; }
	public void setHp(int hp) { this.hp = hp; }
	public void setMaxHp(int maxHp) { this.maxHp = maxHp; }
	//public void setMp(int mp) { this.mp = mp; }
	//public void setMaxMp(int maxMp) { this.maxMp = maxMp; }
	//public void setSpeed(int speed) { this.speed = speed; }
	//public void setState(State state) { this.state = state; }
	public void setName(String name) { this.name = name; }

	public boolean isDead() { return (this.hp <= 0) ? (true) : (false); }

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

  		public int getDamage(int damage) {
  			this.hp -= damage;
  			if (this.hp<0) {
  				this.hp = 0;
  			}
  			return damage;
  		}

  		public int getHeal(int heal) {
  			this.hp += heal;
  			if (this.hp > this.maxHp) {
  				this.hp = this.maxHp;
  			}
  			return heal;
  		}

  		public boolean isEscaped() { return this.escaped; }

  		public void init() { this.escaped = false; }
  
  		public void actionStatus() {
  			if (this.isDead()) {
  				print(this.name + "は倒れた。");
		}
	}
}