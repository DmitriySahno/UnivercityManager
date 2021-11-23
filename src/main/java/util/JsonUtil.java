package util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.CommonStructure;
import model.Student;
import model.University;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class JsonUtil {

    private static final Gson gson = new Gson();
    private static final Logger logger = Logger.getLogger(JsonUtil.class.getName());

    private JsonUtil() {
    }

    public static Object jsonToObject(String json, Object o) {
        return gson.fromJson(new StringReader(json), o.getClass());
    }

    public static List<Object> jsonToObjectList(String json, Object o) {
        return gson.fromJson(new StringReader(json), new TypeToken<ArrayList<Object>>() {
        }.getType());
    }
    public static String universityListToJson(List<Object> objects){
        return gson.toJson(objects);
    }

    public static String objectToJson(Object object) {
        return gson.toJson(object);
    }
}
