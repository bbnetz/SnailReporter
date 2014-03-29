package eu.bbnetz.Model;

import java.util.GregorianCalendar;

/**
 * Created with IntelliJ IDEA.
 * User: avalarion
 * Date: 26.03.14
 * Time: 12:13
 * To change this template use File | Settings | File Templates.
 */
public class Entry {

    protected String title;

    protected String status;

    protected GregorianCalendar startDate;

    protected GregorianCalendar completionDate;

    protected int spentedTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }

    public GregorianCalendar getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(GregorianCalendar completionDate) {
        this.completionDate = completionDate;
    }

    public int getSpentedTime() {
        return spentedTime;
    }

    public int getTimedSpentedTime() {
        int minimalWorkTime = Settings.getInstance().getIntValue("timeIntervals");
        double tmp = this.spentedTime;
        tmp /= minimalWorkTime;
        if(tmp == (int) tmp)
            return this.spentedTime;
        return ((int)tmp + 1) * minimalWorkTime;
    }

    public void setSpentedTime(int spentedTime) {
        this.spentedTime = spentedTime;
    }
}
