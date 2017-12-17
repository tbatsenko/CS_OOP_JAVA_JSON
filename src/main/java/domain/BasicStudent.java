package domain;

import json.*;

/**
 * Created by Andrii_Rodionov on 1/5/2017.
 */
public class BasicStudent implements Jsonable {

    protected String name;
    protected String surname;
    protected Integer year;

    public BasicStudent() {
    }

    public BasicStudent(String name, String surname, Integer year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonPair studNamePair = new JsonPair("name", new JsonString(name));
        JsonPair studSurnamePair = new JsonPair("surname", new JsonString(surname));
        JsonPair studYearPair = new JsonPair("year", new JsonNumber(year));

        return new JsonObject(studNamePair, studSurnamePair, studYearPair);
    }
}
