package other.link;

public class maxsum {
    public static int MaxSUM(int[] array){
        //传入int型数组，并得到其长度
        int length=array.length;
        //需要用到的中间量，即数组遍历过程中累加的和
        int curSum=0;
        //这是最大累加和
        int maxSum=0;
        //从前往后遍历数组
        for(int i=0;i<length;i++) {
            //如果当前和<=0，则对当前累加和重新赋值，
            //这种情况是遇到了数组中含有负数和才会减少，可能使curSum值称为负值或者0
            if(curSum<=0) {
                curSum=array[i];
            }else {
                //如果不为0，说明正在累加和
                curSum+=array[i];
            }
            //若每次累加和大于最大和，刷新最大和，反之不刷新
            if(curSum>maxSum) {
                maxSum=curSum;
            }
        }
        //for循环结束返回最大和
        return maxSum;
    }
}
class test3 {
    public static void main(String[] args) {
        int[] array= {11,-12,0,3,-1,2,3,4};
        //maxsum类中MaxSUM方法使用staic修饰，可以用类名直接调用
        int result=maxsum.MaxSUM(array);
        System.out.println(result);
    }

}
