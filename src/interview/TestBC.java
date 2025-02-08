package interview;

public class TestBC {

  public static void main(String[] args) {
    //Emp (id, sal)
    //sort based on salary

    //List<Employee> emps = new ArrayList<>();

    //Collections.sort((e1, e2) -> e1.sal.compareTo(e2.sal));

    //cust, orders
    // cust(cust_id, cust_name)
    // orders(order_id, amt, cust_id)

//    Display cust_name and cust_id for total shopping > 500

//    select b.cust_name, a.cust_id from
//    (select cust_id ,SUM(amt) total_amount from orders group by cust_id) a
//      where a.total_amount > 500 and a.cust_id in (select cust_name from cust where cust_id = a.cust_id) b

  }

}
