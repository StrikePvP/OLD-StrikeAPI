package io.shine.tools.spigot.item;

import io.shine.tools.spigot.item.attributes.ItemAttribute;
import io.shine.tools.spigot.item.glow.GlowEffect;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagInt;
import net.minecraft.server.v1_8_R3.NBTTagList;
import net.minecraft.server.v1_8_R3.NBTTagString;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;


public class ItemBuilder {
    private ItemStack it;
    private ItemMeta meta;
    private Map<ItemAttribute, Integer> attributes;

    public ItemBuilder(Material material){
        it = new ItemStack(material);
        meta = it.getItemMeta();
        this.attributes = new HashMap<>();
    }

    public ItemBuilder(Material material, short damage){
        it = new ItemStack(material, 1, damage);
        meta = it.getItemMeta();
        this.attributes = new HashMap<>();
    }

    public ItemBuilder(Material material, int amount, short damage){
        it = new ItemStack(material, amount, damage);
        meta = it.getItemMeta();
        this.attributes = new HashMap<>();
    }

    public ItemBuilder(Material material, int amount){
        it = new ItemStack(material, amount);
        meta = it.getItemMeta();
        this.attributes = new HashMap<>();
    }

    public ItemBuilder(ItemStack it){
        this.it = it;
        this.meta = it.getItemMeta();
        this.attributes = new HashMap<>();
    }

    public ItemBuilder setName(String name){
        meta.setDisplayName(name);
        return this;
    }

    public ItemBuilder setLore(String... lores){
        meta.setLore(Arrays.asList(lores));
        return this;
    }

    public ItemBuilder addGlow(){
        meta.addEnchant(GlowEffect.getGlow(), 1, true);
        return this;
    }

    public ItemBuilder addEnchant(Enchantment enchantment, int level){
        meta.addEnchant(enchantment, level, true);
        return this;
    }

    public ItemBuilder setItemFlag(ItemFlag itemFlag){
        meta.addItemFlags(itemFlag);
        return this;
    }

    public ItemBuilder addLore(String lore){
        if(meta.hasLore()){
            meta.getLore().add(lore);
        }else{
            meta.setLore(Arrays.asList(lore));
        }
        return this;
    }

    public ItemBuilder setItemFlags(Set<ItemFlag> flags){
        meta.addItemFlags(flags.toArray(new ItemFlag[0]));
        return this;
    }

    public ItemStack build(){
        it.setItemMeta(meta);
        if(!attributes.isEmpty()) {
            net.minecraft.server.v1_8_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(it);
            NBTTagCompound compound = (nmsStack.hasTag() ? nmsStack.getTag() : new NBTTagCompound());
            NBTTagList modifiers = new NBTTagList();
            attributes.forEach((k, v) -> {
                NBTTagCompound attribute = new NBTTagCompound();
                attribute.set("AttributeName", new NBTTagString(k.getName()));
                attribute.set("Name", new NBTTagString(k.getName()));
                attribute.set("Amount", new NBTTagInt(v));
                attribute.set("Operation", new NBTTagInt(0));
                attribute.set("UUIDLeast", new NBTTagInt(894654));
                attribute.set("UUIDMost", new NBTTagInt(2872));
                modifiers.add(attribute);
            });
            compound.set("AttributeModifiers", modifiers);
            nmsStack.setTag(compound);
            it = CraftItemStack.asBukkitCopy(nmsStack);
        }
        return it;
    }

    public ItemBuilder addAttribute(ItemAttribute attribute, int i){
        attributes.put(attribute, i);
        return this;
    }


}
