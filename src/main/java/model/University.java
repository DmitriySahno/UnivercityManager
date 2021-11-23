package model;

import com.google.gson.annotations.SerializedName;
import enums.StudyProfile;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "universityEntry")
@XmlType(propOrder = {"id", "fullName", "mainProfile"})
@XmlAccessorType(XmlAccessType.FIELD)
public class University {
    @XmlElement(name = "universityId")
    @SerializedName("identificator")
    String id;
    @XmlTransient
    @SerializedName("short_name")
    String shortName;
    @XmlElement(name = "universityName")
    @SerializedName("full_name")
    String fullName;
    @XmlTransient
    @SerializedName("foundation_year")
    int yearOfFoundation;
    @XmlElement(name = "universityProfile")
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
