package Lesson3.Part2;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook extends HashMap<Person.KeyPerson,Person> {

    public ArrayList<String> searchPhoneByLastName(String lastName){
        ArrayList<String> phoneList = new ArrayList<>();
        for (HashMap.Entry<Person.KeyPerson, Person> item : this.entrySet()
        ){
            if(item.getKey().key.equals(lastName))
                phoneList.add(item.getValue().getPhone());
        }
        return phoneList;
    }

    public ArrayList<String> searchEmailByLastName(String lastName){
        ArrayList<String> emailList = new ArrayList<>();
        for (HashMap.Entry<Person.KeyPerson, Person> item : this.entrySet()
        ){
            if(item.getKey().key.equals(lastName))
                emailList.add(item.getValue().getEmail());
        }
        return emailList;
    }
}


