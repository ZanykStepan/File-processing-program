import java.io.*;
import java.util.*;

public class DataProcessing {

    public static List<ApplesStructureOfData> readDataFromFiles(List<String> filePaths) throws IOException {
        List<ApplesStructureOfData> apples = new ArrayList<>();
        for (String path : filePaths) {
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("[ ,]");
                    if (parts.length == 4) {
                        int N = Integer.parseInt(parts[0]);
                        String Sort = parts[1];
                        String Color = parts[2];
                        double Price = Double.parseDouble(parts[3]);
                        apples.add(new ApplesStructureOfData(N, Sort, Color, Price));
                    }
                }
            }
        }
        return apples;
    }

    public static void writeDataToFile(String filename, List<ApplesStructureOfData> apples) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            int counter = 1;
            for (ApplesStructureOfData apple : apples) {
                apple.setN(counter++);
                writer.write(apple.toString());
                writer.newLine();
            }
        }
    }

    public static void processAndWrite(List<String> inputFiles, int sortType) throws IOException {
        List<ApplesStructureOfData> allApples = readDataFromFiles(inputFiles);

        List<ApplesStructureOfData> cheap = AppleSorter.sort(AppleFilter.filterCheap(allApples), sortType);
        List<ApplesStructureOfData> medium = AppleSorter.sort(AppleFilter.filterMedium(allApples), sortType);
        List<ApplesStructureOfData> expensive = AppleSorter.sort(AppleFilter.filterExpensive(allApples), sortType);

        writeDataToFile("outputData/apples_no_more_than_0_1.txt", cheap);
        writeDataToFile("outputData/apples_between_0_11_and_0_5.txt", medium);
        writeDataToFile("outputData/apples_more_than_0_51.txt", expensive);
    }
}
