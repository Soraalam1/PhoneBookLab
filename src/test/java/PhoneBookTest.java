import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PhoneBookTest {
    @Test
    public void addTest(){
        String name = "Dean";
        String phoneNumber = "302-353-2176";

        HashMap<String, List<String >> test = new HashMap<String, List<String>>();
        ArrayList<String> number = new ArrayList<String>();
        number.add("302-353-2176");
        test.put("Dean", number);

        PhoneBook phoneBook = new PhoneBook(new HashMap<String, List<String>>());

        phoneBook.add(name, phoneNumber);

        Assert.assertEquals(test.get("Dean"), phoneBook.lookup("Dean"));
    }
    @Test
    public void addAllTest(){
        HashMap<String, List<String >> test = new HashMap<String, List<String>>();
        PhoneBook phoneBook = new PhoneBook(new HashMap<String, List<String>>());

        ArrayList<String> numbers = new ArrayList<String>();
        numbers.add("number 1");
        numbers.add("number 2");
        numbers.add("number 3");

        test.put("Dean", numbers);

        phoneBook.addAll("Dean", "number 1","number 2","number 3");

        Assert.assertEquals(test.get("Dean"), phoneBook.lookup("Dean"));
    }
    @Test
    public void removeTest(){
        PhoneBook phoneBook = new PhoneBook(new HashMap<String, List<String>>());
        phoneBook.add("Dean", "number");

        phoneBook.remove("Dean");

        Assert.assertEquals(null, phoneBook.lookup("Dean"));
    }
    @Test
    public void hasEntryTest(){
        PhoneBook phoneBook = new PhoneBook(new HashMap<String, List<String>>());
        phoneBook.add("Dean", "number");

        Assert.assertEquals(true, phoneBook.hasEntry("Dean"));
    }
    @Test
    public void lookupTest(){
        PhoneBook phoneBook = new PhoneBook(new HashMap<String, List<String>>());
        phoneBook.addAll("Dean", "number", "number 2");

        ArrayList<String> expected = new ArrayList();
        expected.add("number");
        expected.add("number 2");

        Assert.assertEquals(expected, phoneBook.lookup("Dean"));
    }
    @Test
    public void reverseLookUpTest(){
        PhoneBook phoneBook = new PhoneBook(new HashMap<String, List<String>>());
        phoneBook.add("Dean", "number");

        Assert.assertEquals("Dean", phoneBook.reverseLookup("number"));
    }
   @Test
   public void getAllContactNames(){
        List<String> testNames = new ArrayList<String>();
        testNames.add("Dean");
        testNames.add("two");
        testNames.add("three");
       Collections.sort(testNames, new NameComparator());

       PhoneBook phoneBook = new PhoneBook(new HashMap<String, List<String>>());
       phoneBook.add("Dean", "number");
       phoneBook.add("two", "diff number");
       phoneBook.add("three", "another number");

       List<String> actual = new ArrayList<String>(phoneBook.getAllContactNames());

       Collections.sort(actual, new NameComparator());

       Assert.assertEquals(testNames, actual);
   }
}
