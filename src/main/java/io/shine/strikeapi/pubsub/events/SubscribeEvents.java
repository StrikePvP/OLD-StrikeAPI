package io.shine.strikeapi.pubsub.events;

import io.shine.strikeapi.pubsub.packets.SubPacket;
import redis.clients.jedis.JedisPubSub;

import java.util.HashMap;

public class SubscribeEvents extends JedisPubSub {
    private HashMap<String, SubPacket> packets;

    public SubscribeEvents(HashMap<String, SubPacket> packets){
        this.packets = packets;
    }

    @Override
    public void onMessage(String channel, String message) {
        if(packets.containsKey(channel)){
            packets.get(channel).onReceive(message);
        }
        super.onMessage(channel, message);
    }

}
