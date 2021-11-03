package model;

import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("full_name")
    String fullName;
    @SerializedName("university_id")
    String universityId;
    @SerializedName("current_course_number")
    int currentCourseNumber;
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

    public String getFullName() {
        return fullName;
    }

    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUniversityId() {
        return universityId;
    }

    public Student setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public Student setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

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
