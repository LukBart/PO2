public class Main {
    public static void main(String[] args) {
        Person adam = new Person.Builder()
                .firstName("Adam")
                .lastName("Abacki")
                .age(32)
                .weight(78)
                .height(186)
                .build();

        Person karol = new Person.Builder()
                .firstName("Karol")
                .lastName("Babacki")
                .age(21)
                .weight(74)
                .height(183)
                .build();

        Person piotr = new Person.Builder()
                .firstName("Piotr")
                .lastName("Cabacki")
                .age(25)
                .weight(92)
                .height(191)
                .build();

        Person none = new Person.Builder()
                .build();

        // Person person = new Person(); // should not work
        // Person person = new Person("Adam", "Kowalski", 20, 76, 176); // should not work

        System.out.println(karol);
        System.out.println();

        PersonArray personArray = new PersonArray();
        personArray.addPerson(adam);
        personArray.addPerson(karol);
        personArray.addPerson(piotr);
        personArray.addPerson(piotr); // will not add same person
        personArray.addPerson(none);
        System.out.println(personArray);
        personArray.removePerson(karol);
        System.out.println(personArray);
        System.out.println();

        PersonArray personArray2 = new PersonArray(personArray);
        PersonArray personArray3 = new PersonArray();
        personArray3.addPerson(adam);
        personArray3.addPerson(karol);
        System.out.println("personList.equals(personList2): " + personArray.equals(personArray2));
        System.out.println("personList.equals(personList3): " + personArray.equals(personArray3));
        System.out.println();

        personArray.addPerson(karol);
        personArray.sortByAge();
        System.out.println(personArray);
    }
}
