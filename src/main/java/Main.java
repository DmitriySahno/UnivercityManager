import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        String fileName = "src/main/resources/universityInfo.xlsx";

        Comparator<Student> studentComparator = MyComparator.getComparator(StudentComparators.AVG_EXAM_SCORE);
        Comparator<University> universityComparator = MyComparator.getComparator(UniversityComparators.ID);

        ExcelLoader.readStudents(fileName).stream()
                .sorted(studentComparator)
                .forEach(System.out::println);
        ExcelLoader.readUniversity(fileName).stream()
                .sorted(universityComparator)
                .forEach(System.out::println);

    }

}
