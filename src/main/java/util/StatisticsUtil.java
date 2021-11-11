package util;

import enums.StudyProfile;
import model.Statistics;
import model.Student;
import model.University;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class StatisticsUtil {

    public static List<Statistics> convertStudAndUnivToStat(List<Student> students, List<University> universities) {
        List<Statistics> statisticsList = new ArrayList<>();

        //
        //критерии:
        //профиль
        //средняя оценка
        //количество студентов
        //список университетов

        //получаем список профилей
        Set<StudyProfile> profiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        profiles.stream().forEach(
                p -> {
                    Statistics statistics = new Statistics();
                    statistics.setMainProfile(p);

                    //количество университетов
                    Set<String> universityIds = universities.stream().filter(u -> u.getMainProfile() == p)
                            .map(University::getId)
                            .collect(Collectors.toSet());
                    statistics.setUniversityQty(universityIds.size());

                    //количество студентов
                    AtomicInteger studentQty = new AtomicInteger();
                    universities.stream().filter(u -> u.getMainProfile() == p).forEach(u -> {
                                studentQty.getAndAdd((int) students.stream()
                                        .filter(s -> s.getUniversityId().equals(u.getId()))
                                        .count());
                            }
                    );
                    statistics.setStudentQty(studentQty.get());
                    //список университетов
                    StringBuffer string = new StringBuffer();
                    universities.stream().filter(u -> u.getMainProfile() == p)
                            .map(University::getFullName)
                            .collect(Collectors.toSet())
                            .forEach(s -> string.append(s + ";"));

                    statistics.setUniversityNames(string.toString());

                    //средний бал
                    OptionalDouble avgScoreOptional = students.stream().filter(s -> universityIds.contains(s.getUniversityId())).mapToDouble(Student::getAvgExamScore).average();
                    AtomicReference<Float> v = new AtomicReference<>((float) 0);
                    avgScoreOptional.ifPresent(value -> {
                        v.set(new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).floatValue());
                    });

                    statistics.setAvgExamScore(v.get());
                    statisticsList.add(statistics);
                }
        );

        return statisticsList;

    }

}
