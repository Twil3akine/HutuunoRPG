package rpg.area;

import static rpg.Print.print;
import rpg.ScanCommand;
import rpg.character.hero.HeroParty;
import rpg.character.monster.Monster;

public abstract class Dungeon extends Area {
    //Fields
    protected int floorNumber;
    protected int encounterCount;

    // Constructor
    public Dungeon() {}

    // Methods
    protected abstract Monster nextBoss();
    protected abstract Area nextArea();

    public Area access(HeroParty party) {
        this.printArea();
        party.printPartyStatus();

        print("1: さらに進む\n2: 退却する");

        int nextMove = ScanCommand.scan();
        switch (nextMove) {
            case 1:
                String result = this.explore(party);
                if (result.equals("WIN")) {
                    Area nextArea = this.nextArea();
                    nextArea.access(party);
                } else if (result.equals("LOSE")) {
                    DungeonGAMEOVER gameOver = new DungeonGAMEOVER();
                    gameOver.access(party);
                }
            case 2:

            default:

        }
    }

    public String explore(HeroParty party) {
        return null;
    }

    private String encounterMob(HeroParty party) {
        return null;
    }

    private String encounterBoss(HeroParty party) {
        return null;
    }

    public void printArea() {

    }

    private void printBattleResult(String result,
                                   String string) {

    }
}
