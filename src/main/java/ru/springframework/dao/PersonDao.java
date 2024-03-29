package ru.springframework.dao;

import org.springframework.stereotype.Component;
import ru.springframework.models.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDao {
    private static int PEOPLE_COUNT;
    private List<Person> people;
    {
        people = new ArrayList<>();
        people.add( new Person(++PEOPLE_COUNT, "Tom"));
        people.add( new Person(++PEOPLE_COUNT, "Jerry"));
        people.add( new Person(++PEOPLE_COUNT, "John"));
        people.add( new Person(++PEOPLE_COUNT, "Katy"));
    }
    public List<Person> index(){
        return people;
    }
    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
        System.out.println(people);
    }
}
