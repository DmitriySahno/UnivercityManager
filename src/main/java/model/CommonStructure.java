package model;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "root")
@XmlType(propOrder = {"students", "universities", "statistics", "processedAt"})
public class CommonStructure {

    @XmlElementWrapper(name = "studentsInfo")
    @XmlElement(name = "studentsEntry")
    private List<Student> students;
    @XmlElementWrapper(name = "universitiesInfo")
    @XmlElement(name = "universitiesEntry")
    private List<University> universities;
    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElement(name = "statisticsEntry")
    private List<Statistics> statistics;

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setUniversities(List<University> universities) {
        this.universities = universities;
    }

    public void setStatistics(List<Statistics> statistics) {
        this.statistics = statistics;
    }

    @XmlTransient
    public List<Student> getStudents() {
        return students;
    }

    @XmlTransient
    public List<University> getUniversities() {
        return universities;
    }

    @XmlTransient
    public List<Statistics> getStatistics() {
        return statistics;
    }

    @XmlElement(name = "processedAt")
    public Date getProcessedAt(){
        return new Date();
    }
}
