package json;

public class JsonExamSample extends JsonObject {
    public JsonExamSample(String name, Number courseMark, Boolean isPassed) {
        super(new JsonPair("course", new JsonString(name)),
                new JsonPair("mark", new JsonNumber(courseMark)),
                new JsonPair("passed", new JsonBoolean(isPassed)));
    }
}
