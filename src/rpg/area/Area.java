package rpg.area;

import rpg.character.hero.HeroParty;

import static rpg.Print.print;

public abstract class Area {
    // Field
    protected String name;

    // Constructor
    public Area() {
    }

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
    public void printArea() {
        print("ここは" + this.name + "です");
    }

    /**
     * エリアの名前を取得
     *
     * @return String エリアの名前
     */
    public String getName() {
        return this.name;
    }

    /**
     * エリアの名前を設定
     *
     * @param name エリアの名前
     */
    public void setName(String name) {
        this.name = name;
    }
}