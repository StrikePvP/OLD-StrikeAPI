package io.shine.strikeapi.pubsub;

import io.shine.strikeapi.pubsub.events.SubscribeEvents;
import io.shine.strikeapi.pubsub.packets.SubPacket;
import redis.clients.jedis.Jedis;

import java.util.HashMap;

public class PubSubAPI {
    private Jedis pool;
    private HashMap<String,SubPacket> subscriberspackets;

    public PubSubAPI(Jedis pool){
        this.pool = pool;
        this.subscriberspackets = new HashMap<>();
    }

    public HashMap<String, SubPacket> getSubscribersPackets() {
        return subscriberspackets;
    }

    public void registerPacket(SubPacket packet){
        subscriberspackets.put(packet.getChannel(), packet);
    }

    public void subscribe(){
        String[] channels = subscriberspackets.keySet().toArray(new String[0]);
        pool.subscribe(new SubscribeEvents(subscriberspackets), channels);
    }

    public void publish(String channel, String message){
        pool.publish(channel, message);
    }
}
