package com.algorithm.tree;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarTwo {
    TreeMap<Integer, Integer> event2count;
    public MyCalendarTwo() {
        this.event2count =   new TreeMap<>();
    }

    public boolean book(int start, int end) {
        // 先假设这个event能被放进去
        event2count.put(start, event2count.getOrDefault(start, 0) + 1);
        event2count.put(end, event2count.getOrDefault(end, 0) - 1);

        int count = 0;
        // 扫描线
        for(Map.Entry<Integer, Integer> entry : event2count.entrySet()){
            count += entry.getValue();

            // 放进去发现不符合要求, 拿出来return false
            if(count >= 3){
                event2count.put(start, event2count.get(start) - 1);
                event2count.put(end, event2count.get(end) + 1);
                return false;
            }
        }

        return true;
    }
}
