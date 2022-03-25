import java.lang.System;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonArray 
{
    private Person[] people;
    private int counter;

    public PersonArray ()
    {
        people = new Person[1];
        counter = 0;
    }

    public PersonArray (PersonArray other)
    {
        people = other.people;
        counter = other.counter;
    }
    public void addPerson (Person person)
    {
        boolean b = true;

        if (person == null){
            b = false;
        }
        if (b){
            for (int i = 0; i < people.length; i++){
                if (person.equals(people[i])){
                    b = false;
                }
            }
        }
        if (b){
            if (counter == 0)
            {
                counter++;
                Person[] tmp = new Person[1];
                tmp[0] = person;
                people = tmp;
            }
            else
            {
                Person[] tmp = new Person[++counter];
                
                System.arraycopy (people, 0, tmp, 0, people.length);
                tmp[counter - 1] = person;
                people = tmp;
            }
        }
    }

    public void removePerson(Person o)
    {
        List<Person> list = new ArrayList<>(Arrays.asList(people));
        list.remove(o);
        people = new Person[list.size()];
        list.toArray(people);
    }

@Override
    public String toString ()
    {
        return Arrays.toString(people);
    }
@Override
    public boolean equals (Object o)
    {
        if (o == null)
        {
            return false;
        }
        if (o.getClass() == this.getClass())
        {
            PersonArray tmp = (PersonArray)o;
            if (this == tmp)
            {
                return true;
            }
            return Arrays.equals (people, tmp.people);
        }
        return false;
    }

    public void sortByAge ()
    {
        Arrays.parallelSort(people, (Person o1, Person o2) -> {
            if (o1 == null || o2 ==null)
                return 0;
            else
                return o1.getAge() - o2.getAge();
        });
    }
}
