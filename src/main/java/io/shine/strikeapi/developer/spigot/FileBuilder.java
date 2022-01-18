package io.shine.strikeapi.developer.spigot;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class FileBuilder {
	
	private String filename;
	private Plugin plugin;
	
	public FileBuilder(String filename, Plugin p) {
		this.plugin = p;
		this.filename = filename;
	}
	
	public File getFile() {
		return new File(plugin.getDataFolder(), filename);
	}
	
	public FileConfiguration getConfig() {
		return (FileConfiguration) YamlConfiguration.loadConfiguration(getFile());
	}
	
	private void save(FileConfiguration config) {
		try {
			config.save(getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void create() {
		if(!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		if(!getFile().exists()) {
			try {
				getFile().createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean isExists() {
		return getFile().exists();
	}
	
	public void setValue(String path, Object o) {
		FileConfiguration config = getConfig();
		config.set(path, o);
		save(config);
	}
	
	public void setArrayList(String path, ArrayList<String> a) {
		FileConfiguration config = getConfig();
		config.set(path, String.join(",", a));
		save(config);
	}
	
	public Object getValue(String path) {
		return getConfig().get(path);
	}
	
	public ArrayList<String> getArrayList(String path){
		String s = getConfig().getString(path);
		ArrayList<String> array = new ArrayList<String>();
		for(String b : s.split(",")) {
			array.add(b);
		}
		return array;
	}
	
	public String getString(String path) {
		return getConfig().getString(path);
	}
	
	public int getInt(String path) {
		return getConfig().getInt(path);
	}

}
