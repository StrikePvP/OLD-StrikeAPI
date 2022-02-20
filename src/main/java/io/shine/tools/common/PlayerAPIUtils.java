package io.shine.tools.common;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

public class PlayerAPIUtils {
    public static UUID getUUID(String name){
        try {
            URL url = new URL("https://api.mojang.com/users/profiles/minecraft/"+name);
            JSONObject json = (JSONObject) new JSONParser().parse(new InputStreamReader(url.openStream()));
            String uuid = (String) json.get("id");
            return UUID.fromString(uuid.substring(0,8)+"-"+uuid.substring(8, 12)+"-"+uuid.substring(12, 16)+"-"+uuid.substring(16, 20)+"-"+uuid.substring(20, 32));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getName(UUID uuid){
        try {
            URL url = new URL("https://sessionserver.mojang.com/session/minecraft/profile/"+uuid.toString().replaceAll("-", ""));
            JSONObject json = (JSONObject) new JSONParser().parse(new InputStreamReader(url.openStream()));
            return (String) json.get("name");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}