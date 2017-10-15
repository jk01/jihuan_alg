package com.algorithm;

/**
 * Title: Submatrix sum is 0 和为零的子矩阵
 * Description: 该类的功能
 和为零的子矩阵

 给定一个整数矩阵，请找出一个子矩阵，使得其数字之和等于0.输出答案时，请返回左上数字和右下数字的坐标。

 样例
 给定矩阵

 [
 [1 ,5 ,7],
 [3 ,7 ,-8],
 [4 ,-8 ,9],
 ]
 返回 [(1,1), (2,2)]

 挑战
 O(n3) 时间复杂度
 */
public class Solution17 {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        int[][] res = new int[2][2];
        int row = matrix.length;
        if(row ==0){
            return res;
        }
        int col = matrix[0].length;
        if(col ==0){
            return res;
        }
        for(int i = 0;i< row ;i++){
            for(int j = 0;j<col;j++){
                int sum = matrix[i][j];
                res[0][0]=i;
                res[0][1]=j;
                for(int n=i+1;n<row;n++){
                    for(int m=j+1;m<col;m++){
                        sum+=matrix[n][m];
                        if(sum==0){
                            res[1][0] = n;
                            res[1][1] = m;
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }

    /**在编程之美上，看到下面的方法：
     1.先去(0,0)到(i,j)内的子矩阵的部分和，和存放中点(i,j)
     2.根据上面的子矩阵，求解任意两点和为0的子矩阵
     如何求解（0,0）到（i，j）内的子矩阵之和
     (i-1,j-1)	(i-1,j)
     (i,j-1)	(i,j)
     如上图的子矩阵和的矩阵PS
     PS[i-1][j-1] PS[i-1][j] PS[i][j-1]是已经求出的子矩阵的和
     显然我们知道PS[i][j-1] = PS[i-1][j-1] + A[i][j-1]  这里的A是原始要求的矩阵，A[i][j-1]也就是(i,j-1)点的值
     同理：PS[i-1][j] = PS[i-1][j-1] + A[i-1][j]
     很显然：PS[i][j] = PS[i-1][j-1] + A[i-1][j] + A[i][j-1] + A[i][j]
     将上面的含有A矩阵元素的值消掉就得到下面的矩阵：
     PS[i][j] = PS[i][j-1] + PS[i-1][j] - PS[i-1][j-1]
     对于第0行和第0类，我单独处理的
     PS[0][0] = A[0][0]
     第0行：PS[0][j] =PS[0][j-1] + A[0][j]
     第0列：PS[i][0] =PS[i-1][0] + A[i][0]
     非0行非0列按照上面的迭代求解
     在求解任意两点和为0的子矩阵
     我们求的是（i,j）到（m，n）的子矩阵
     当m 或者n其中一个为0的时候单独考虑
     其他情况 m、n都是非0的时候
     要考虑 i、j是否是0的情况
     如下：
     复制代码
     　　　　　　　　　　　　　　int sum = 0;
     if(i==0 && j==0){
     sum = PS[m][n];
     }else if(i==0 && j!=0){
     sum = PS[m][n] - PS[m][j-1];
     }else if(i!=0 && j==0){
     sum = PS[m][n] -PS[i-1][n];
     }else{
     sum = PS[m][n] - PS[i-1][n] - PS[m][j-1] + PS[i-1][j-1];
     }
     复制代码
     这样计算的最终时间复杂度还是O(N2*M2)
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum2(int[][] matrix) {
        // Write your code here
        int[][] res = new int[2][2];
        int row = matrix.length;
        if(row ==0){
            return res;
        }
        int col = matrix[0].length;
        if(col ==0){
            return res;
        }
        // 求解0 0 到i j的部分和
        int PS[][] = new int[row][col];
        PS[0][0] = matrix[0][0];
        for(int i =1;i<row ;i++)
            PS[i][0] =PS[i-1][0] + matrix[i][0];
        for(int j =1;j<col ;j++)
            PS[0][j] =PS[0][j-1] + matrix[0][j];
        for(int i =1;i< row;i++){
            for(int j=1;j<col;j++){
                PS[i][j] = PS[i-1][j] + PS[i][j-1] - PS[i-1][j-1] + matrix[i][j];
            }
        }
        // for(int i =0;i< row;i++){
        //     for(int j=0;j<col;j++){

        //         System.out.print(PS[i][j] +" ");
        //     }
        //     System.out.println();
        // }
        //对第0行和第0列单独判断
        // 寻找i j 到 m n和为0的数组时间复杂度O(n*n*m*m)
        //对第0行和第0列单独判断
        // 第0列
        for(int i =0;i< row ;i++){
            res[0][0] = i;
            res[0][1] = 0;
            for(int j= i+1;j< row;j++){
                if(i==0){
                    if(PS[j][0]==0){
                        res[1][0] = j;
                        res[1][1] = 0;
                        return res;
                    }
                }
                else if(PS[j][0]-PS[i-1][0] ==0){
                    res[1][0] = j;
                    res[1][1] = 0;
                    return res;
                }
            }
        }
        // 第0 行
        for(int i =0;i< col ;i++){
            res[0][0] = 0;
            res[0][1] = i;
            for(int j= i+1;j< col;j++){
                if(i==0){
                    if(PS[0][j]==0){
                        res[1][0] = 0;
                        res[1][1] = j;
                        return res;
                    }
                }
                else if(PS[0][j]-PS[0][i-1] ==0){
                    res[1][0] = 0;
                    res[1][1] = j;
                    return res;
                }
            }
        }
        for(int i =0;i<row ;i++){
            for(int j=0;j<col;j++){
                res[0][0] = i;
                res[0][1] = j;
                for(int m = i+1;m<row; m++){
                    for(int n = j+1;n<col;n++){
                        int sum = 0;
                        if(i==0 && j==0){
                            sum = PS[m][n];
                        }else if(i==0 && j!=0){
                            sum = PS[m][n] - PS[m][j-1];
                        }else if(i!=0 && j==0){
                            sum = PS[m][n] -PS[i-1][n];
                        }else{
                            sum = PS[m][n] - PS[i-1][n] - PS[m][j-1] + PS[i-1][j-1];
                        }
                        if(sum==0){
                            res[1][0] = m;
                            res[1][1] = n;
                            return res;

                        }
                    }
                }
            }
        }
        return res;
    }
}
