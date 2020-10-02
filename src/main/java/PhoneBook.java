import java.util.*;

public class PhoneBook {
  private HashMap<String, List<String>> phonebook;

    public PhoneBook(HashMap<String, List<String>> phonebook) {
        this.phonebook = phonebook;
    }

    public void add(String name, String phoneNumber){
        if(phonebook.containsKey(name)){
            phonebook.get(name).add(phoneNumber);
        }
        else {
            List<String> number = new ArrayList<String>();
            number.add(phoneNumber);
            phonebook.put(name, number);
        }
    }
    public void addAll(String name, String... phoneNumbers){
        phonebook.put(name, Arrays.asList(phoneNumbers));
    }
    public void remove(String name){
        phonebook.remove(name);
    }
    public Boolean hasEntry(String name){
       return phonebook.containsKey(name);
    }
    public List<String> lookup(String name){
        return phonebook.get(name);
    }
    public String reverseLookup(String phoneNumber){
        ArrayList<String> names = new ArrayList<String>();
        names.addAll(phonebook.keySet());
        for (String name: names) {
            if(phonebook.get(name).contains(phoneNumber))
                return name;
        }
        return null;
    }
    public List<String> getAllContactNames(){
        ArrayList<String> names = new ArrayList<String>();
        names.addAll(phonebook.keySet());

        return names;
    }
}
