package Model;

/**
 * Created by drad on 11/03/2018.
 */

public class Student implements BaseEntity{
    String registrationNumber;
    String fullName;
    Integer groupNumber;
    Float currentAverage;
    Integer assignedProblemNumber;

    public Student(String registrationNumber, String fullName, Integer groupNumber, Float currentAverage) {
        this.registrationNumber = registrationNumber;
        this.fullName = fullName;
        this.groupNumber = groupNumber;
        this.currentAverage = currentAverage;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getGroupNumber() {
        return groupNumber;
    }

    public Float getCurrentAverage() {
        return currentAverage;
    }

    public Integer getAssignedProblemNumber() {
        return assignedProblemNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    public void setCurrentAverage(Float currentAverage) {
        this.currentAverage = currentAverage;
    }

    public void setAssignedProblemNumber(Integer assignedProblemNumber) {
        this.assignedProblemNumber = assignedProblemNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                ", groupNumber=" + groupNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return registrationNumber.equals(student.registrationNumber);
    }
}
