package other.link;

import java.util.concurrent.CountDownLatch;

public class TestThread {
    public  static void main(String  []args  ){
        MaculteJac   maj=new MaculteJac();
        Thread a=new Thread(new ThreadABC(maj,'a'));
        Thread b=new Thread(new ThreadABC(maj,'b'));
        Thread c=new Thread(new ThreadABC(maj,'c'));
        a.start();
        b.start();
        c.start();

    }
}

class MaculteJac{
  private static CountDownLatch count = new CountDownLatch(3);
  private StringBuffer buffer = new StringBuffer();
  public void addChar(Character c){
      buffer.append(c);
      count.countDown();
  }

  public void takeChar(){
      try {
          count.await();
          for (int i = 0; i < 10; i++) {
              System.out.println(buffer.toString());
          }
      }catch (Exception e){
          e.printStackTrace();
      }
  }
}
class ThreadABC implements Runnable{
    private MaculteJac maculteJac;
    private Character c;
    public ThreadABC(MaculteJac maculteJac,Character c){
        this.maculteJac = maculteJac;
        this.c = c;
    }

    @Override
    public void run() {
        maculteJac.addChar(c);
        maculteJac.takeChar();
    }
}
