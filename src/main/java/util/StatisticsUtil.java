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
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StatisticsUtil {

    private static final Logger logger = Logger.getLogger(StatisticsUtil.class.getName());

    public static List<Statistics> convertStudAndUnivToStat(List<Student> students, List<University> universities) {
        logger.info("Starting conversion Students and Universities to Statistics");

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

                    logger.info("Getting amount of Universities per Profile: " +p.name());
                    //количество университетов
                    Set<String> universityIds = universities.stream().filter(u -> u.getMainProfile() == p)
                            .map(University::getId)
                            .collect(Collectors.toSet());
                    statistics.setUniversityQty(universityIds.size());

                    logger.info("Getting amount of Students per Profile: " +p.name());
                    //количество студентов
                    AtomicInteger studentQty = new AtomicInteger();
                    universities.stream().filter(u -> u.getMainProfile() == p).forEach(u -> {
                                studentQty.getAndAdd((int) students.stream()
                                        .filter(s -> s.getUniversityId().equals(u.getId()))
                                        .count());
                            }
                    );
                    statistics.setStudentQty(studentQty.get());

                    logger.info("Getting a list of Universities per Profile: " +p.name());
                    //список университетов
                    StringBuffer string = new StringBuffer();
                    universities.stream().filter(u -> u.getMainProfile() == p)
                            .map(University::getFullName)
                            .collect(Collectors.toSet())
                            .forEach(s -> string.append(s + ";"));

                    statistics.setUniversityNames(string.toString());

                    logger.info("Getting average examination score per Profile: " +p.name());
                    //средний бал
                    OptionalDouble avgScoreOptional = students.stream().filter(s -> universityIds.contains(s.getUniversityId())).mapToDouble(Student::getAvgExamScore).average();
                    AtomicReference<Float> v = new AtomicReference<>((float) 0);
                    avgScoreOptional.ifPresent(value -> {
                        v.set(new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).floatValue());
                    });

                    statistics.setAvgExamScore(v.get());
                    statisticsList.add(statistics);
                    logger.info("Finish conversion to statistics per Profile: " +p.name());
                }
        );

        logger.info("Successful of conversion students and universities to statistics");
        return statisticsList;

    }

}
