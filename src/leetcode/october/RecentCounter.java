package leetcode.october;

import java.util.LinkedList;

public class RecentCounter {
    LinkedList<Integer> slideWindow;

    public RecentCounter() {
        this.slideWindow = new LinkedList<>();
    }

    public int ping(int t) {
        this.slideWindow.addLast(t);
        while (this.slideWindow.getFirst() < t - 3000)
            this.slideWindow.removeFirst();
        return this.slideWindow.size();
    }

    public static void main(String[] args) {
        RecentCounter rc = new RecentCounter();
        System.out.println(rc.ping(1));
        System.out.println(rc.ping(100));
        System.out.println(rc.ping(3001));
        System.out.println(rc.ping(3002));
    }
}
