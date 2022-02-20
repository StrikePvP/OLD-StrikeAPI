package io.shine.tools.spigot.item.attributes;

public enum ItemAttribute {
    MAX_HEALTH("generic.max_health"),
    FOLLOW_RANGE("generic.follow_range"),
    KB_RESISTANCE("generic.knockback_resistance"),
    SPEED("generic.movement_speed"),
    DAMAGE("generic.attack_damage"),
    ARMOR("generic.armor"),
    ARMOUR_TOUGHNESS("generic.armor_toughness"),
    ATTACK_KB("generic.attack_knockback");

    private String name;

    ItemAttribute(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
