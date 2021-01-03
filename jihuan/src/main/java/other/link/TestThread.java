package other.link;

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
    static int i=3;
    StringBuffer buffer = new StringBuffer();
  public void printChar(Character c){
      buffer.append(c);
      if(i-- == 1){
          for(int i=0;i<10;i++){
              System.out.println(buffer.toString());
          }
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
        maculteJac.printChar(c);
    }
}
