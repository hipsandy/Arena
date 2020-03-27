package src.com.hipsandy.leet;

import java.util.function.IntConsumer;

class ZeroEvenOdd {
  private int n;
  private int flag = -1;

  public ZeroEvenOdd(int n) {
    this.n = n;
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void zero(IntConsumer printNumber) throws InterruptedException {

    for (int i = 0; i < n; i++) {
      synchronized (this) {
        while (flag != -1) {
          this.wait();
        }
        printNumber.accept(0);
        flag = (i % 2 == 0) ? 0 : 1;
        this.notifyAll();
      }
    }
  }

  public void even(IntConsumer printNumber) throws InterruptedException {

    for (int i = 2; i <= n; i += 2) {
      synchronized (this) {
        while (flag != 1) {
          this.wait();
        }
        printNumber.accept(i);
        flag = -1;
        this.notifyAll();
      }
    }

  }

  public void odd(IntConsumer printNumber) throws InterruptedException {

    for (int i = 1; i <= n; i += 2) {
      synchronized (this) {
        while (flag != 0) {
          this.wait();
        }
        printNumber.accept(i);
        flag = -1;
        this.notifyAll();
      }
    }

  }

  public static void main(String[] args) {
    ZeroEvenOdd obj = new ZeroEvenOdd(6);
    Thread a = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          obj.zero(new IntConsumer() {
            @Override
            public void accept(int value) {
              System.out.print(value);
            }
          });
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    Thread b = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          obj.odd(new IntConsumer() {
            @Override
            public void accept(int value) {
              System.out.print(value);
            }
          });
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    Thread c = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          obj.even(new IntConsumer() {
            @Override
            public void accept(int value) {
              System.out.print(value);
            }
          });
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    a.start();
    b.start();
    c.start();

  }


}