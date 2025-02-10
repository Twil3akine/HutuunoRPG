package rpg.area;

import rpg.BattleField;
import rpg.ScanCommand;
import rpg.character.hero.HeroParty;
import rpg.character.monster.Monster;
import rpg.character.monster.MonsterParty;
import rpg.character.monster.monster.*;

import java.util.Random;

import static rpg.Print.print;

public abstract class Dungeon extends Area {
    //Fields
    protected int floorNumber;
    protected int encounterCount;

    //Constructor
    public Dungeon() {}
    public Dungeon(int encounterCount) {
        this.encounterCount = encounterCount + 1;
    }

    /**
     * ボスモンスターを取得
     *
     * @return Monster
     */
    protected abstract Monster nextBoss();

    /**
     * 次のエリアを取得
     *
     * @return Area
     */
    protected abstract Area nextArea(String result);

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

        print("1. 探索を続ける\t2. 一度引き返す");

        int nextMove = ScanCommand.scan();
        return switch (nextMove) {
            case 1 -> {
                String result = this.explore(party);
                yield switch (result) {
                    case "VICTORY", "WIN", "ESCAPE" -> this.nextArea(result).access(party);
                    case "LOSE" -> new DungeonGAMEOVER().access(party);
                    default -> null;
                };
            }
            case 2 -> new Town();
            default -> this.access(party);
        };
    }

    /**
     * 探索
     *
     * @param party パーティ
     * @return String WIN, LOSE, ESCAPE or VICTORY
     */
    public String explore(HeroParty party) {
        print("探索中... (" + this.encounterCount + "回目)");

        String result = (this.encounterCount >= 3)
            ? ((int)(Math.random() * 10) <= 2)
                ? this.encounterBoss(party) : this.encounterMob(party)
            : this.encounterMob(party);

        this.encounterCount = switch (result) {
            case "VICTORY" -> 1;
            case "WIN" -> this.encounterCount + 1;
            default -> this.encounterCount;
        };

        return result;
    }

    /**
     * モブとのエンカウント
     *
     * @param party パーティ
     * @return String WIN or LOSE
     */
    private String encounterMob(HeroParty party) {
        print("モンスターが現れた！");

        Random random = new Random();
        int numberOfMonsters = random.nextInt(3) + 1;

        Monster[] monsters = new Monster[numberOfMonsters];
        for (int i=0; i<numberOfMonsters; i++) {
            monsters[i] = switch (this.floorNumber) {
                case 1 -> new BabyDragon(i+1);
                case 2 -> new Damon(i+1);
                case 3 -> new Matango(i+1);
                case 4 -> new Slime(i+1);
                case 5 -> new ImperialGuard(i+1);
                default -> null;
            };
        }
        MonsterParty monsterParty = new MonsterParty(monsters);

        String battleResult = BattleField.battle(party, monsterParty);

        this.printBattleResult(battleResult, "モンスターとの戦い");

        return battleResult;
    }

    /**
     * ボスとのエンカウント
     *
     * @param party パーティ
     * @return String WIN or LOSE
     */
    private String encounterBoss(HeroParty party) {
        print("ボスモンスターが現れた！");

        Monster monster = this.nextBoss();

        String battleResult = BattleField.battle(party, monster);

        this.printBattleResult(battleResult, monster.getName() + "との戦い");

        return (battleResult.equals("WIN")) ? "VICTORY" : "LOSE";
    }

    /**
     * エリア情報を表示
     */
    public void printArea() {
        print((this.encounterCount == 1) ? "ここは" + this.name + "です" : "次はどうしますか？");
    }

    /**
     * バトル結果を表示
     *
     * @param result 結果
     * @param string メッセージ
     */
    private void printBattleResult(String result,
                                   String string) {
        System.out.print("勇者たちは" + string);

        print(switch (result) {
            case "VICTORY" -> "を撃破した！";
            case "WIN" -> "に勝利した";
            case "LOSE" -> "に敗北した";
            case "ESCAPE" -> "から逃げだした";
            default -> "";
        });

        print();
    }
}
