public class MyComparator {

    public static StudentComparator getComparator(StudentComparators comparator) {
        switch (comparator) {
            case FULL_NAME:
                return new StudentFullNameComparator();
            case UNIVERSITY_ID:
                return new StudentUniversityIdComparator();
            case CURRENT_COURSE:
                return new StudentCurrentCourseNumberComparator();
            case AVG_EXAM_SCORE:
                return new StudentAvgExamScoreComparator();
        }
        return new StudentFullNameComparator();
    }

    public static UniversityComparator getComparator(UniversityComparators comparator) {
        switch (comparator){
            case FULL_NAME:
                return new UniversityFullNameComparator();
            case ID:
                return new UniversityIdComparator();
            case SHORT_NAME:
                return new UniversityShortNameComparator();
            case MAIN_PROFILE:
                return new UniversityMainProfileComparator();
            case YEAR_OF_FOUNDATION:
                return new UniversityYearOfFoundationComparator();
        }
        return new UniversityFullNameComparator();
    }

}
