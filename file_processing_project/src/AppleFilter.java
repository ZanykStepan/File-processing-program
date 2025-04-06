import java.util.List;
import java.util.stream.Collectors;

public class AppleFilter {
    public static List<ApplesStructureOfData> filterCheap(List<ApplesStructureOfData> apples) {
        return apples.stream().filter(a -> a.getPrice() <= 0.1).collect(Collectors.toList());
    }

    public static List<ApplesStructureOfData> filterMedium(List<ApplesStructureOfData> apples) {
        return apples.stream().filter(a -> a.getPrice() >= 0.11 && a.getPrice() <= 0.5).collect(Collectors.toList());
    }

    public static List<ApplesStructureOfData> filterExpensive(List<ApplesStructureOfData> apples) {
        return apples.stream().filter(a -> a.getPrice() >= 0.51).collect(Collectors.toList());
    }
}

