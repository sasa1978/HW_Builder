import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this(name, surname);
        this.age = OptionalInt.of(age);
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) age = OptionalInt.of(age.getAsInt() + 1);
    }

    @Override
    public String toString() {
        return getName() + ' ' + getSurname() + (hasAge() ? ", Возраст: " + getAge().getAsInt() : "") + (hasAddress() ? ", Адрес: " + getAddress() : "");
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname).setAge(0).setAddress(address);
    }
}