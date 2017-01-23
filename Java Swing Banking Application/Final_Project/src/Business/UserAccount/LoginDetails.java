/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Sumeet
 */
public class LoginDetails implements Comparable<LoginDetails> {

    private final String loginDate;
    private final long loginTime;
    private long logoutTime;

    private static final DateFormat dateFormatter = new SimpleDateFormat("MM-dd-yyyy");
    private static final DateFormat timeFormatter = new SimpleDateFormat("hh-mm-ss");

    public LoginDetails() {
        final Date date = new Date();
        loginDate = dateFormatter.format(date);
        loginTime = date.getTime();
    }

    public String getLoginDate() {
        return loginDate;
    }

    public long getLoginTime() {
        return loginTime;
    }

    public long getLogoutTime() {
        return logoutTime;
    }

    public void updateLogoutTime() {
        this.logoutTime = System.currentTimeMillis();
    }

    public static String constructLoginDate(Date date) {
        return dateFormatter.format(date);
    }

    public static String getFormattedTime(long timeInMillis) {
        return timeFormatter.format(new Date(timeInMillis));
    }

    @Override
    public boolean equals(Object o) {
        if (null == o) {
            return false;
        }
        if (!(o instanceof LoginDetails)) {
            return false;
        }
        LoginDetails details = (LoginDetails) o;
        return this.loginDate.equals(details.getLoginDate());
    }

    @Override
    public int hashCode() {
        return this.loginDate.hashCode();
    }

    @Override
    public int compareTo(LoginDetails details) {
        return this.loginDate.compareTo(details.getLoginDate());
    }
}
