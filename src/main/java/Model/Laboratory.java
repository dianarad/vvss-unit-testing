package Model;

import java.util.Date;

/**
 * Created by drad on 11/03/2018.
 */

public class Laboratory implements BaseEntity{
    Integer laboratoryNumber;
    Date laboratoryDate;
    Integer problemsCount;

    public Laboratory(Integer laboratoryNumber, Date laboratoryDate, Integer problemsCount) {
        this.laboratoryNumber = laboratoryNumber;
        this.laboratoryDate = laboratoryDate;
        this.problemsCount = problemsCount;
    }

    public Integer getLaboratoryNumber() {
        return laboratoryNumber;
    }

    public Date getLaboratoryDate() {
        return laboratoryDate;
    }

    public Integer getProblemsCount() {
        return problemsCount;
    }

    public void setLaboratoryNumber(Integer laboratoryNumber) {
        this.laboratoryNumber = laboratoryNumber;
    }

    public void setLaboratoryDate(Date laboratoryDate) {
        this.laboratoryDate = laboratoryDate;
    }

    public void setProblemsCount(Integer problemsCount) {
        this.problemsCount = problemsCount;
    }

    @Override
    public String toString() {
        return "Laboratory{" +
                "laboratoryNumber=" + laboratoryNumber +
                ", laboratoryDate=" + laboratoryDate +
                ", problemsCount=" + problemsCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Laboratory that = (Laboratory) o;

        return laboratoryNumber.equals(that.laboratoryNumber);
    }
}
