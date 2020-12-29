package other.link;

import java.util.Arrays;

public class PukeSz {
    public boolean isContinuous(int [] numbers) {
        if (null == numbers || 0 == numbers.length) {
            return false;
        }

        int count = 0;
        int diff = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (0 == numbers[i]) {
                count ++;
                continue;
            }
            if (numbers[i] != numbers[i+1]) {
                diff += numbers[i+1] - numbers[i] - 1;
            } else {
                return false;
            }
        }

        if (count >= diff) {
            return true;
        }
        return false;
    }

//    bool IsContinuousPoker(char* pokers,unsigned int n)
//    {
//        if (pokers==NULL||n==0)
//            throw std::exception("Invalid input.");
//
//        int *counts=new int[14]();
//
//        char *p=pokers;
//        unsigned int num=0;
//        while (*p!='\0')
//        {
//            if (*p=='J')
//            num=11;
//        else if (*p=='Q')
//            num=12;
//        else if (*p=='K')
//            num=13;
//        else if(*p=='M')
//            num=0;
//        else
//            num=*p-'0';
//
//            counts[num]++;
//            if(num!=0&&counts[num]>1)
//                return false;
//
//            p++;
//        }
//
//        int pre=0;
//        for (int i=1;i<14;i++)
//        {
//            if (counts[i]==1)
//            {
//                int dif=i-pre-1;
//                if (pre!=0&&dif>0)
//                {
//                    counts[0]-=dif;
//                    if (counts[0]<0)
//                        return false;
//                }
//                pre=i;
//            }
//        }
//        return true;
//    }
}
