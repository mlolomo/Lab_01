/**
 * @author: Mbathio Lo
 */
public class Product {
    private String name;
    private String description;
    private String ID;
    private double cost;

    public Product(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    public Product(String name, String ID, double cost) {
        this(name, "", ID, cost);
    }

    /**
     * Default constructor
     */
    public Product() {
        this("", "", "", 0.0);
    }

    // Getters
    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

    public String getID() {
        return ID;
    }


    public double getCost() {
        return cost;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Converts the Product object to CSV format
     */
    public String toCSV() {
        return ID + ", " + name + ", " + description + ", " + cost;
    }

    /**
     * Converts the Product object to JSON format
     */
    public String toJSON() {
        return "{\n" +
                "  \"ID\": \"" + ID + "\",\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"description\": \"" + description + "\",\n" +
                "  \"cost\": " + cost + "\n" +
                "}";
    }

    /**
     * Converts the Product object to XML format
     */
    public String toXML() {
        return "<Product>\n" +
                "  <ID>" + ID + "</ID>\n" +
                "  <name>" + name + "</name>\n" +
                "  <description>" + description + "</description>\n" +
                "  <cost>" + cost + "</cost>\n" +
                "</Product>";
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Product product = (Product) obj;

        return Double.compare(product.cost, cost) == 0 &&
                ID.equals(product.ID) &&
                name.equals(product.name) &&
                description.equals(product.description);
    }
}