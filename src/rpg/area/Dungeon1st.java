package rpg.area;

import rpg.character.monster.Monster;
import rpg.character.monster.monster.Dragon;

public class Dungeon1st extends Dungeon {
    public Dungeon1st() {
        super();
        this.name = "ダンジョン地下1階";
        this.floorNumber = 1;
        this.encounterCount = 1;
    }

    public Dungeon1st(int encounterCount) {
        super();
        this.name = "ダンジョン地下1階";
        this.floorNumber = 1;
        this.encounterCount = encounterCount+1;
    }

    /**
     * ボスモンスターを取得
     *
     * @return Monster
     */
    @Override
    protected Monster nextBoss() {
        return new Dragon();
    }

    @Override
    protected Area nextArea(String result) {
        return switch (result) {
                case "VICTORY" -> new DungeonCLEAR();
                case "WIN" -> new Dungeon1st(this.encounterCount-1);
                case "ESCAPE" -> new Dungeon1st(this.encounterCount);
                default -> null;
        };
    }
}
