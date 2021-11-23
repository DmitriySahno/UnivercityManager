import comparators.StudentAvgExamScoreComparator;
import comparators.UniversityFullNameComparator;
import io.ExcelLoader;
import io.ExcelWriter;
import io.JsonWriter;
import model.Statistics;
import model.Student;
import model.University;
import model.CommonStructure;
import util.StatisticsUtil;
import io.XMLWriter;

import java.io.IOException;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class Main {
    private static final String srcFileName = "src/main/resources/universityInfo.xlsx";
    private static final String statFileName = "src/main/resources/statisticsInfo.xlsx";
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final String xmlOutputDir = "src/main/resources/xml";
    private static final String jsonOutputDir = "src/main/resources/jsonReq";

    public static void main(String[] args) throws IOException {

        LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("logging.properties"));

        logger.info("Loading students");
        List<Student> students = ExcelLoader.readStudents(srcFileName);
        logger.info("Loading universities");
        List<University> universities = ExcelLoader.readUniversity(srcFileName);

        logger.info("Sorting tha data");
        students.sort(new StudentAvgExamScoreComparator());
        universities.sort(new UniversityFullNameComparator());

        logger.info("Getting statistics");
        List<Statistics> statisticsList = StatisticsUtil.convertStudAndUnivToStat(students, universities);
        ExcelWriter.writeStatistics(statisticsList, statFileName);

        logger.info("Attempt to saving into xml");
        saveToXml(students, universities, statisticsList);
        logger.info("Attempt to saving into json");
        saveToJson(students, universities, statisticsList);

    }

    private static void saveToXml(List<Student> students, List<University> universities, List<Statistics> statistics){
        logger.info("Starting saving to xml file");
        CommonStructure xmlStructure = new CommonStructure();
        xmlStructure.setStudents(students);
        xmlStructure.setUniversities(universities);
        xmlStructure.setStatistics(statistics);
        XMLWriter.writeToXML(xmlStructure, xmlOutputDir);
        logger.info("Successful of saving to xml file");
    }

    private static void saveToJson(List<Student> students, List<University> universities, List<Statistics> statistics){
        logger.info("Starting saving to json file");
        CommonStructure xmlStructure = new CommonStructure();
        xmlStructure.setStudents(students);
        xmlStructure.setUniversities(universities);
        xmlStructure.setStatistics(statistics);
        JsonWriter.writeToJson(xmlStructure, jsonOutputDir);
        logger.info("Successful of saving to json file");
    }

}
