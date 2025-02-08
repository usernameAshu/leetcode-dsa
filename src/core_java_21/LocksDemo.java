package core_java_21;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class LocksDemo {

  //Reentrant locks
  Lock lock = new ReentrantLock();
  //ReadWrite locks
  ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

  //using tryLock with time limit
  public void sharedResource() {
    try {
      if (lock.tryLock(2, TimeUnit.SECONDS)) {
        System.out.println(Thread.currentThread() + " acquired lock");
          //simulate some work
        Thread.sleep(1500);
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } finally {
      lock.unlock();
      System.out.println(Thread.currentThread() + " released lock");
    }
  }

  //multiple threads can acquire the read locks
  public String read() {
    try {
      readWriteLock.readLock().lock();
      //simulate some work
      Thread.sleep(1500);
      return "work:"+ Thread.currentThread();

    } catch (InterruptedException e) {
      throw new RuntimeException(e);

    } finally {
      readWriteLock.readLock().unlock();
    }
  }

}
