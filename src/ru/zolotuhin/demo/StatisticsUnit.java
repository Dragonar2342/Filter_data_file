package ru.zolotuhin.demo;

import java.io.*;

public interface StatisticsUnit {
    static int CountFile(File file) throws IOException {
        int count = 0;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.readLine() != null) {
            count++;
        }
        return count;
    }

    static void MinMaxFile(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            if (file.toString().endsWith("integers.txt")) {
                long minValue = Long.MAX_VALUE;
                long maxValue = 0;
                long amount = 0;
                while (line != null) {
                    long value = Long.parseLong(line);
                    if (value < minValue) {
                        minValue = value;
                    }
                    if (value > maxValue) {
                        maxValue = value;
                    }
                    amount+=value;
                    line = reader.readLine();
                }

                System.out.printf("Min: %d\nMax: %d\nAmount: %d\nAverage: %d\n", minValue, maxValue, amount, amount / CountFile(file));
            } else if (file.toString().endsWith("floats.txt")) {
                double minValue = Double.MAX_VALUE;
                double maxValue = 0;
                double amount = 0;
                while (line != null) {
                    double value = Double.parseDouble(line);
                    if (value < minValue) {
                        minValue = value;
                    }
                    if (value > maxValue) {
                        maxValue = value;
                    }
                    amount+=value;
                    line = reader.readLine();
                }
                System.out.printf("Min: %f\nMax: %f\nAmount: %f\nAverage: %f\n", minValue, maxValue, amount, amount / CountFile(file));
            } else if (file.toString().endsWith("strings.txt")) {
                long minValue = Long.MAX_VALUE;
                String minValueString = "";
                long maxValue = 0;
                String maxValueString = "";
                while (line != null) {
                    String value = line;
                    if (value.length() < minValue) {
                        minValue = value.length();
                        minValueString = value;
                    }
                    if (value.length() > maxValue) {
                        maxValue = value.length();
                        maxValueString = value;
                    }
                    line = reader.readLine();
                }
                System.out.println("Min: " + minValueString + " Max: " + maxValueString);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    static void BriefStatistics(File name) throws IOException {
        if (name.toString().endsWith("\\")) System.out.println(name.toString().substring(name.toString().lastIndexOf("\\")));
        else System.out.println(name);

        System.out.println("Количество элементов записанных в файле равняется: " + CountFile(name));
    }

    static void CompleteStatistics(File name) throws IOException {
        BriefStatistics(name);
        MinMaxFile(name);
    }
}
