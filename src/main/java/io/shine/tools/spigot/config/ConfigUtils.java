package io.shine.tools.spigot.config;

import io.shine.tools.spigot.item.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Set;

public class ConfigUtils extends YamlConfiguration {

    public void setItem(String path, ItemStack it){
        ItemMeta itemMeta = it.getItemMeta();
        set(path+".material", it.getType().name());
        set(path+".damage", it.getDurability());
        set(path+".amount", it.getAmount());
        if(itemMeta.hasDisplayName()) {
            set(path+".name", itemMeta.getDisplayName());
        }
        if(itemMeta.hasLore()){
            set(path+".lores", itemMeta.getLore());
        }
        if(itemMeta.hasEnchants()){
            itemMeta.getEnchants().entrySet().forEach(e -> {
                set(path+".enchants."+e.getKey().getName(), e.getValue());
            });
        }
        if(!itemMeta.getItemFlags().isEmpty()) {
            set(path + ".itemflags", itemMeta.getItemFlags());
        }
    }

    public ItemStack getItem(String path){
        ConfigurationSection section = getConfigurationSection(path);
        ItemBuilder builder = new ItemBuilder(Material.getMaterial(section.getString("material")),
                section.getInt("amount"), (short) section.getInt("damage"));
        if(section.contains("name")){
            builder.setName(section.getString("name"));
        }
        if(section.contains("lores")){
            builder.setLore(section.getStringList("lores").toArray(new String[0]));
        }
        if(section.contains("enchants")){
            section.getConfigurationSection("enchants").getKeys(true).forEach(k -> {
                builder.addEnchant(Enchantment.getByName(k), section.getInt("enchants."+k));
            });
        }
        if(section.contains("itemflags")){
            Set<ItemFlag> flags = (Set<ItemFlag>) section.getList("itemflags");
            builder.setItemFlags(flags);
        }
        return builder.build();
    }

    public void setLocation(String path, Location location){
        set(path+".world", location.getWorld().getName());
        set(path+".x", location.getX());
        set(path+".y", location.getY());
        set(path+".z", location.getZ());
        set(path+".pitch", location.getPitch());
        set(path+".yaw", location.getYaw());
    }

    public Location getLocation(String path){
        ConfigurationSection section = getConfigurationSection(path);
        return new Location(Bukkit.getWorld(section.getString("name")),
                section.getDouble("x"), section.getDouble("y"), section.getDouble("z"),
                Float.parseFloat(section.getString("pitch")), Float.parseFloat(section.getString("yaw")));
    }
}
