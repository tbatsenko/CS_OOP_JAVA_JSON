package domain;

import json.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    private final JsonArray exams;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);
        ArrayList<JsonObject> studExams = new ArrayList<>();
        for (Tuple<String, Integer> exam :exams){
            studExams.add(new JsonExamSample(exam.key, exam.value, exam.value > 2));
        }
        this.exams = new JsonArray((List) studExams);
        
    }

    public JsonObject toJsonObject() {
        JsonObject jsonObject = super.toJsonObject();
        jsonObject.add(new JsonPair("exams", exams));
        return jsonObject;
    }
}
