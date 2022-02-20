package io.shine.strikeapi.pubsub.packets;

public abstract class SubPacket {
    private String channel;

    public SubPacket(String channel){
        this.channel = channel;
    }

    public String getChannel() {
        return channel;
    }

    public abstract void onReceive(String message);
}
