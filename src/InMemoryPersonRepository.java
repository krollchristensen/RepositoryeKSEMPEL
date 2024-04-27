import java.util.ArrayList;
import java.util.List;

public class    InMemoryPersonRepository implements PersonRepository {
    private List<Person> database = new ArrayList<>();

    @Override
    public void add(Person person) {
        database.add(person);
    }

    @Override
    public void delete(int id) {
        // Her bruges en traditionel for-loop og en iterator til at fjerne personer
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getId() == id) {
                database.remove(i);
                // Break efter fjernelse for at undgå ConcurrentModificationException
                // hvis kun én instans med dette ID forventes fjernet
                break;
            }
        }
    }

    @Override
    public Person findById(int id) {
        // Brug af traditionel for-loop til at finde den første person med det givne ID
        for (Person person : database) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null; // Returnerer null, hvis ingen personer med det ID blev fundet
    }

    @Override
    public List<Person> findAll() {
        // Returnerer en ny kopi af databasen for at sikre mod ændringer udefra
        return new ArrayList<>(database);
    }
}
