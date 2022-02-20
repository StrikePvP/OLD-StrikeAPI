package io.shine.tools.messages;

public class ChatUtils {
    /**
     * Replace Holders on a text
     * @param message Text
     * @return Message with replaced Holders
     */
    public static String replaceHolders(String message, Object... holders){
        for (int i = 0; i <= holders.length - 1; i += 2) {
            message = message.replaceAll(String.valueOf(holders[i]), String.valueOf(holders[i+1]));
        }
        return message;
    }

    /**
     * Apply color on text
     */
    public static String applyColor(String text){
        return text.replaceAll("&", "§");
    }

    public static String centerText(String text){
        StringBuilder builder = new StringBuilder();
        int pos = (65/2)-(text.length()/2);
        for(int i = 0; i < pos; i++){
            builder.append(" ");
        }
        builder.append(text);
        return builder.toString();
    }

}
