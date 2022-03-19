package il.ac.hit.project;

public class Cost {
    private String description;
    private double sum;
    private String currency;
    private Subcategory category;

    public String getDescription() {
        return description;
    }

    public double getSum() {
        return sum;
    }

    public String getCurrency() {
        return currency;
    }

    public Subcategory getCategory() {
        return category;
    }

    public Cost(String description, double sum, String currency, Subcategory category) {
        this.description = description;
        this.sum = sum;
        this.currency = currency;
        this.category = new Subcategory(category.getCategory());
    }
}