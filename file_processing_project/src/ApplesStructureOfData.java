public class ApplesStructureOfData {
    int N;
    String Sort;
    String Color;
    double Price;

        public ApplesStructureOfData(int N, String Sort, String Color, double Price) {
        this.N = N;
        this.Sort = Sort;
        this.Color = Color;
        this.Price = Price;
    }

    public String toString() {
        return N + " " + Sort + " " + Color + " " + Price;
    }

    public int getN() {
        return N;
    }

    public String getSort() {
        return Sort;
    }

    public String getColor() {
        return Color;
    }

    public double getPrice() {
        return Price;
    }

    public void setN(int n) {
        this.N = n;
    }

}
