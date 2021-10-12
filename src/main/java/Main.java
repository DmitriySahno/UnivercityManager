public class Main {

    public static void main(String[] args) {
        University univNTU = new University("1", "НТУ", "Национальный технический университет", 1977, StudyProfile.CYBERSECURITY);
        Student stdIvanRizhkov = new Student("Иван Рыжков", "1", 1, 4.5f);
        System.out.println(univNTU);
        System.out.println(stdIvanRizhkov);

    }

}
