package other.link;

import java.util.ArrayList;
import java.util.List;

/**
 * 描 述 : TODO
 *
 * @Author: jihuan6
 * @Date: 2021/1/16 10:50 上午
 */
public class Test2 {

    public static List<String> getStrByPartChar(String str,String parChars){
        if(str == null){
            return null;
        }
        List<String> res = new ArrayList<String>();
        char[] target = str.toCharArray();
        int len = str.length();
        int i=0;
        StringBuffer buffer = new StringBuffer();
        boolean flag=false;

        while(i<len){

            if(parChars.indexOf(String.valueOf(target[i]))>-1){

                if(!flag){
                    res.add(buffer.toString());
                    buffer = new StringBuffer();
                    flag=true;
                }
                i++;
                continue;
            }else{
                buffer.append(target[i]);
                if(flag == true){
                    flag = false;
                }
                i++;
            }

        }

        if(buffer.toString().length()>0){
            res.add(buffer.toString());
        }

        return res;
    }



    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println("starting.......");
        String parChars = "@#$";
//        String targetStr = "ab1@#3422342342342$78";
        String targetStr = "a@@b#17";
        List<String> result = getStrByPartChar(targetStr,parChars);
        for(String str : result){
            System.out.println(str);
        }
    }
}
