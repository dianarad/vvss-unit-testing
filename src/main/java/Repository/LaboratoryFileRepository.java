package Repository;

/**
 * Created by drad on 11/03/2018.
 */

import Model.Laboratory;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;

public class LaboratoryFileRepository implements FileRepository<Laboratory>{
    String fileName;
    BufferedWriter writer;
    BufferedReader reader;

    public LaboratoryFileRepository(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void add(Laboratory laboratory)
    {
        try {
            this.openFile("w");
            writer.write(laboratory.toString() + "\n");
            this.closeFile("w");
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }

    @Override
    public void remove(Laboratory laboratory)
    {
    }

    @Override
    public void update(Laboratory oldLaboratory, Laboratory newLaboratory)
    {
    }

    @Override
    public List<Laboratory> getAll()
    {
        List<Laboratory> allLaboratories = new ArrayList<Laboratory>();

        try
        {
            openFile("r");
            String currentLine = null;

            while ((currentLine = reader.readLine()) != null)
            {
                String[] laboratoryLine = currentLine.split(" ");
                Laboratory laboratoryObject = new Laboratory(Integer.parseInt(laboratoryLine[0]),
                        new SimpleDateFormat("dd/MM/yyyy").parse(laboratoryLine[1]),
                        Integer.parseInt(laboratoryLine[2]));
                allLaboratories.add(laboratoryObject);
            }
        }
        catch(IOException error)
        {
            System.out.println(error.getMessage());
        }
        catch(ParseException error)
        {
            System.out.println(error.getMessage());
        }

        return allLaboratories;
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
