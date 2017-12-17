package json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private ArrayList<JsonPair> jsonElements;

    public JsonObject(JsonPair... jsonPairs) {
        jsonElements = new ArrayList();
        jsonElements.addAll(Arrays.asList(jsonPairs));
    }

    @Override
    public String toJson() {
        StringBuffer jsonStringBuff = new StringBuffer("{");
        for (JsonPair pair : jsonElements){
            JsonString currKey = new JsonString(pair.key);
            jsonStringBuff.append(currKey.toJson()).append(":").append(pair.value.toJson()).append(", ");
        }
        if(!jsonElements.isEmpty()){
            jsonStringBuff.deleteCharAt(jsonStringBuff.lastIndexOf(", "));
        }
        jsonStringBuff.append("}");
        String jsonString = jsonStringBuff.toString();
        return jsonString;
    }

    public void add(JsonPair jsonPair) {
        jsonElements.add(jsonPair);
    }

    public Json find(String name) {
        for(JsonPair pair : jsonElements){
            if (name.equals(pair.key)){
                return pair.value;
            }
        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject jsonObj = new JsonObject();
        for (String name : names){
            if (this.find(name) != null){
                jsonObj.add(new JsonPair(name, this.find(name)));
            }
        }
        return jsonObj;
    }
}
