package Model;

/**
 * Created by drad on 11/03/2018.
 */

public class Grade implements BaseEntity {
    Integer studentRegistrationNumber;
    Integer laboratoryNumber;
    Integer problemNumber;
    Float gradeValue;

    public Grade(Integer studentRegistrationNumber, Integer laboratoryNumber, Integer problemNumber, Float gradeValue) {
        this.studentRegistrationNumber = studentRegistrationNumber;
        this.laboratoryNumber = laboratoryNumber;
        this.problemNumber = problemNumber;
        this.gradeValue = gradeValue;
    }

    public Integer getStudentRegistrationNumber() {
        return studentRegistrationNumber;
    }

    public Integer getLaboratoryNumber() {
        return laboratoryNumber;
    }

    public Integer getProblemNumber() {
        return problemNumber;
    }

    public Float getGradeValue() {
        return gradeValue;
    }

    public void setStudentRegistrationNumber(Integer studentRegistrationNumber) {
        this.studentRegistrationNumber = studentRegistrationNumber;
    }

    public void setLaboratoryNumber(Integer laboratoryNumber) {
        this.laboratoryNumber = laboratoryNumber;
    }

    public void setProblemNumber(Integer problemNumber) {
        this.problemNumber = problemNumber;
    }

    public void setGradeValue(Float gradeValue) {
        this.gradeValue = gradeValue;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "studentRegistrationNumber=" + studentRegistrationNumber +
                ", laboratoryNumber=" + laboratoryNumber +
                ", problemNumber=" + problemNumber +
                ", gradeValue=" + gradeValue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grade grade = (Grade) o;

        if (!studentRegistrationNumber.equals(grade.studentRegistrationNumber)) return false;
        if (!laboratoryNumber.equals(grade.laboratoryNumber)) return false;
        return problemNumber.equals(grade.problemNumber);
    }
}
