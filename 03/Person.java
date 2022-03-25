import javax.swing.text.Style;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private int weight;
    private int height;

    private Person(){}

    public final static class Builder
    {
        private String firstName;
        private String lastName;
        private int age;
        private int weight;
        private int height;

        public Builder firstName (String firstName)
        {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName (String lastName)
        {
            this.lastName = lastName;
            return this;
        }

        public Builder age (int age)
        {
            this.age = age;
            return this;
        }

        public Builder weight (int weight)
        {
            this.weight = weight;
            return this;
        }

        public Builder height (int height)
        {
            this.height = height;
            return this;
        }

        public Person build ()
        {
            if (firstName == null || lastName == null)
            {
                System.out.println("Wartosci niezainicjalizowana");
                return null;
            }
            if (firstName.isEmpty() || lastName.isEmpty() || age == 0 || weight == 0 || height == 0)
            {
                System.out.println("Wartosci niezainicjalizowana");
                return null;
            }

            Person person = new Person();
            person.firstName = this.firstName;
            person.lastName = this.lastName;
            person.age = this.age;
            person.weight = this.weight;
            person.height = this.height;
            return person;
        }

    }
@Override
    public String toString ()
    {
        return "Person{ firstName: " + firstName
        + ", lastName: " + lastName
        + ", age = " + age
        + ", weight = " + weight
        + ", height = " + height
        + "}";
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
            Person tmp = (Person)o;
            if (this == tmp)
            {
                return true;
            }
            return firstName.equals(firstName) && lastName.equals(tmp.lastName) && age == tmp.age && weight == tmp.weight && height == tmp.height;
        }
        return false;
    }

    public int getAge()
    {
        return age;
    }
}
