import comparators.MyComparator;
import enums.StudentComparators;
import enums.UniversityComparators;
import io.ExcelLoader;
import model.Student;
import model.University;
import util.JsonUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String fileName = "src/main/resources/universityInfo.xlsx";
//        Comparator<Student> studentComparator = MyComparator.getComparator(StudentComparators.AVG_EXAM_SCORE);
//        Comparator<University> universityComparator = MyComparator.getComparator(UniversityComparators.ID);

        List<Student> studentsBegin = ExcelLoader.readStudents(fileName);
        List<University> universitiesBegin = ExcelLoader.readUniversity(fileName);

        studentsBegin.stream()
                .filter(student -> student.getUniversityId().equals("0002-high"))
                .map(JsonUtil::studentToJson)
                .peek(System.out::println)
                .map(JsonUtil::jsonToStudent)
                .forEach(System.out::println);

        universitiesBegin.stream()
                .filter(university -> university.getYearOfFoundation()>=1990)
                .map(JsonUtil::universityToJson)
                .peek(System.out::println)
                .map(JsonUtil::jsonToUniversity)
                .forEach(System.out::println);


    }



}
