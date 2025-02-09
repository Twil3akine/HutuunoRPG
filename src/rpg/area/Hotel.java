package rpg.area;

import rpg.ScanCommand;
import rpg.character.hero.HeroParty;

import static rpg.Print.print;

public class Hotel extends Area {
    // Constructor
    public Hotel() {
        super();
        this.name = "町はずれの寂れた宿屋";
    }

    // Methods

    /**
     * エリアにアクセスする
     *
     * @param party パーティ
     * @return Area
     */
    @Override
    public Area access(HeroParty party) {
        this.printArea();
        party.printPartyStatus();

        print("どうしますか");
        print("1. 休む\t2. 町に向かう");

        int nextMove = ScanCommand.scan();
        switch (nextMove) {
            case 1:
                party.rest();
            case 2:
                return new Town();
            default:
                return this.access(party);
        }
    }
}