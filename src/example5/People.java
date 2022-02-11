// Example 5: People.java
package example5;
import check.Check;

record FullName(String name) {
    FullName {
        System.out.println("Checking FullName " + name);
        Check.valid(name.split(" ").length > 1,
                name + " needs at least first and last names");
    }
}

record BirthDate(String dob) {
    BirthDate {
        System.out.println("TODO: Check BirthDate " + dob);
    }
}

record EmailAddress(String address) {
    EmailAddress {
        System.out.println("TODO: Check EmailAddress " + address);
    }
}

record Person(FullName name, BirthDate dateOfBirth, EmailAddress email) {
    Person {
        System.out.println("TODO: Check Person ");
    }
}

public class People {
    public static void main(String[] args) {
        var person = new Person(
            new FullName("Bruce Eckel"),
            new BirthDate("7/8/1957"),
            new EmailAddress("mindviewinc@gmail.com")
        );
    }
}
