package other.link;

public class DynAlgorithm {

    public static void main(String[] args) {
        dynFiBonacci(0,1,10);
    }

    public static void dynFiBonacci(int i,int j,int n){
        int k=1;
        System.out.print(i+",");
        while(k++<=n){
            System.out.print(j+",");
            int v=j;
            j= i+j;
            i=v;
        }
    }


}
