package io.shine.tools.messages;

public class ChatUtils {
    public static String replaceHolders(String message, Object... holders){
        for (int i = 0; i <= holders.length - 1; i += 2) {
            message = message.replaceAll(String.valueOf(holders[i]), String.valueOf(holders[i+1]));
        }
        return message;
    }

    public static String applyColor(String text){
        return text.replaceAll("&", "§");
    }


}
