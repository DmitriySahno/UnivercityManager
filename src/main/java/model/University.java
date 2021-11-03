package model;

import com.google.gson.annotations.SerializedName;
import enums.StudyProfile;

public class University {
    @SerializedName("identificator")
    String id;
    @SerializedName("short_name")
    String shortName;
    @SerializedName("full_name")
    String fullName;
    @SerializedName("foundation_year")
    int yearOfFoundation;
    @SerializedName("profile")
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

    public University setId(String id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    @Override
    public String toString() {
        return "model.University{" +
                "id:'" + id + '\'' +
                ", shName:'" + shortName + '\'' +
                ", fName:'" + fullName + '\'' +
                ", yearOfFound:" + yearOfFoundation +
                ", mainProf:" + mainProfile +
                '}';
    }



}
