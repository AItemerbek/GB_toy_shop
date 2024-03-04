import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ToysManager {
    private static final String FILE_PATH = "toys_shop.txt";
    public static void createToy(String name, int balance, float chance) {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            try {
                file.createNewFile();
                writeLineToFile("100001," + name + "," + balance + "," + chance);
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<String> lines = readLinesFromFile();
        int nextId = getNextId(lines);
        Toys toy = new Toys(String.valueOf(nextId), name, balance, chance);
        lines.add(toy.toString());
        writeLinesToFile(lines);
    }

    private static List<String> readLinesFromFile() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static int getNextId(List<String> lines) {
        if (lines.isEmpty()) {
            return 100001;
        } else {
            String lastLine = lines.getLast();
            String[] parts = lastLine.split(",");
            return Integer.parseInt(parts[0]) + 1;
        }
    }

    private static void writeLineToFile(String line) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeLinesToFile(List<String> lines) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Toys> getAllToys() {
        List<Toys> toysList = new ArrayList<>();
        List<String> lines = readLinesFromFile();

        for (String line : lines) {
            String[] parts = line.split(",");
            Toys toy = new Toys(parts[0], parts[1], Integer.parseInt(parts[2]), Float.parseFloat(parts[3]));
            toysList.add(toy);
        }

        return toysList;
    }
}
