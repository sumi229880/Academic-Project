/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Sumeet
 */
public class GenericWorkQueue<T> {

    private Queue<T> queue = new LinkedList<>();

    public void addRequest(T request) {
        queue.add(request);
    }

    public T peekRequest() {
        return queue.peek();
    }

    public T pollRequest() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
