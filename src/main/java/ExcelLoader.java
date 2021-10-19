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

public class ExcelLoader {

    private ExcelLoader() {
    }

    public static Collection<University> readUniversity(String fileName) {

        List<University> list = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(fileName))) {
            Iterator<Row> rowIterator = workbook.getSheet("Университеты").rowIterator();
            if (rowIterator.hasNext()) rowIterator.next(); //skip first row
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

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static Collection<Student> readStudents(String fileName) {
        List<Student> list = new ArrayList<>();

        try (XSSFWorkbook book = new XSSFWorkbook(new FileInputStream(new File(fileName)))) {
            Iterator<Row> rowIterator = book.getSheet("Студенты").rowIterator();
            if (rowIterator.hasNext()) rowIterator.next(); //skip first row
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

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


}
