package ru.zolotuhin.demo;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Starting...");
        Filter fileWay = new Filter();
        ArrayList<String> CommandLine = new ArrayList<>(Arrays.asList(args));
        StartingParameters sp = ArgumentsCheck.CheckArguments(CommandLine);
        String filePath = sp.getFilePath();
        String fileNamePrefix = sp.getFileNamePrefix();
        ArrayList<File> arg = sp.getFileData();
        boolean overwrite = sp.isOverwrite();
        for (File file : arg) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                while(line != null && !line.isEmpty()) {
                    fileWay.ConvertDataFile(line);
                    line = reader.readLine();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            fileWay.FileCreated(filePath, fileNamePrefix, overwrite);
        }
        System.out.println("Done!");
        if (sp.getStatisticsParameters().equals("Brief")) {
            System.out.println("Brief statistics:");
            StatisticsUnit.BriefStatistics(new File(filePath + sp.getFileNamePrefix() + "integers.txt"));
            StatisticsUnit.BriefStatistics(new File(filePath + sp.getFileNamePrefix() + "floats.txt"));
            StatisticsUnit.BriefStatistics(new File(filePath + sp.getFileNamePrefix() + "strings.txt"));
        }
        if (sp.getStatisticsParameters().equals("Complete")) {

            System.out.println("Complete statistics:");
            StatisticsUnit.CompleteStatistics(new File(filePath + sp.getFileNamePrefix() + "integers.txt"));
            StatisticsUnit.CompleteStatistics(new File(filePath + sp.getFileNamePrefix() + "floats.txt"));
            StatisticsUnit.CompleteStatistics(new File(filePath + sp.getFileNamePrefix() + "strings.txt"));
        }
    }
}
