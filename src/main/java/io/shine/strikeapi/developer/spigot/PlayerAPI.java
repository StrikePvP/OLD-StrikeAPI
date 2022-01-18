package io.shine.strikeapi.developer.spigot;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;

public class PlayerAPI {
    public static void sendActionBar(String message, Player p) {
        PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
        IChatBaseComponent component = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");;
        PacketPlayOutChat packet = new PacketPlayOutChat(component, (byte)2);
        connection.sendPacket(packet);
    }
    
    public static void sendTitle(Player p, int fadein, int stay, int fadeout, String title, String subtitle) {
    	PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
    	PacketPlayOutTitle packettimes = new PacketPlayOutTitle(EnumTitleAction.TIMES, null, fadein, stay, fadeout);
    	connection.sendPacket(packettimes);
    	if(subtitle != null) {
    		IChatBaseComponent component = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
    		PacketPlayOutTitle pac = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, component);
    		connection.sendPacket(pac);
    	}
    	if(title != null) {
    		IChatBaseComponent component = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}");
    		PacketPlayOutTitle pac = new PacketPlayOutTitle(EnumTitleAction.TITLE, component);
    		connection.sendPacket(pac);
    	}
    }
}
