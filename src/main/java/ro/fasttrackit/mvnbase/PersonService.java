package ro.fasttrackit.mvnbase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonService {
    private final List<Person> person;

    public PersonService(List<Person> person) {
        this.person = new ArrayList<>();
    }
    public List<Person> firstAnaLastSorted(){
        return person.stream()
                .sorted(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName).thenComparing(Person::getAge))
                .collect(Collectors.toList());
    }
    public List<Person> lastNameSorted(){
        return person.stream()
                .sorted(Comparator.comparing(Person::getLastName))
                .collect(Collectors.toList());
    }
     public List<Person> firstNameSorted(){
        return person.stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(Collectors.toList());
     }
    public List<Person> firstLetterA() {
        return person.stream()
                .filter(p -> letterA((Person) person))
                .collect(Collectors.toList());

    }

    public List<Person> age() {
        return person.stream()
                .filter(p -> p.getAge() > 18 && p.getAge() < 60)
                .collect(Collectors.toList());
    }

    public List<String> letterFirst() {
        return person.stream()
                .map(this::firstLetterSAndLastName)
                .collect(Collectors.toList());
    }

    public List<String> capitalized() {
        return person.stream()
                .map(p -> p.getFirstName().toUpperCase())
                .collect(Collectors.toList());
    }

    public List<Person> fromOrdORCj() {
        return person.stream()
                .filter(p -> fromIs((Person) person, "Oradea") || fromIs((Person) person, "Cluj"))
                .collect(Collectors.toList());
    }

    public List<Person> majorAge() {
        return person.stream()
                .filter(p -> p.getAge() > 18)
                .collect(Collectors.toList());
    }

    public List<String> firstNameAndLastName() {
        return person.stream()
                .map(this::firstAndLast)
                .collect(Collectors.toList());
    }

    private boolean letterA(Person person) {
        return person.getFirstName().startsWith("A");
    }

    private String firstLetterSAndLastName(Person person) {
        return person.getFirstName() + " " + person.getLastName().charAt(0) + ".";
    }

    private String firstAndLast(Person person) {
        return person.getFirstName() + " " + person.getLastName();
    }

    private boolean fromIs(Person person, String city) {
        return person.getCity().equalsIgnoreCase(city);
    }


}
