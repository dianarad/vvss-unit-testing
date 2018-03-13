package Repository;

/**
 * Created by drad on 11/03/2018.
 */

import Model.Grade;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class GradeFileRepository implements FileRepository<Grade>{
    String fileName;
    BufferedWriter writer;
    BufferedReader reader;

    public GradeFileRepository(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void add(Grade grade)
    {
        try {
            this.openFile("w");
            writer.write(grade.toString() + "\n");
            this.closeFile("w");
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }

    @Override
    public void remove(Grade grade)
    {
    }

    @Override
    public void update(Grade oldGrade, Grade newGrade)
    {
    }

    @Override
    public List<Grade> getAll()
    {
        List<Grade> allGrades = new ArrayList<Grade>();

        try
        {
            openFile("r");
            String currentLine = null;

            while ((currentLine = reader.readLine()) != null)
            {
                String[] gradeLine = currentLine.split(" ");
                Grade gradeObject = new Grade(Integer.parseInt(gradeLine[0]),
                        Integer.parseInt(gradeLine[1]),
                        Integer.parseInt(gradeLine[3]),
                        Float.parseFloat(gradeLine[4]));
                allGrades.add(gradeObject);
            }
        }
        catch(IOException error)
        {
            System.out.println(error.getMessage());
        }

        return allGrades;
    }


    @Override
    public void openFile(String mode) throws IOException
    {
        if (mode.toLowerCase().contains("w")) {
            writer = new BufferedWriter(new FileWriter(fileName, true));
        }

        if (mode.toLowerCase().contains("r")){
            reader = new BufferedReader(new FileReader(fileName));
        }
    }

    @Override
    public void closeFile(String mode) throws IOException
    {
        if (mode.toLowerCase().contains("w")) {
            writer.close();
        }

        if (mode.toLowerCase().contains("r")){
            reader.close();
        }
    }
}
