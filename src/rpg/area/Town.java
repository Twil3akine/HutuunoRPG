package rpg.area;

import rpg.ScanCommand;
import rpg.character.hero.HeroParty;

import static rpg.Print.print;

public class Town extends Area {
    // Constructor
    public Town() {
        super();
        this.name = "杜王町";
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

        print("どこに行きますか？");
        print("1. 宿屋に行く\t2. ダンジョンに行く");

        int nextMove = ScanCommand.scan();
        return switch (nextMove) {
            case 1 -> new Hotel();
            case 2 -> new Dungeon1st();
            default -> this.access(party);
        };
    }
}
