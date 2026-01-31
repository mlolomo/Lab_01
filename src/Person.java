import java.util.Calendar;

/**
 * @author: Mbathio Lo
 */
public class Person {
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;

    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    public Person(String firstName, String lastName, String ID, int YOB) {
        this(firstName, lastName, ID, "", YOB);
    }

    /**
     * Default constructor
     */
    public Person() {
        this("", "", "", "", 2000);
    }

    // Getters

    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * Gets the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the year of birth
     */
    public int getYOB() {
        return YOB;
    }

    // Setters

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the year of birth
     */
    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + fullName();
    }

    public String getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return String.valueOf(currentYear - YOB);
    }

    /**
     * Calculates the age for a specified year
     */
    public String getAge(int year) {
        return String.valueOf(year - YOB);
    }

    /**
     * Converts the Person object to CSV format
     */
    public String toCSV() {
        return ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }

    /**
     * Converts the Person object to JSON format
     */
    public String toJSON() {
        return "{\n" +
                "  \"ID\": \"" + ID + "\",\n" +
                "  \"firstName\": \"" + firstName + "\",\n" +
                "  \"lastName\": \"" + lastName + "\",\n" +
                "  \"title\": \"" + title + "\",\n" +
                "  \"YOB\": " + YOB + "\n" +
                "}";
    }

    /**
     * Converts the Person object to XML format
     */
    public String toXML() {
        return "<Person>\n" +
                "  <ID>" + ID + "</ID>\n" +
                "  <firstName>" + firstName + "</firstName>\n" +
                "  <lastName>" + lastName + "</lastName>\n" +
                "  <title>" + title + "</title>\n" +
                "  <YOB>" + YOB + "</YOB>\n" +
                "</Person>";
    }

    /**
     * Returns a string representation of the Person
     */
    @Override
    public String toString() {
        return "Person{" +
                "ID='" + ID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    /**
     * Compares this person to another object for equality
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Person person = (Person) obj;

        return YOB == person.YOB &&
                ID.equals(person.ID) &&
                firstName.equals(person.firstName) &&
                lastName.equals(person.lastName) &&
                title.equals(person.title);
    }
}