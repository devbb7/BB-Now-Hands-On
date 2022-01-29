package files;

import io.restassured.path.json.JsonPath;

public class RawToJSON {
    public static JsonPath rawToJson(String rawTest){
        JsonPath js = new JsonPath(rawTest);
        return js;
    }
}
