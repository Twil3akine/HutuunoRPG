package rpg.character;

public abstract class AbstractCharacter extends Object {
	// fields
	protected int attack;
	protected boolean escaped;
	private int hp;
	private int maxHp;
	private int mp;
	private int maxMp;
	private int speed;
	private State state;
	private String name;
	// constructor
	protected AbstractCharacter(String name, 
																 int hp,
																 int mp,
																 int attack,
																 int speed) {
		this.attack = attack;
		this.escaped = false;
		this.hp = hp; this.maxHp = hp;
		this.mp = mp; this.maxMp = mp;
		this.speed = speed;
		this.state = State.NONE;
		this.name = name;
	}
	// methods
	protected abstract AbstractCharacter command(AbstractParty allies,
																										  AbstractParty enemies);
	
	protected abstract AbstractCharacter selectTarget(AbstractParty targets);
	
	public int getAttack() { return this.attack; }
	public int getHp() { return this.hp; }
	public int getMaxHp() { return this.maxHp; }
	public int getMp() { return this.mp; }
	public int getMaxMp() { return this.maxMp; }
	public int getSpeed() { return this.speed; }
	public State getState() { return this.state; }
	public String getName() { return this.name; }
	
	public void setAttack(int attack) { this.attack = attack; }
	public void setHp(int hp) { this.hp = hp; }
	public void setMaxHp(int )
}