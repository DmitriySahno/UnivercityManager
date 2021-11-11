import comparators.MyComparator;
import enums.StudentComparators;
import enums.UniversityComparators;
import io.ExcelLoader;
import io.ExcelWriter;
import model.Statistics;
import model.Student;
import model.University;
import util.JsonUtil;
import util.StatisticsUtil;

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

        List<Statistics> statisticsList = StatisticsUtil.convertStudAndUnivToStat(studentsBegin, universitiesBegin);
        ExcelWriter.writeStatistics(statisticsList, "src/main/resources/statisticsInfo.xlsx");

    }



}
