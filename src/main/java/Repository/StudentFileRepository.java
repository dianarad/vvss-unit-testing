package Repository;

/**
 * Created by drad on 11/03/2018.
 */

import Model.Student;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class StudentFileRepository implements FileRepository<Student>{
    String fileName;
    BufferedWriter writer;
    BufferedReader reader;

    public StudentFileRepository(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void add(Student student)
    {
        try {
            this.openFile("a");
            writer.write(student.toString() + "\n");
            this.closeFile("a");
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }

    private void overwrite(List<Student> newStudents)
    {
        try {
            this.openFile("w");
            for (Integer index = 0; index < newStudents.size(); index++) {
                writer.write(newStudents.get(index).toString() + "\n");
            }
            this.closeFile("w");
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }

    @Override
    public void remove(Student student)
    {
    }

    @Override
    public void update(Student oldStudent, Student newStudent)
    {
        List<Student> allStudents = getAll();
        Integer found = 0;

        for (Integer index = 0; index < allStudents.size(); index++)
        {
            if (oldStudent.equals(allStudents.get(index))) {
                allStudents.get(index).setRegistrationNumber(newStudent.getRegistrationNumber());
                allStudents.get(index).setGroupNumber(newStudent.getGroupNumber());
                allStudents.get(index).setAssignedProblemNumber(newStudent.getAssignedProblemNumber());
                allStudents.get(index).setCurrentAverage(newStudent.getCurrentAverage());
                allStudents.get(index).setFullName(newStudent.getFullName());
            }
        }

        overwrite(allStudents);
    }

    public Student getOne(String registrationNumber)
    {
        try
        {
            openFile("r");
            String currentLine = null;

            while ((currentLine = reader.readLine()) != null)
            {
                String[] studentLine = currentLine.split(" ");
                if (registrationNumber.equals(studentLine[0])) {
                    Student studentObject = new Student(studentLine[0],
                            studentLine[1],
                            Integer.parseInt(studentLine[2]),
                            Float.parseFloat(studentLine[3]));
                    return studentObject;
                }

            }

            return null;
        }
        catch(IOException error)
        {
            System.out.println(error.getMessage());
            return null;
        }
    }

    @Override
    public List<Student> getAll()
    {
        List<Student> allStudents = new ArrayList<Student>();

        try
        {
            openFile("r");
            String currentLine = null;

            while ((currentLine = reader.readLine()) != null)
            {
                String[] studentLine = currentLine.split(" ");
                Student studentObject = new Student(studentLine[0],
                        studentLine[1],
                        Integer.parseInt(studentLine[2]),
                        Float.parseFloat(studentLine[3]));
                allStudents.add(studentObject);
            }
        }
        catch(IOException error)
        {
            System.out.println(error.getMessage());
        }

        return allStudents;
    }


    @Override
    public void openFile(String mode) throws IOException
    {
        if (mode.toLowerCase().contains("a")) {
            writer = new BufferedWriter(new FileWriter(fileName, true));
        }

        if (mode.toLowerCase().contains("w")) {
            writer = new BufferedWriter(new FileWriter(fileName, false));
        }

        if (mode.toLowerCase().contains("r")){
            reader = new BufferedReader(new FileReader(fileName));
        }
    }

    @Override
    public void closeFile(String mode) throws IOException
    {
        if (mode.toLowerCase().contains("w") || mode.toLowerCase().contains("a")) {
            writer.close();
        }

        if (mode.toLowerCase().contains("r")){
            reader.close();
        }
    }
}
