package Repository;

/**
 * Created by drad on 11/03/2018.
 */

import Model.Problem;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ProblemFileRepository implements FileRepository<Problem>{
    String fileName;
    BufferedWriter writer;
    BufferedReader reader;

    public ProblemFileRepository(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void add(Problem problem)
    {
        try {
            this.openFile("w");
            writer.write(problem.toString() + "\n");
            this.closeFile("w");
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }

    @Override
    public void remove(Problem problem)
    {
    }

    @Override
    public void update(Problem oldProblem, Problem newProblem)
    {
    }

    @Override
    public List<Problem> getAll()
    {
        List<Problem> allProblems = new ArrayList<Problem>();

        try
        {
            openFile("r");
            String currentLine = null;

            while ((currentLine = reader.readLine()) != null)
            {
                String[] problemLine = currentLine.split(" ");
                Problem problemObject = new Problem(Integer.parseInt(problemLine[0]),
                        Integer.parseInt(problemLine[1]),
                        problemLine[2]);
                allProblems.add(problemObject);
            }
        }
        catch(IOException error)
        {
            System.out.println(error.getMessage());
        }

        return allProblems;
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
