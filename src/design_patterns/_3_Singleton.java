package design_patterns;

public class _3_Singleton {

  public static void main(String[] args) {
    Singleton s1 = Singleton.getInstance();
    Singleton s2 = Singleton.getInstance();

    if (s1 == s2) {
      System.out.println("Same objects");
    }

    s1.message();
    s2.message();
  }

}

/**
 * Bill Pugh Singleton creation
 * Thread safe
 * Fast performace as JVM loads the static instance of class at initializaton
 * Lazy loading
 * Simple complexity
 */
class Singleton {

  private Singleton() {
  }

  private static class SingletonHelper {
    private static final Singleton INSTANCE = new Singleton();
  }

  public static Singleton getInstance() {
    return SingletonHelper.INSTANCE;
  }

  public void message() {
    System.out.println("Singleton instance created.");
  }
}

