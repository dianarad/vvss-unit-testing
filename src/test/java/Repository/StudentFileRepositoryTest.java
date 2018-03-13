package Repository;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import Model.Student;
import Repository.StudentFileRepository;

public class StudentFileRepositoryTest extends TestCase
{
    StudentFileRepository studentFileRepo;
    Student validStudent;
    Student invalidStudent;

    public StudentFileRepositoryTest (String testName)
    {
        super(testName);

        studentFileRepo = new StudentFileRepository("students.txt");
        validStudent = new Student("valid1", "Ion Ion", 765, new Float(0));
        invalidStudent = null;
    }

    public static Test suite()
    {
        return new TestSuite(StudentFileRepositoryTest.class);
    }

    public void simpleTest()
    {
        assertTrue(true);
    }

    public void addStudentTest()
    {
        assertTrue(studentFileRepo.add(validStudent));
        assertFalse(studentFileRepo.add(invalidStudent));
    }
}
