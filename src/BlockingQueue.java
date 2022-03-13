import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/** Blocking Queue
 *  BlockingQueue interface supports flow control by introducing blocking if either BlockingQueue is full or empty.
 *  A thread trying to enqueue an element in a full queue is blocked until some other thread makes space in the queue,
 *  either by dequeing one or more elements or clearing the queue completely.
 *  Similarly, it blocks a thread trying to delete from an empty queue until some other threads insert an item
 *  Java BlockingQueue interface implementations are thread-safe
 *  All methods of BlockingQueue are atomic in nature and use internal locks or other forms of concurrency control.
 *  Implemented using LinkedList structure+ synchronization+ waitNotify
 */
public class BlockingQueue {
    public static void main(String[]args){
       getArrayBlockingQueue();
       getLinkedBlockingQueue();
    }

    /** Array Blocking Queue
     * Stores elements in an array
     * Bounded(has a max size which  cannot change)
     * Producer-Consumer share a single lock
     */
    public static void getArrayBlockingQueue(){
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(2);
        arrayBlockingQueue.add("1");
        arrayBlockingQueue.add("2");
       // arrayBlockingQueue.add("3");
        System.out.println("Elements using Array Blocking Queue: "+arrayBlockingQueue);
    }

    /** Linked Blocking Queue
     * Stores elements in linked nodes
     * Optionally Bounded(can/cannot specify a max size)
     * Two lock queue algorithm
     **/
    public static void getLinkedBlockingQueue(){
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();
        linkedBlockingQueue.add("1");
        linkedBlockingQueue.add("2");
        linkedBlockingQueue.add("3");
        System.out.println("Elements using Linked Blocking Queue: "+linkedBlockingQueue);
    }
}


