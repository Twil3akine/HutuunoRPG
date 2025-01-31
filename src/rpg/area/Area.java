package rpg.area;

import rpg.character.hero.HeroParty;

public abstract class Area {
    // Field
    protected String name;

    // Constructor
    public Area() {}

    // Methods
    public abstract Area access(HeroParty party);
    public abstract void printArea();
    public abstract String printAction();
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
}