package rpg.area;

import rpg.character.monster.Monster;
import rpg.character.monster.monster.Dragon;
import rpg.character.monster.monster.KingDamon;

public class Dungeon2nd extends Dungeon {
    public Dungeon2nd() {
        super();
        this.name = "ダンジョン地下2階";
        this.floorNumber = 2;
        this.encounterCount = 1;
    }

    public Dungeon2nd(int encounterCount) {
        super();
        this.name = "ダンジョン地下2階";
        this.floorNumber = 2;
        this.encounterCount = encounterCount+1;
    }

    /**
     * ボスモンスターを取得
     *
     * @return Monster
     */
    @Override
    protected Monster nextBoss() {
        return new KingDamon();
    }

    @Override
    protected Area nextArea(String result) {
        return switch (result) {
                case "VICTORY" -> new DungeonCLEAR();
                case "WIN" -> new Dungeon2nd(this.encounterCount-1);
                case "ESCAPE" -> new Dungeon2nd(this.encounterCount);
                default -> null;
        };
    }
}
