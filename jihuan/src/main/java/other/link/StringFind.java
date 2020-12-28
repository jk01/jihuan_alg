package other.link;

public class StringFind {

    public static int strStr(String source, String target) {
        // Write your code here
        char[] char1=source.toCharArray();//用于放source字符串的数组
        char[] char2=target.toCharArray();//用于放target字符串的数组
        int i=0;//指向source数组的指针
        int j=0;//指向target数组的指针
        while(i!=char1.length&&j!=char2.length){
            if (char1[i]==char2[j]){//两个指针指向的元素相同，则匹配成功
                i++;
                j++;
            } else{//若这次匹配失败，则进行下一轮
                i=i-j+1;
                j=0;//target数组的指针指向0
            }
        }
        if(j==char2.length){
            return i-j;
        }else{
            return -1;
        }
    }

    public static int strStr2(String source, String target) {
        // Write your code here
        char[] char1=source.toCharArray();//用于放source字符串的数组
        char[] char2=target.toCharArray();//用于放target字符串的数组
        int i=0;//指向source数组的指针
        int j=0;//指向target数组的指针
        while(i!=char1.length&&j!=char2.length){
            i++;
            if (char1[i]==char2[j]){//两个指针指向的元素相同，则匹配成功
                j++;
            } else{//若这次匹配失败，则进行下一轮
                j=0;//target数组的指针指向0
            }
        }
        if(j==char2.length){
            return i-j;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        String source="1ab1111abc33";
        String target ="abc";
        System.out.println(strStr2(source,target));
    }
}
