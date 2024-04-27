public class Main {
   /*
   I dette eksempel har vi set, hvordan Repository-mønsteret kan anvendes
   til at adskille forretningslogik fra dataadgangslogik. Dette giver en
   renere og mere vedligeholdelsesvenlig kodebase
    */


    public static void main(String[] args) {

        PersonRepository repository = new InMemoryPersonRepository();

        repository.add(new Person(1, "Thomas", 28));
        repository.add(new Person(2, "Søren", 24));

        System.out.println("All persons:");
        repository.findAll().forEach(System.out::println);

        System.out.println("\nFinding person with ID 1:");
        System.out.println(repository.findById(1));

        repository.delete(1);

        System.out.println("\nAll persons after deleting:");
        repository.findAll().forEach(System.out::println);
    }
}