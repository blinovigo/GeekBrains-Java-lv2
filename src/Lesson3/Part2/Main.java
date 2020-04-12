package Lesson3.Part2;

public class Main {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Person person1 = new Person(phoneBook, "Ivanov", "7905" ,"ivanov.i@mail.com");
        Person person2 = new Person(phoneBook, "Ivanov", "7906" ,"ivanov.s@mail.com");
        Person person3 = new Person(phoneBook, "Petrov", "7907","petrov.i@mail.com");
        Person person4 = new Person(phoneBook, "Petrov", "7907","petrov.i@mail.com");
        System.out.println(phoneBook.searchPhoneByLastName("Ivanov"));
        System.out.println(phoneBook.searchEmailByLastName("Ivanov"));
    }
}
