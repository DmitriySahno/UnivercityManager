package io;

import enums.StudyProfile;
import model.Student;
import model.University;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExcelLoader {

    private static final Logger logger = Logger.getLogger(ExcelLoader.class.getName());

    private ExcelLoader() {
    }

    public static List<University> readUniversity(String fileName) {
        logger.info("Starting to read the file with Universities: "+fileName);

        List<University> list = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(fileName))) {
            Iterator<Row> rowIterator = workbook.getSheet("Университеты").rowIterator();
            if (rowIterator.hasNext()) rowIterator.next(); //skip first row
            logger.info("Reading the data of Universities");
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                //filling student object
                University university = new University();
                university.setId(row.getCell(0).getStringCellValue());
                university.setFullName(row.getCell(1).getStringCellValue());
                university.setShortName(row.getCell(2).getStringCellValue());
                university.setYearOfFoundation((int) row.getCell(3).getNumericCellValue());
                university.setMainProfile(StudyProfile.valueOf(row.getCell(4).getStringCellValue()));
                list.add(university);
            }
            logger.info("Successful of reading the file with Universities");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Fail to read the file with Universities: "+fileName, e);
        }

        return list;
    }

    public static List<Student> readStudents(String fileName) {
        logger.info("Starting to read the file with Students: "+fileName);

        List<Student> list = new ArrayList<>();

        try (XSSFWorkbook book = new XSSFWorkbook(new FileInputStream(new File(fileName)))) {
            Iterator<Row> rowIterator = book.getSheet("Студенты").rowIterator();
            if (rowIterator.hasNext()) rowIterator.next(); //skip first row
            logger.info("Reading the data of Students");
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                //filling student object
                Student student = new Student();
                student.setUniversityId(row.getCell(0).getStringCellValue());
                student.setFullName(row.getCell(1).getStringCellValue());
                student.setCurrentCourseNumber((int) row.getCell(2).getNumericCellValue());
                student.setAvgExamScore((float) row.getCell(3).getNumericCellValue());
                list.add(student);
            }
            logger.info("Successful reading the file with Students");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Fail to read the file with Students: "+fileName, e);
        }
        return list;
    }


}
