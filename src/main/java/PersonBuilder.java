public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String currentAddress;

    public PersonBuilder(String surname, int age, String currentAddress) {
        this.surname = surname;
        this.age = age;
        this.currentAddress = currentAddress;
    }

    public PersonBuilder() {
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Возраст некорректен");
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String currentAddress) {
        this.currentAddress = currentAddress;
        return this;
    }

    public Person build() {
        if (createPerson()) {
            Person person = age == 0 ?
                    new Person(name, surname) :
                    new Person(name, surname, age);
            person.setAddress(currentAddress);
            return person;
        } else {
            throw new IllegalArgumentException("Невозможно создать объект Person");
        }
    }

    private boolean createPerson() {
        if (name == null) throw new IllegalStateException("Имя не указано");
        if (surname == null) throw new IllegalStateException("Фамилия не указана");
        return true;
    }
}
