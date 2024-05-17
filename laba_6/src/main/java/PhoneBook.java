import java.util.*;

public class PhoneBook {

    private Map<Human, List<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void addPhone(Human person, String phoneNumber) {
        if (phoneBook.containsKey(person)) {
            phoneBook.get(person).add(phoneNumber);
        }
        else {
            List<String> numbers = new ArrayList<>();
            numbers.add(phoneNumber);
            phoneBook.put(person, numbers);
        }
    }

    public void removePhone(Human person, String phoneNumber) {
        List<String> numbers = phoneBook.get(person);
        if (numbers != null) {
            numbers.remove(phoneNumber);
            if (numbers.isEmpty()) {
                phoneBook.remove(person);
            } else {
                phoneBook.put(person, numbers);
            }
        }
    }
    public List<String> getAllPhones(){
        List<String> allPhones = new ArrayList<>();
        for (List<String> lists : phoneBook.values())
        {
            allPhones.addAll(lists);
        }
        return allPhones;
    }

    public List<String> getPhones(Human person) {
        List<String> result = phoneBook.get(person);
        if (result != null) {
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    public Human findPersonByPhoneNumber(String phoneNumber) {
        for (Map.Entry<Human, List<String>> entry : phoneBook.entrySet()) {
            if (entry.getValue().contains(phoneNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public Map<Human, List<String>> findPeopleByLastName(String lastNamePrefix) {
        Map<Human, List<String>> result = new HashMap<>();
        for (Map.Entry<Human, List<String>> entry : phoneBook.entrySet()) {
            if (entry.getKey().getLastName().startsWith(lastNamePrefix)) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }
}