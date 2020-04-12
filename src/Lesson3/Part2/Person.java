package Lesson3.Part2;

import java.util.Objects;

public class Person {
    PhoneBook phoneBook;
    private String lastName;
    private String phone;
    private String email;


    public Person(PhoneBook phoneBook, String lastName, String phone, String email){
        this.phoneBook = phoneBook;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        addPerson(lastName, this);
    }

    public void addPerson(String lastName, Person person){
        KeyPerson key = new KeyPerson(lastName, person);
        if (phoneBook.put(key, this) != null)
            System.err.printf("Объект c ключом %s перезаписался \n", this.lastName);
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return " тел.: " + phone + ", email: " + email;
    }

    public class KeyPerson {
        String key;
        Person person;

        public KeyPerson(String key, Person person){
            this.key = key;
            this.person = person;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            KeyPerson keyPerson = (KeyPerson) o;
            return Objects.equals(person.phone, keyPerson.person.phone);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        @Override
        public String toString() {
            return key + " ";
        }
    }
}
