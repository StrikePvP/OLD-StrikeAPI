package io.shine.tools.common;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;

public class JSONConfig {
    private File file;
    private JsonObject jsonObject;

    public JSONConfig(File f){
        this.jsonObject = load();
        this.file = f;
    }

    private JsonObject load(){
        if(!file.exists()){
            return new JsonObject();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
            BufferedReader br = new BufferedReader(inputStreamReader);
            StringBuilder builder = new StringBuilder();
            String line;
            while((line = br.readLine()) != null){
                builder.append(line);
            }
            br.close();
            inputStreamReader.close();
            fileInputStream.close();
            return new JsonParser().parse(builder.toString()).getAsJsonObject();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            return new JsonObject();
        } catch (IOException e) {
            return new JsonObject();
        }
    }

    public JsonObject getJSONObject() {
        return jsonObject;
    }

    public void save(){
        Gson gson = new Gson();
        try {
            if (file.exists()) {
                file.delete();
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file);
            writer.write(gson.toJson(jsonObject));
            writer.close();
        } catch (IOException e) {
        e   .printStackTrace();
        }
    }
}
