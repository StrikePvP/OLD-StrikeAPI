package io.shine.tools.spigot.channel;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import io.shine.strikeapi.StrikeAPI;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class BungeeChannelAPI {
    public static void connect(Player p, String server){
        sendMessage(p, "BungeeCord", "Connect", server);
    }

    private static void sendMessage(Player p, String channel, String... lines){
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        Arrays.stream(lines).forEach(s -> {
            out.writeUTF(s);
        });
        p.sendPluginMessage(StrikeAPI.get().getPlugin(), channel, out.toByteArray());
    }
}
