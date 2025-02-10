package rpg.area;

import rpg.character.monster.Monster;
import rpg.character.monster.monster.King;

public class DungeonFINAL extends Dungeon {
    public DungeonFINAL() {
        super();
        this.name = "王の間";
        this.floorNumber = 5;
        this.encounterCount = 1;
    }

    public DungeonFINAL(int encounterCount) {
        super();
        this.name = "王の間";
        this.floorNumber = 5;
        this.encounterCount = encounterCount + 1;
    }

    /**
     * ボスモンスターを取得
     *
     * @return Monster
     */
    @Override
    protected Monster nextBoss() {
        return new King();
    }

    @Override
    protected Area nextArea(String result) {
        return switch (result) {
            case "VICTORY" -> new DungeonCLEAR();
            case "WIN" -> new DungeonFINAL(this.encounterCount - 1);
            case "ESCAPE" -> new DungeonFINAL(this.encounterCount);
            default -> null;
        };
    }
}
