package model;

import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "studentEntry")
@XmlType(propOrder = {"fullName", "universityId", "avgExamScore"})
public class Student {
    @XmlElement(name = "studentName")
    @SerializedName("full_name")
    String fullName;
    @XmlElement(name = "universityId")
    @SerializedName("university_id")
    String universityId;
    @XmlTransient
    @SerializedName("current_course_number")
    int currentCourseNumber;
    @XmlElement(name = "avgScore")
    @SerializedName("average_examination_score")
    float avgExamScore;

    public Student() {
    }

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    @XmlTransient
    public String getFullName() {
        return fullName;
    }

    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @XmlTransient
    public String getUniversityId() {
        return universityId;
    }

    public Student setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    @XmlTransient
    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public Student setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

    @XmlTransient
    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Student setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    @Override
    public String toString() {
        return "model.Student{" +
                "fName:'" + fullName + '\'' +
                ", univId:'" + universityId + '\'' +
                ", currCrsNum:" + currentCourseNumber +
                ", avgExScr:" + avgExamScore +
                '}';
    }
}
