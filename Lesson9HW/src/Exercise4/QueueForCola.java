package Exercise4;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueForCola {
    private Queue<Human> queue;

    public QueueForCola() {
        queue = new LinkedList<>();
    }

    public void addHuman(Human human) {
        queue.offer(human);
    }

    public void getQueueState(int cycleCount) {
        for(int i = 0; i < cycleCount; i++) {
            Human temp = queue.poll();
            addHuman(temp);
            addHuman(temp);
        }
        System.out.println(queue.toString());
    }
}
