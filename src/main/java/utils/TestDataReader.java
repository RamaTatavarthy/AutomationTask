package utils;

import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class TestDataReader {

    public HashMap getTestData(String path, String testName) throws IOException, ParseException {

        Object obj = new JSONParser().parse(new FileReader(path));

        JSONObject jo = (JSONObject) obj;

        return new ObjectMapper().readValue(jo.get(testName).toString(), HashMap.class);

    }
}
