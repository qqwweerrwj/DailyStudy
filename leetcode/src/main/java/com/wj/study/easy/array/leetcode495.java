package com.wj.study.easy.array;

import javafx.scene.chart.Axis;

public class leetcode495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {

        int maxlen = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            int time = timeSeries[i - 1] + duration;
            if (time < timeSeries[i]) {
                maxlen += duration;
            } else {
                maxlen = timeSeries[i] - timeSeries[i - 1] + maxlen;
            }
        }
        maxlen += duration;
        return maxlen;
    }

    public int findPoisonedDuration1(int[] timeSeries, int duration) {
        int maxlen = 0;
        int time_limit = 0;//恢复为未中毒的持续时间
        for (int i = 0; i < timeSeries.length; i++) {

            if (timeSeries[i] > maxlen) {
                maxlen += duration;
            } else {
                maxlen += timeSeries[i] + duration - time_limit;
            }
            time_limit = timeSeries[i] + duration;
        }
        return maxlen;
    }

}
