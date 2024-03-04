import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToysManager {
    private static final String FILE_PATH = "toys.txt";
    private static final String RANDOM_TOY_FILE_PATH = "random_toy.txt";

    public static void createToy(String name, int balance, float chance) {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            try {
                file.createNewFile();
                writeLineToFile("100001," + name + "," + balance + "," + chance, FILE_PATH);
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        List<String> lines = readLinesFromFile();

        int nextId = getNextId(lines);

        Toys toy = new Toys(String.valueOf(nextId), name, balance, chance);

        String newToyInfo = toy.getId() + "," + toy.getName() + "," + toy.getBalance() + "," + toy.getChance();
        lines.add(newToyInfo);
        writeLinesToFile(lines);
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

    public static void chooseRandomToy() {
        List<Toys> toysList = getAllToys();
        if (toysList.isEmpty()) {
            System.out.println("Список игрушек пуст.");
            return;
        }

        float totalChance = 0;
        for (Toys toy : toysList) {
            totalChance += toy.getChance();
        }

        Random random = new Random();
        float randomValue = random.nextFloat() * totalChance;

        float cumulativeProbability = 0;
        for (Toys toy : toysList) {
            cumulativeProbability += toy.getChance();
            if (randomValue <= cumulativeProbability) {
                toy.setBalance(toy.getBalance() - 1);
                if (toy.getBalance() <= 0) {
                    toysList.remove(toy);
                }

                updateToFile(toysList);
                appendNameToFile(toy.getName());
                return;
            }
        }
    }

    private static void appendNameToFile(String name) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RANDOM_TOY_FILE_PATH, true))) {
            bw.write(name);
            bw.write(",");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            String lastLine = lines.get(lines.size() - 1);
            String[] parts = lastLine.split(",");
            return Integer.parseInt(parts[0]) + 1;
        }
    }

    private static void writeLineToFile(String line, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
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

    private static void updateToFile(List<Toys> toysList) {
        List<String> lines = new ArrayList<>();
        for (Toys toy : toysList) {
            String toyInfo = toy.getId() + "," + toy.getName() + "," + toy.getBalance() + "," + toy.getChance();
            lines.add(toyInfo);
        }
        writeLinesToFile(lines);
    }
}
