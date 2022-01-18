package io.shine.strikeapi.developer.spigot.skull;

import java.util.ArrayList;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;

import io.shine.strikeapi.developer.spigot.reflections.Reflections;

public class SkullBuilder {
	private ItemStack it;
	private static Base64 base64 = new Base64();
	private SkullMeta sk;
	
	public SkullBuilder() {
		this.it = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		this.sk = (SkullMeta) it.getItemMeta();
	}
	
	public SkullBuilder setOwner(String owner) {
		sk.setOwner(owner);
		return this;
	}
	
	public SkullBuilder setDisplayName(String name) {
		sk.setDisplayName(name);
		return this;
	}
	
	public ItemStack build() {
		it.setItemMeta(sk);
		return it;
	}
	
	public SkullBuilder setCustomUrl(String url) {
		GameProfile gp = new GameProfile(UUID.randomUUID(), null);
		PropertyMap pm = gp.getProperties();
		byte[] enc = base64.encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
		pm.put("textures", new Property("textures", new String(enc)));
		Class<?> hmc = sk.getClass();
		Reflections.getField(hmc, "profile", GameProfile.class).set(sk, gp);
		return this;
	}
	
	public SkullBuilder addLore(String line) {
		ArrayList<String> lores = (ArrayList<String>) sk.getLore();
		if(lores == null) {
			lores = new ArrayList<>();
		}
		if(lores != null) {
			lores.add(line);
		}
		sk.setLore(lores);
		return this;
	}
	
	
}
