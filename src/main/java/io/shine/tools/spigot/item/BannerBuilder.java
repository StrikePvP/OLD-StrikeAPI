package io.shine.tools.spigot.item;

import io.shine.tools.spigot.item.glow.GlowEffect;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

import java.util.Arrays;
import java.util.Set;

public class BannerBuilder {
    private BannerMeta meta;
    private ItemStack it;

    public BannerBuilder(){
        this.it = new ItemStack(Material.BANNER);
        this.meta = (BannerMeta) it.getItemMeta();
    }

    public BannerBuilder addPattern(Pattern... patterns){
        for(Pattern pattern : patterns){
            meta.addPattern(pattern);
        }
        return this;
    }

    public BannerBuilder setName(String name){
        meta.setDisplayName(name);
        return this;
    }

    public BannerBuilder setBaseColor(DyeColor color){
        meta.setBaseColor(color);
        return this;
    }

    public BannerBuilder setLore(String... lores){
        meta.setLore(Arrays.asList(lores));
        return this;
    }

    public BannerBuilder addGlow(){
        meta.addEnchant(GlowEffect.getGlow(), 1, true);
        return this;
    }

    public BannerBuilder addEnchant(Enchantment enchantment, int level){
        meta.addEnchant(enchantment, level, true);
        return this;
    }

    public BannerBuilder setItemFlag(ItemFlag itemFlag){
        meta.addItemFlags(itemFlag);
        return this;
    }

    public BannerBuilder addLore(String lore){
        if(meta.hasLore()){
            meta.getLore().add(lore);
        }else{
            meta.setLore(Arrays.asList(lore));
        }
        return this;
    }

    public BannerBuilder setItemFlags(Set<ItemFlag> flags){
        meta.addItemFlags(flags.toArray(new ItemFlag[0]));
        return this;
    }

    public ItemStack toItem(){
        it.setItemMeta(meta);
        return it;
    }
}