public class Main {

    public static void main(String[] args) {
        String fileName = "src/main/resources/universityInfo.xlsx";
        System.out.println(ExcelLoader.readStudents(fileName));
        System.out.println(ExcelLoader.readUniversity(fileName));
    }

}
