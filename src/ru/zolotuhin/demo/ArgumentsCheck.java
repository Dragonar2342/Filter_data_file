package ru.zolotuhin.demo;

import java.io.File;
import java.util.ArrayList;

public interface ArgumentsCheck {
    static StartingParameters CheckArguments(ArrayList<String> arg) {
        StartingParameters sp = new StartingParameters();
        for (int i = 0; i < arg.size(); i++) {
            switch (arg.get(i)) {
                case "-o" -> sp.setFilePath(new File(arg.get(i + 1)));
                case "-p" -> sp.setFileNamePrefix(arg.get(i + 1));
                case "-s" -> sp.setStatisticsParameters("Brief");
                case "-f" -> sp.setStatisticsParameters("Complete");
                case "-a" -> sp.setOverwrite(true);
            }
            if (new File(arg.get(i)).isFile()) {
                sp.setFileData(new File(arg.get(i)));
            }
        }
        return sp;
    }
}
