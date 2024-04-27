import java.util.List;

public interface PersonRepository {
    void add(Person person);
    void delete(int id);
    Person findById(int id);
    List<Person> findAll();
}
