package rpg.character;

import java.util.Random;

import static rpg.Print.print;
import static rpg.character.State.CORRECT;
import static rpg.character.State.CRASH;

public abstract class AbstractCharacter {
    // fields
    protected int attack;
    protected boolean escaped;
    private int hp;
    private int maxHp;
    private int mp;
    //	private int maxMp;
//	private int speed;
    private State state;
    private String name;
    private boolean paralysisFlg;

    /**
     * コンストラクタ
     *
     * @param name   キャラクター名
     * @param hp     HP
     *               //	 * @param mp MP
     * @param attack 攻撃力
     */
    protected AbstractCharacter(String name,
                                int hp,
//																 int mp,
                                int attack
                                //int speed
    ) {
        this.attack = attack;
        this.escaped = false;
        this.hp = hp;
        this.maxHp = hp;
        //this.mp = mp; this.maxMp = mp;
        //this.speed = speed;
        this.state = CORRECT;
        this.name = name;
        this.paralysisFlg = false;
    }

    /**
     * コマンドを実行
     *
     * @param allies  味方パーティ
     * @param enemies 敵パーティ
     */
    protected abstract void command(AbstractParty allies,
                                    AbstractParty enemies);

    /**
     * 攻撃対象を選択
     *
     * @param targets 対象パーティ
     * @return 攻撃対象
     */
    protected abstract AbstractCharacter selectTarget(AbstractParty targets);

    /**
     * キャラクターの各要素を取得
     *
     * @return キャラクターの各要素
     */
    public int getAttack() {
        return this.attack;
    }

    /**
     * キャラクターの各要素を設定
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return this.maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    //public int getMp() { return this.mp; }
    //public int getMaxMp() { return this.maxMp; }
    //public int getSpeed() { return this.speed; }
    public State getState() {
        return this.state;
    }

    //public void setMp(int mp) { this.mp = mp; }
    //public void setMaxMp(int maxMp) { this.maxMp = maxMp; }
    //public void setSpeed(int speed) { this.speed = speed; }
    public void setState(State state) {
        this.state = state;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getParalysisFlg() {
        return this.paralysisFlg;
    }

    public void setParalysisFlg() {
        this.paralysisFlg = !this.paralysisFlg;
    }

    /**
     * 生死を返す
     *
     * @return キャラクターの生死
     */
    public boolean isDead() {
        return this.hp <= 0;
    }

    /**
     * 攻撃を行う
     *
     * @param enemies 敵パーティ
     * @return 攻撃が成功したかどうか
     */
    public boolean attack(AbstractParty enemies) {
        AbstractCharacter target = this.selectTarget(enemies);
        if (target.isDead() || target.isEscaped()) {
            return false;
        }
        Random random = new Random();
        int randomDamage = random.nextInt(this.attack) + this.attack;
        target.getDamage(randomDamage);

        print(this.name + "の攻撃、" + target.name + "に" + (randomDamage * (this.state == CRASH ? 2 : 1)) + "のダメージ！\n");
        target.actionStatus();

        return true;
    }

    /**
     * キャラクターのHPを減少
     *
     * @param damage ダメージ量
     * @return 実際に与えたダメージ
     */
    public int getDamage(int damage) {
        damage = Math.min(this.getHp(), damage * (this.state == CRASH ? 2 : 1));
        this.hp -= damage;

        return damage;
    }

    /**
     * キャラクターのHPを回復
     *
     * @param heal 回復量
     */
    public void getHeal(int heal) {
        this.hp += heal;
        this.hp = Math.min(this.hp, this.maxHp);
    }

    /**
     * 逃走したかどうかを返す
     *
     * @return 逃げることができたかどうか
     */
    public boolean isEscaped() {
        return this.escaped;
    }

    /**
     * 各キャラクターの isEscape を初期化
     */
    public void init() {
        this.escaped = false;
    }

    /**
     * キャラクターのステータスを表示
     */
    public void actionStatus() {
        if (!(this.state == CORRECT) && !this.isDead()) {
            print(this.name + "は" + switch (this.state) {
                case SLEEP -> "眠ってしまった!\n";
                case POISON -> "毒にかかってしまった!\n";
                case PARALYSIS -> "麻痺で体が動かない！\n";
                case CRASH -> "コアが不安定だ！\n";
                default -> null;
            });
        }

        if (this.isDead()) {
            print(this.name + "は倒れた。\n");
        }
    }

    public void StateAbnormal() {
        if (!(this.state == CORRECT)) {
            switch (this.state) {
                case SLEEP:
                    int recovery = new Random().nextInt(10);
                    if (recovery <= 4) this.setState(CORRECT);
                    print(this.name + "は" + (this.state.equals(CORRECT) ? "目を覚ました！" : "眠っている..."));
                    print();
                    break;

                case POISON:
                    int poisonDamage = new Random().nextInt(this.hp - 1) + 1;
                    int damage = this.getDamage(poisonDamage);
                    print(this.name + "は毒で" + damage + "ダメージ受けた！\n");
                    break;

                case PARALYSIS:
                    if (this.paralysisFlg) {
                        print(this.name + "は体のしびれが取れた！");
                        this.setState(CORRECT);
                    } else {
                        print(this.name + "は体がしびれて動かない！\n");
                        this.setParalysisFlg();
                    }
                    break;

                default:
                    break;
            }
        }
    }
}