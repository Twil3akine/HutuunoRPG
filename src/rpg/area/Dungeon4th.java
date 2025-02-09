package rpg.area;

import rpg.character.monster.Monster;
import rpg.character.monster.monster.MatangoAggregate;
import rpg.character.monster.monster.SlimeSwamp;

public class Dungeon4th extends Dungeon {
    public Dungeon4th() {
        super();
        this.name = "ダンジョン地下4階";
        this.floorNumber = 4;
        this.encounterCount = 1;
    }

    public Dungeon4th(int encounterCount) {
        super();
        this.name = "ダンジョン地下4階";
        this.floorNumber = 4;
        this.encounterCount = encounterCount+1;
    }

    /**
     * ボスモンスターを取得
     *
     * @return Monster
     */
    @Override
    protected Monster nextBoss() { return new SlimeSwamp(); }

    @Override
    protected Area nextArea(String result) {
        return switch (result) {
                case "VICTORY" -> new DungeonCLEAR();
                case "WIN" -> new Dungeon4th(this.encounterCount-1);
                case "ESCAPE" -> new Dungeon4th(this.encounterCount);
                default -> null;
        };
    }
}
