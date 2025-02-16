package design_patterns;

public class _4_Immutable {

  public static void main(String[] args) {
    // Creating Address using Builder
    Address address = new Address.Builder()
        .setCity("New York")
        .setState("NY")
        .build();

    // Creating Person using Builder
    Person person = new Person.Builder()
        .setName("John")
        .setAge(30)
        .setAddress(address)
        .build();

    System.out.println("Original Person: " + person);

    // Attempting to modify Address
    String city = person.getAddress().getCity();// Returns a copy, original object is unchanged
    city = "Washinton";

    // Confirm immutability
    System.out.println("After modification attempt: " + person);
  }

}

// Immutable Person class (Containing Address as a nested object)
final class Person {
  private final String name;
  private final int age;
  private final Address address; // Nested Object

  // Private constructor to enforce immutability
  private Person(Builder builder) {
    this.name = builder.name;
    this.age = builder.age;
    this.address = builder.address.copy(); // Deep Copy
  }

  // Getters (Return immutable values)
  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  // Return a copy of Address to prevent modification
  public Address getAddress() {
    return address.copy();
  }

  @Override
  public String toString() {
    return "Person{" + "name='" + name + '\'' + ", age=" + age + ", address=" + address + '}';
  }

  // Builder for Person
  public static class Builder {
    private String name;
    private int age;
    private Address address;

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setAge(int age) {
      this.age = age;
      return this;
    }

    public Builder setAddress(Address address) {
      this.address = address;
      return this;
    }

    public Person build() {
      return new Person(this);
    }
  }
}

final class Address {
  private final String city;
  private final String state;

  private Address(Builder builder) {
    city = builder.city;
    state = builder.state;
  }
  // Getters (No setters, ensuring immutability)
  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  // Return a deep copy instead of exposing internal object reference
  public Address copy() {
    return new Address.Builder().setCity(city).setState(state).build();
  }

  public static class Builder {
    private String city;
    private String state;

    public Builder setCity(String city) {
      this.city = city;
      return this;
    }

    public Builder setState(String state) {
      this.state = state;
      return this;
    }

    public Address build() {
      return new Address(this);
    }
  }

}