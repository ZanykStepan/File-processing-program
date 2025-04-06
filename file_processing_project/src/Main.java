import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputFiles = new ArrayList<>();
        System.out.println("Введіть імена вхідних файлів (порожній рядок для завершення):");
        while (true) {
            String input = scanner.nextLine();
            if (input.isBlank()) break;
            inputFiles.add(input);
        }
        if (inputFiles.isEmpty()) {
            System.out.println("Файли не вказані. Завершення програми.");
            return;
        }

        System.out.println("Виберіть тип сортування: \n1 - по Sort → Price → Color " +
                "\n2 - по Price → Sort → Color \n3 - по Color → Price → Sort");
        int sortType = scanner.nextInt();
        scanner.close();

        try {
            DataProcessing.processAndWrite(inputFiles, sortType);
            System.out.println("Файли успішно оброблено! Вихідні файли знаходяться у папці outputData.");
        } catch (Exception e) {
            System.err.println("Помилка при обробці: " + e.getMessage());
        }
    }
}

