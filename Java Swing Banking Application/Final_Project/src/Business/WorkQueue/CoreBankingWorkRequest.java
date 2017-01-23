/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.NewUser.NewUser;
import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Sumeet
 */
public class CoreBankingWorkRequest implements WorkRequest {

    public enum TestResult {

        PASS("Pass"), FAIL("Fail"), UNKNOWN("N/A");
        private String result;

        private TestResult(String result) {
            this.result = result;
        }

        @Override
        public String toString() {
            return this.result;
        }
    }

    public enum TestRequestStatus {

        INITIATED("Initiated"), PROCESSING("Processing"), COMPLETED("Completetd");
        private String status;

        private TestRequestStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return this.status;
        }

    }

    private TestResult testResult;
    private NewCustomerWorkRequest newUserRequest;
    private TestRequestStatus testRequestStatus;
    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private Date requestDate;
    private Date resolveDate;

    public CoreBankingWorkRequest() {
        requestDate = new Date();
    }

    public TestResult getTestResult() {
        return testResult;
    }

    public void setTestResult(TestResult testResult) {
        this.testResult = testResult;
    }

    public NewCustomerWorkRequest getNewUserRequest() {
        return newUserRequest;
    }

    public void setNewUserRequest(NewCustomerWorkRequest newUserRequest) {
        this.newUserRequest = newUserRequest;
    }

    public TestRequestStatus getTestRequestStatus() {
        return testRequestStatus;
    }

    public void setTestRequestStatus(TestRequestStatus testRequestStatus) {
        this.testRequestStatus = testRequestStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

}
