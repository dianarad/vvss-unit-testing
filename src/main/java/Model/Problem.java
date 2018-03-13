package Model;

/**
 * Created by drad on 11/03/2018.
 */

public class Problem implements BaseEntity {
    Integer problemNumber;
    Integer laboratoryNumber;
    String assignment;

    public Problem(Integer problemNumber, Integer laboratoryNumber, String assignment) {
        this.problemNumber = problemNumber;
        this.laboratoryNumber = laboratoryNumber;
        this.assignment = assignment;
    }

    public Integer getProblemNumber() {
        return problemNumber;
    }

    public Integer getLaboratoryNumber() {
        return laboratoryNumber;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setProblemNumber(Integer problemNumber) {
        this.problemNumber = problemNumber;
    }

    public void setLaboratoryNumber(Integer laboratoryNumber) {
        this.laboratoryNumber = laboratoryNumber;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "problemNumber=" + problemNumber +
                ", laboratoryNumber=" + laboratoryNumber +
                ", assignment='" + assignment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Problem problem = (Problem) o;

        if (!problemNumber.equals(problem.problemNumber)) return false;
        return laboratoryNumber.equals(problem.laboratoryNumber);
    }
}
