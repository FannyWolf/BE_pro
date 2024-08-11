package code;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        List<People> people = new ArrayList<>();

        people.add(new People("Masha", 15));
        people.add(new People("Gosha", 55));
        people.add(new People("Vera", 45));
        people.add(new People("Tanya", 35));
        people.add(new People("Georg", 65));
        people.add(new People("Trofim", 75));

        List<People> sortedPeopleList = people.stream()
                .filter(person -> person.getAge() > 54)
                .toList();

        System.out.println("People, who older than 55:");
        sortedPeopleList.forEach(System.out::println);

    }
}
