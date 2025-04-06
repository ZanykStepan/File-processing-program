import java.util.*;
import java.util.stream.Collectors;

public class AppleSorter {
    public static List<ApplesStructureOfData> sort(List<ApplesStructureOfData> apples, int sortType) {
        Comparator<ApplesStructureOfData> comparator;

        switch (sortType) {
            case 1:
                comparator = Comparator.comparing(ApplesStructureOfData::getSort)
                        .thenComparing(ApplesStructureOfData::getPrice)
                        .thenComparing(ApplesStructureOfData::getColor);
                break;
            case 2:
                comparator = Comparator.comparing(ApplesStructureOfData::getPrice)
                        .thenComparing(ApplesStructureOfData::getSort)
                        .thenComparing(ApplesStructureOfData::getColor);
                break;
            case 3:
                comparator = Comparator.comparing(ApplesStructureOfData::getColor)
                        .thenComparing(ApplesStructureOfData::getPrice)
                        .thenComparing(ApplesStructureOfData::getSort);
                break;
            default:
                System.out.println("Увага! Вказано невідомий тип сортування. Використовується тип 1.");
                comparator = Comparator.comparing(ApplesStructureOfData::getSort)
                        .thenComparing(ApplesStructureOfData::getPrice)
                        .thenComparing(ApplesStructureOfData::getColor);
        }
        return apples.stream().sorted(comparator).collect(Collectors.toList());
    }
}

