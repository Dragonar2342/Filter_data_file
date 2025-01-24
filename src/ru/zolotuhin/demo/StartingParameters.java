package ru.zolotuhin.demo;

import java.io.File;
import java.util.ArrayList;

public class StartingParameters {
    String filePath = "";
    String fileNamePrefix = "";
    String statisticsParameters = "";
    ArrayList<File> fileData =new ArrayList<>();
    boolean overwrite = false;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(File filePath) {
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        this.filePath = filePath.getAbsoluteFile() + "\\";
    }

    public String getFileNamePrefix() {
        return fileNamePrefix;
    }

    public void setFileNamePrefix(String fileName) {
        this.fileNamePrefix = fileName;
    }

    public String getStatisticsParameters() {
        return statisticsParameters;
    }

    public void setStatisticsParameters(String statisticsParameters) {
        this.statisticsParameters = statisticsParameters;
    }

    public ArrayList<File> getFileData() {
        return fileData;
    }

    public void setFileData(File fileData) {
        this.fileData.add(fileData);
    }

    public boolean isOverwrite() {
        return overwrite;
    }

    public void setOverwrite(boolean overwrite) {
        this.overwrite = overwrite;
    }
}
