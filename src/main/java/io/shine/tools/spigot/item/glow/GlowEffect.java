package io.shine.tools.spigot.item.glow;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Field;

public class GlowEffect extends Enchantment {
    private static Enchantment glow;

    public GlowEffect(int id) {
        super(id);
    }

    /**
     * Gets the unique name of this enchantment
     *
     * @return Unique name
     */
    @Override
    public String getName() {
        return "Glow";
    }

    /**
     * Gets the maximum level that this Enchantment may become.
     *
     * @return Maximum level of the Enchantment
     */
    @Override
    public int getMaxLevel() {
        return 5;
    }

    /**
     * Gets the level that this Enchantment should start at
     *
     * @return Starting level of the Enchantment
     */
    @Override
    public int getStartLevel() {
        return 1;
    }

    /**
     * Gets the type of {@link ItemStack} that may fit this Enchantment.
     *
     * @return Target type of the Enchantment
     */
    @Override
    public EnchantmentTarget getItemTarget() {
        return null;
    }

    /**
     * Check if this enchantment conflicts with another enchantment.
     *
     * @param other The enchantment to check against
     * @return True if there is a conflict.
     */
    @Override
    public boolean conflictsWith(Enchantment other) {
        return false;
    }

    /**
     * Checks if this Enchantment may be applied to the given {@link
     * ItemStack}.
     * <p>
     * This does not check if it conflicts with any enchantments already
     * applied to the item.
     *
     * @param item Item to test
     * @return True if the enchantment may be applied, otherwise False
     */
    @Override
    public boolean canEnchantItem(ItemStack item) {
        return true;
    }

    public static Enchantment getGlow(){
        if(glow != null){
            return glow;
        }
        try {
            Field nf = Enchantment.class.getDeclaredField("acceptingNew");
            nf.setAccessible(true);
            nf.set(null, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            glow = new GlowEffect(254);
            Enchantment.registerEnchantment(glow);
        } catch(Exception e){
            glow = Enchantment.getById(254);
        }
        return glow;
    }
}
