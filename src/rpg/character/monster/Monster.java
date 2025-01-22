package rpg.character.monster;

import rpg.ScanCommand;
import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

import java.util.Random;

public class Monster extends AbstractCharacter {
    // Constructor
    public Monster(String name, int hp, int attack) {
        super(name, hp, attack);
    }

    // Methods
    public void run() {
        System.out.println(this.getName() + "は逃げ出した！\n");
        this.escaped = true;
    }

    protected void command(AbstractParty allies,
                           AbstractParty enemies) {
        int command = new Random().nextInt(5);
        if (command == 0) {
            while (true) {
                if (this.attack(enemies)) {
                    break;
                }
            }
        } else {
            System.out.println(this.getName() + "はボッーとしている\n");
        }
    }

    protected AbstractCharacter selectTarget(AbstractParty targets) {
        int targetNo = new Random().nextInt(targets.getMembers().length);
        if (!targets.getMembers()[targetNo].isDead()) {
            return targets.getMembers()[targetNo];
        } else {
            return selectTarget(targets);
        }

    }
}