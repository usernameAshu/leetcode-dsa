import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TestMaersk {

  public static void main(String[] args) {
    //2 arrays
    //arr1 = {1,2,3,4}
    //arr2 = {2,4,6,10}
    //arr3 -> o/p -> {1,2,2,3,4,4,6,10}

    //functional inter
    //i1,i2 -> sum
    MathOps sum = (i1, i2 ) -> i1 + i2;
//    System.out.println(sum(10,20));

    //emp object : list
    //id, name, dept, sal
    //dept: {it, hr}
    //it: 30%, hr: 20%
    //calculate increment in sal of emp, group based on dept
    //ans: {HR : {emp1,emp2}, IT: {emp3} }
    new TestMaersk().process();
  }

  void process() {
    Employee e1 = new Employee(1, "Ashu", "IT", 100);
    Employee e2 = new Employee(2, "Sam", "HR", 200);
    Employee e3 = new Employee(3, "Jadu", "IT", 50);
    Employee e4 = new Employee(4, "Madhu", "HR", 400);
    Employee e5 = new Employee(5, "Sadhu", "IT", 150);

    List<Employee> emps = new ArrayList<>();
    emps.add(e1);
    emps.add(e2);
    emps.add(e3);
    emps.add(e4);
    emps.add(e5);

    System.out.println(emps);

    Map<String, Set<Employee>> hr = emps.stream()
        .map(employee -> {
          if (employee.dept.equalsIgnoreCase("HR")) {
            employee.sal = (int) (employee.sal * 1.2);
            return employee;
          } else {
            employee.sal = (int) (employee.sal * 1.3);
            return employee;
          }
        })
        .collect(Collectors.groupingBy(employee -> employee.dept,
            Collectors.mapping(emp -> emp, Collectors.toSet())));

    System.out.println(hr);
  }

  class Employee {
    int id;
    String name;
    String dept;
    int sal;

    public Employee(int id, String name, String dept, int sal) {
      this.id = id;
      this.name = name;
      this.dept = dept;
      this.sal = sal;
    }

    @Override
    public String toString() {
      return "Employee{" +
          "id=" + id +
          ", name='" + name + '\'' +
          ", dept='" + dept + '\'' +
          ", sal=" + sal +
          '}';
    }
  }

  public int[] merge(int[] arr1, int[] arr2) {
    int l1 = arr1.length;
    int l2 = arr2.length;
    int[] result = new int[l1+l2];
    int i= 0,j=0,k=0;

    while(i < l1 && j < l2) {
      if(arr1[i] < arr2[j]) {
        result[k] = arr1[i];
        i++; k++;
      } else if(arr2[i] < arr1[j]) {
        result[k] = arr2[j];
        j++; k++;
      } else {
        //equal
        result[k] = arr2[j];
        i++;
        j++;
        k++;
      }
    }

    //fill remaining elements
    while(i < l1) {
      result[k] = arr1[i];
      i++;k++;
    }

    while(j < l2) {
      result[k] = arr2[j];
      j++;k++;
    }

    return result;
  }

}

interface MathOps {
  int ops(int a, int b);
}