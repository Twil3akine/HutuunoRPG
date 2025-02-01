package rpg.area;

import rpg.character.hero.HeroParty;

public abstract class Area {
    // Field
    protected String name;

    // Constructor
    public Area() {}

    /**
     * エリアにアクセスする
     *
     * @param party パーティ
     * @return Area
     */
    public abstract Area access(HeroParty party);

    /**
     * エリアの名前を出力
     */
    public abstract void printArea();

    /**
     * エリアでのアクションの選択肢を出力
     *
     * @return String
     */
    public abstract String printAction();

    /**
     * エリアの名前を取得
     *
     * @return String エリアの名前
     */
    public String getName() { return this.name; }

    /**
     * エリアの名前を設定
     *
     * @param name エリアの名前
     */
    public void setName(String name) { this.name = name; }
}