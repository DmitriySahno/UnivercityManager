package util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Student;
import model.University;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

    private static final Gson gson = new Gson();

    private JsonUtil() {
    }

    public static Student jsonToStudent(String json) {
        return gson.fromJson(new StringReader(json), Student.class);
    }

    public static List<Student> jsonToStudentList(String json) {
        return gson.fromJson(new StringReader(json), new TypeToken<ArrayList<Student>>() {
        }.getType());
    }

    public static University jsonToUniversity(String json) {
        return gson.fromJson(new StringReader(json), University.class);
    }

    public static List<University> jsonToUniversityList(String json) {
        return gson.fromJson(new StringReader(json), new TypeToken<ArrayList<University>>() {
        }.getType());
    }

    public static String studentToJson(Student student) {
        return gson.toJson(student);
    }

    public static String studentListToJson(List<Student> students) {
        return gson.toJson(students);
    }

    public static String universityToJson(University university){
        return gson.toJson(university);
    }

    public static String universityListToJson(List<University> universities){
        return gson.toJson(universities);
    }

}
