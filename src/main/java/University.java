public class University {
    String id;
    String shortName;
    String fullName;
    int yearOfFoundation;
    StudyProfile mainProfile;

    public University() {
    }

    public University(String id, String shortName, String fullName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.shortName = shortName;
        this.fullName = fullName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    @Override
    public String toString() {
        return "University{" +
                "id:'" + id + '\'' +
                ", shortName:'" + shortName + '\'' +
                ", fullName:'" + fullName + '\'' +
                ", yearOfFoundation:" + yearOfFoundation +
                ", mainProfile:" + mainProfile +
                '}';
    }



}
