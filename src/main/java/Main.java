import io.ExcelLoader;
import io.ExcelWriter;
import model.Statistics;
import model.Student;
import model.University;
import util.JsonUtil;
import util.StatisticsUtil;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private static final String srcFileName = "src/main/resources/universityInfo.xlsx";
    private static final String statFileName = "src/main/resources/statisticsInfo.xlsx";
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {

        LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("logging.properties"));

        logger.info("Loading students");
        List<Student> studentsBegin = ExcelLoader.readStudents(srcFileName);
        logger.info("Loading universities");
        List<University> universitiesBegin = ExcelLoader.readUniversity(srcFileName);
        logger.info("Loading universities");
        studentsBegin.stream()
                .filter(student -> student.getUniversityId().equals("0002-high"))
                .map(JsonUtil::studentToJson)
                .map(JsonUtil::jsonToStudent)
                .forEach(s -> logger.info("Stream students result: " + s.getFullName()));

        universitiesBegin.stream()
                .filter(university -> university.getYearOfFoundation() >= 1990)
                .map(JsonUtil::universityToJson)
                .map(JsonUtil::jsonToUniversity)
                .forEach(u -> logger.info("Stream universities result: " + u.getFullName()));

        List<Statistics> statisticsList = StatisticsUtil.convertStudAndUnivToStat(studentsBegin, universitiesBegin);
        ExcelWriter.writeStatistics(statisticsList, statFileName);

    }


}
