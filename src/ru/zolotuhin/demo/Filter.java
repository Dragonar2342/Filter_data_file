package ru.zolotuhin.demo;

import java.io.*;
import java.util.ArrayList;

public class Filter {
    ArrayList<String> Int_mass = new ArrayList<>();
    ArrayList<String> Float_mass = new ArrayList<>();
    ArrayList<String> String_mass = new ArrayList<>();

    boolean isInteger(String dataFile) {
        boolean Flag = false;
        try {
            Long.parseLong(dataFile);
            Flag = true;
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        } finally {
            return Flag;
        }
    }

    boolean isFloat(String dataFile) {
        boolean Flag = false;
        try {
            Double.parseDouble(dataFile);
            Flag = true;
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        } finally {
            return Flag;
        }
    }

    void FileCreated(String filePath, String fileNamePrefix, boolean overwrite) throws IOException {
        if (!Int_mass.isEmpty()) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath + fileNamePrefix + "integers.txt", overwrite));
            for(String str: Int_mass) {
                writer.write(str + System.lineSeparator());
            }
            writer.close();
        }
        if (!Float_mass.isEmpty()) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath + fileNamePrefix + "floats.txt", overwrite));
            for(String str: Float_mass) {
                writer.write(str + System.lineSeparator());
            }
            writer.close();
        }
        if (!String_mass.isEmpty()) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath + fileNamePrefix + "strings.txt", overwrite));
            for(String str: String_mass) {
                writer.write(str + System.lineSeparator());
            }
            writer.close();
        }
    }

    public void ConvertDataFile (String dataFile) {
        try {
            if (isInteger(dataFile)) {
                Int_mass.add(dataFile);
            } else if (isFloat(dataFile)) {
                Float_mass.add(dataFile);
            } else {
                String_mass.add(dataFile);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
