package basic;

public class Demo {
    public static void main(String[] args) {
        Person person = new Person("Bob", true);
        System.out.println(person.getName());
        System.out.println(person.isStudent());
        person.setStudent(false);
        System.out.println(person.isStudent());
    }
}
