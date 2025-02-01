package rpg.area;

import static rpg.Print.print;
import rpg.ScanCommand;
import rpg.character.hero.HeroParty;
import rpg.character.monster.Monster;

public abstract class Dungeon extends Area {
    //Fields
    protected int floorNumber;
    protected int encounterCount;

    public Dungeon() {}

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
    protected abstract Area nextArea();

    @Override
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

    /**
     * 探索
     *
     * @param party パーティ
     * @return String WIN or LOSE
     */
    public String explore(HeroParty party) {
        return null;
    }

    /**
     * モブとのエンカウント
     *
     * @param party パーティ
     * @return String WIN or LOSE
     */
    private String encounterMob(HeroParty party) {
        return null;
    }

    /**
     * ボスとのエンカウント
     *
     * @param party パーティ
     * @return String WIN or LOSE
     */
    private String encounterBoss(HeroParty party) {
        return null;
    }

    @Override
    public void printArea() {

    }

    /**
     * バトル結果を表示
     *
     * @param result 結果
     * @param string メッセージ
     */
    private void printBattleResult(String result,
                                   String string) {

    }
}
