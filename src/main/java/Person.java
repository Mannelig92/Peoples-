import java.util.Objects;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String currentAddress;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return age >= 0;
    }

    public boolean hasAddress() {
        return !(currentAddress == null);
    }

    public void setAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public void happyBirthday() {
        this.age++;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    @Override
    public String toString() {
        return "Имя: " + name +
                ", Фамилия: " + surname +
                ", Возраст: " + age +
                ", Текущее место проживания: " + currentAddress;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, currentAddress);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder(surname, 0, currentAddress);
    }
}
