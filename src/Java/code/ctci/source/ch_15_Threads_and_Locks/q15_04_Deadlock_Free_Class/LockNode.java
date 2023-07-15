package Java.code.ctci.source.ch_15_Threads_and_Locks.q15_04_Deadlock_Free_Class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockNode {
    private final ArrayList<LockNode> children;
    private final int lockId;
    private final int maxLocks;
    private Lock lock;

    public LockNode(int id, int max) {
        lockId = id;
        children = new ArrayList<>();
        maxLocks = max;
    }

    public int getId() {
        return lockId;
    }

    public Lock getLock() {
        if (lock == null) {
            lock = new ReentrantLock();
        }
        return lock;
    }

    public boolean hasCycle(HashMap<Integer, Boolean> touchedNodes) {
        /* Check for a cycle by doing a depth-first-search. */
        VisitState[] visited = new VisitState[maxLocks];
        for (int i = 0; i < maxLocks; i++) {
            visited[i] = VisitState.FRESH;
        }
        return hasCycle(visited, touchedNodes);
    }

    private boolean hasCycle(VisitState[] visited, HashMap<Integer, Boolean> touchedNodes) {
        if (touchedNodes.containsKey(lockId)) {
            touchedNodes.put(lockId, true);
        }
        if (visited[lockId] == VisitState.VISITING) {
            return true;
        } else if (visited[lockId] == VisitState.FRESH) {
            visited[lockId] = VisitState.VISITING;
            for (LockNode n : children) {
                if (n.hasCycle(visited, touchedNodes)) {
                    return true;
                }
            }
            visited[lockId] = VisitState.VISITED;
        }
        return false;
    }

    public void joinTo(LockNode node) {
        /* Join "this" to "node", checking to make sure that it doesn't create a cycle. */
        children.add(node);
    }

    public void remove(LockNode node) {
        children.remove(node);
    }

    public enum VisitState {
        FRESH,
        VISITING,
        VISITED
    }
}
