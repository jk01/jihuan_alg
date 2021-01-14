package other.link;

public class StringPailie {
    public static void  permutation(char[] str,int begin,int end) throws Exception{
        if(begin==end-1){
            for(int i=0;i<end;i++){
                System.out.print(str[i]);
            }
            System.out.println();
        }else{
            for(int k=begin;k<end;k++){
                swap(str,k,begin);
                permutation(str,begin+1,end);
                swap(str,k,begin);
            }
        }
    }

    public static void swap(char[] str,int a,int b){
        char temp = str[a];
        str[a]= str[b];
        str[b]= temp;
    }

    public static void main(String[] args) throws Exception {
        String str = "abcd";
        char[] arr = str.toCharArray();
        permutation(arr, 0, arr.length);
    }

}
