package rpg.area;

import rpg.character.monster.Monster;
import rpg.character.monster.monster.KingDamon;
import rpg.character.monster.monster.MatangoAggregate;

public class Dungeon3rd extends Dungeon {
    public Dungeon3rd() {
        super();
        this.name = "ダンジョン地下3階";
        this.floorNumber = 3;
        this.encounterCount = 1;
    }

    public Dungeon3rd(int encounterCount) {
        super();
        this.name = "ダンジョン地下3階";
        this.floorNumber = 3;
        this.encounterCount = encounterCount+1;
    }

    /**
     * ボスモンスターを取得
     *
     * @return Monster
     */
    @Override
    protected Monster nextBoss() {
        return new MatangoAggregate();
    }

    @Override
    protected Area nextArea(String result) {
        return switch (result) {
                case "VICTORY" -> new DungeonCLEAR();
                case "WIN" -> new Dungeon3rd(this.encounterCount-1);
                case "ESCAPE" -> new Dungeon3rd(this.encounterCount);
                default -> null;
        };
    }
}
