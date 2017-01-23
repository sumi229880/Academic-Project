/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.NewUser.NewUser;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Sumeet
 */
public class NewCustomerWorkRequest implements WorkRequest {

    public enum Result {
        PASS("Pass"), FAIL("Fail"), UNKNOWN("N/A");
        private String result;

        private Result(String result) {
            this.result = result;
        }

        @Override
        public String toString() {
            return this.result;
        }

    }

    public enum NewCustomerRequestStatus {

        NEW_REQUEST("New"), PENDING("Pending"), COMPLETED("Completed"), ESCALATED("Escalated");
        private String status;

        private NewCustomerRequestStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return this.status;
        }

    }
    private final Date requestDate;
    private final String requestId;
    private NewCustomerRequestStatus status = null;
    private final NewUser newUserInfo;
    private String assignedTo;
    private Result result;

    public static final String UNASSIGNED = "N/A";

    public NewCustomerWorkRequest(NewUser newUser) {
        this.newUserInfo = newUser;
        this.requestDate = new Date();
        this.requestId = "NewReq" + System.currentTimeMillis();
        this.status = NewCustomerRequestStatus.NEW_REQUEST;
        this.assignedTo = UNASSIGNED;
        this.result = Result.UNKNOWN;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public String getRequestId() {
        return requestId;
    }

    public NewCustomerRequestStatus getStatus() {
        return status;
    }

    public NewUser getNewUserInfo() {
        return newUserInfo;
    }

    public void setStatus(NewCustomerRequestStatus status) {
        this.status = status;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
