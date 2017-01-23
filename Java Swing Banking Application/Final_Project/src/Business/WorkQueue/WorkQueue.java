/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Sumeet
 */
public class WorkQueue {
    
    private List<WorkRequest> workRequestList = null;
    
    public WorkQueue() {
        workRequestList = new LinkedList<>();
    }

    public List<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
}