package rpg.character.hero;

import rpg.ScanCommand;
import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class Hero extends AbstractCharacter {
  // fields
  protected String job = "普通のヒーロー";
  // constructor
  public Hero(String name, int hp, int attack) {
	  super(name, hp, attack);
  }
  // methods
  public void run() {
	  System.out.println(this.getName() + "は逃げ出した！\n");
	  this.escaped = true;
  }
  
  public void rest() { this.setHp(this.getMaxHp()); }
  
  protected void command(AbstractParty allies, AbstractParty enemies) {
	  System.out.println(this.getName() + "(" + this.job + ")の行動");
	  System.out.println("1: 戦う   2: 逃げる   3: 必殺技");
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
  
  public String getJob() { return this.job; }
  
  protected AbstractCharacter selectTarget(AbstractParty targets) {
	  System.out.println("対象は");
	  int i=1;
	  for (AbstractCharacter target: targets.getMembers()) {
		  if (!(target.isDead() || target.isEscaped())) {
			  System.out.println(i + ": " + target.getName());
		  }
		  i++;
	  }
	  System.out.println();
	  int targetNo = ScanCommand.scan() - 1;
	  if (targetNo < targets.getMembers().length) {
		  return (!targets.getMembers()[targetNo].isDead()) ? (targets.getMembers()[targetNo]) : (selectTarget(targets));
	  } else {
		  return selectTarget(targets);
	  }
  }
}