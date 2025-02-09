import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TestAM {

  public static void main(String[] args) {

    //square root of na integer
    //64 -> 8
    //(1...true) -> n*n == input
    //O(sqrt(i/p))

    //i/p: 18
    //o/p: 13 + 5, 11 + 7
    //i/p: 11  , {2 - 10}

    // first build an array of prime numebers {2,.._18} =>
    //twoSum concept
    generate(10);
  }
  //i/p: 5
  //o/p: primes: 2, 3
  //compMap: (3, 0)

  //18
  //primes: 2,       3,       5,    7,      11,    13,17
  //compMap: (16,0), (15,1), (13,2) (11,3)  (7,4)  (),
  //pairs: [ {11,7},  {13, 5} ]
  public static void generate(int input) {
    //edge cases
    if (input <= 2) {
      return;
    }

    List<Integer> primes = new ArrayList<>();
    primes.add(2);
    Map<Integer, Integer> compMap = new HashMap<>();
    int compIdx = 0;
    compMap.put(input - 2, compIdx++);

    for (int i = 3; i < input; i++) {
      //check for prime
      //div by 1 and itself
      boolean isPrime = true;
      for (int j = 2; j < i; j++) {
        if (i % j == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime) {
        primes.add(i);
        if (compMap.containsKey(i)) {
          int index = compMap.get(i);
          int pair2 = primes.get(index);
          System.out.println("Pair: " + i + "," + pair2);
        } else {
          compMap.put(input - i, compIdx++);
        }
      }


    }

    primes.forEach(e -> System.out.print(e + " "));

  }


}

class Employee {

  private static Employee emp;
  String name;

  private Employee(String name) {
    this.name = name;
  }

  public static Employee createBean(String name) {
    if (emp == null) {
      return new Employee(name);
    }
    return emp;
  }


}
class Client {

  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    Map<String, Integer> synchronizedMap = Collections.synchronizedMap(map);
    //lock will be applied on entire hash table
    //concurrent hasmap
    Map<String, Integer> Cmap = new ConcurrentHashMap<>();
    //locks on buckets
    //multiple threads can access individual buckets
  }
}

//class HashMapOps {
//  Map<String, Integer> Cmap = new ConcurrentHashMap<>();
//  public HashMapOps(Map<>)
//}

