package model;

import com.google.gson.annotations.SerializedName;
import enums.StudyProfile;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Objects;

@XmlRootElement(name = "statisticsEntry")
public class Statistics {
    @XmlElement(name = "universityProfile")
    StudyProfile mainProfile;
    @XmlElement(name = "avgScore")
    float avgExamScore;
    @XmlTransient
    int studentQty;
    @XmlTransient
    int universityQty;
    @XmlTransient
    String universityNames;

    public Statistics() {
    }

    public Statistics(StudyProfile mainProfile, float avgExamScore, int studentQty, int universityQty, String universityNames) {
        this.mainProfile = mainProfile;
        this.avgExamScore = avgExamScore;
        this.studentQty = studentQty;
        this.universityQty = universityQty;
        this.universityNames = universityNames;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public void setStudentQty(int studentQty) {
        this.studentQty = studentQty;
    }

    public void setUniversityQty(int universityQty) {
        this.universityQty = universityQty;
    }

    public void setUniversityNames(String universityNames) {
        this.universityNames = universityNames;
    }

    @XmlTransient
    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    @XmlTransient
    public float getAvgExamScore() {
        return avgExamScore;
    }

    @XmlTransient
    public int getStudentQty() {
        return studentQty;
    }

    @XmlTransient
    public int getUniversityQty() {
        return universityQty;
    }

    @XmlTransient
    public String getUniversityNames() {
        return universityNames;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistics that = (Statistics) o;
        return Float.compare(that.avgExamScore, avgExamScore) == 0 &&
                studentQty == that.studentQty &&
                universityQty == that.universityQty &&
                mainProfile == that.mainProfile &&
                Objects.equals(universityNames, that.universityNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mainProfile, avgExamScore, studentQty, universityQty, universityNames);
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "mainProfile=" + mainProfile +
                ", avgExamScore=" + avgExamScore +
                ", studentQty=" + studentQty +
                ", universityQty=" + universityQty +
                ", universityNames='" + universityNames + '\'' +
                '}';
    }
}
