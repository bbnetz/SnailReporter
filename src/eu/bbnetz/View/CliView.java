package eu.bbnetz.View;

import eu.bbnetz.Model.Customer;
import eu.bbnetz.Model.Entry;
import eu.bbnetz.Model.Settings;
import eu.bbnetz.ViewHelper.FormatDate;
import eu.bbnetz.ViewHelper.FormatMoney;
import eu.bbnetz.ViewHelper.FormatTime;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: avalarion
 * Date: 26.03.14
 * Time: 14:44
 * To change this template use File | Settings | File Templates.
 */
public class CliView {

    protected static int workingTime = 0;
    protected static int matchedWorkingTime = 0;

    public static String render(ArrayList<Customer> customers) {
        String returnString = "";
        for(Customer customer: customers) {
            returnString += showCustomer(customer);
        }
        returnString += showFooter();
        return returnString;
    }

    protected static String showCustomer(Customer customer) {
        String headString = "";
        int customerWorkingTime = 0;
        int customerMatchedWorkingTime = 0;
        headString += String.format(customer.getTitle());
        headString += "\n";
        headString += showTitleLine();
        headString += String.format("%120s", "=").replace(' ', '=');
        headString += "\n";
        String entriesString = "";
        for (Entry entry:customer.getEntries()) {
            if(Settings.getInstance().getBoolValue("displayOnlyCompleted") && !entry.getStatus().equals("Completed"))
                continue;
            customerWorkingTime += entry.getSpentedTime();
            customerMatchedWorkingTime += entry.getTimedSpentedTime();
            entriesString += String.format("%-40s", entry.getTitle()).substring(0, 39);
            if(Settings.getInstance().getBoolValue("showStatus"))
                entriesString += String.format("%12s", entry.getStatus());
            if(Settings.getInstance().getBoolValue("displayOnlyCompleted"))
                entriesString += String.format("%14s", FormatDate.formatGregorianCalendar(entry.getStartDate()));
            if(Settings.getInstance().getBoolValue("displayOnlyCompleted"))
                entriesString += String.format("%14s", FormatDate.formatGregorianCalendar(entry.getCompletionDate()));
            if(Settings.getInstance().getBoolValue("showNormalTime"))
                entriesString += String.format("%10s", FormatTime.formatWorkingTime(entry.getSpentedTime()));
            if(Settings.getInstance().getBoolValue("showWorkedTime"))
                entriesString += String.format("%10s", FormatTime.formatWorkingTime(entry.getTimedSpentedTime()));
            if(Settings.getInstance().getBoolValue("moneyShow")) {
                if(Settings.getInstance().getBoolValue("showNormalTime"))
                    entriesString += String.format("%10s", FormatMoney.formatMoney(entry.getSpentedTime()));
                if(Settings.getInstance().getBoolValue("showWorkedTime"))
                    entriesString += String.format("%10s", FormatMoney.formatMoney((entry.getTimedSpentedTime())));
            }
            entriesString += "\n";
        }
        String footerString = "";
        footerString += String.format("%120s", "-").replace(' ', '-');
        footerString += "\n";
        if(Settings.getInstance().getBoolValue("showNormalTime")) {
            footerString += String.format("%110s", FormatTime.formatWorkingTime(customerWorkingTime) + " Working Time");
            if(Settings.getInstance().getBoolValue("moneyShow"))
                footerString += String.format("%10s", FormatMoney.formatMoney(customerWorkingTime));
            footerString += "\n";

        }
        if(Settings.getInstance().getBoolValue("showWorkedTime")) {
            footerString += String.format("%110s", "" + FormatTime.formatWorkingTime(customerMatchedWorkingTime) + " Payed Working Time");
            if(Settings.getInstance().getBoolValue("moneyShow"))
                footerString += String.format("%10s", FormatMoney.formatMoney(customerMatchedWorkingTime));
            footerString += "\n";
        }
        footerString += "\n";
        workingTime += customerWorkingTime;
        matchedWorkingTime += customerMatchedWorkingTime;
        if(entriesString.isEmpty())
            return "";
        return headString + entriesString + footerString;
    }

    private static String showTitleLine() {
        String returnString = "";
        returnString += String.format("%-40s", "");
        if(Settings.getInstance().getBoolValue("showStatus"))
            returnString += String.format("%12s", "Status");
        if(Settings.getInstance().getBoolValue("displayOnlyCompleted"))
            returnString += String.format("%14s", "Start ");
        if(Settings.getInstance().getBoolValue("displayOnlyCompleted"))
            returnString += String.format("%14s", "Finished ");
        if(Settings.getInstance().getBoolValue("showNormalTime"))
            returnString += String.format("%10s", "Worked");
        if(Settings.getInstance().getBoolValue("showWorkedTime"))
            returnString += String.format("%10s", "rounded");
        if(Settings.getInstance().getBoolValue("moneyShow")) {
            if(Settings.getInstance().getBoolValue("showNormalTime"))
                returnString += String.format("%10s", "Money");
            if(Settings.getInstance().getBoolValue("showWorkedTime"))
                returnString += String.format("%10s", "rounded");
        }
        returnString += "\n";
        return returnString;
    }

    protected static String  showFooter() {
        String returnString = "";
        returnString += String.format("%60s", "#").replace(" ", "#");
        if(Settings.getInstance().getBoolValue("showNormalTime")) {
            returnString += "\n";
            returnString += String.format("%-40s", "" + FormatTime.formatWorkingTime(workingTime) + " Total Working Time");
            if(Settings.getInstance().getBoolValue("moneyShow"))
                returnString  += String.format("%10s", FormatMoney.formatMoney(workingTime));
        }
        if(Settings.getInstance().getBoolValue("showWorkedTime")) {
            returnString += "\n";
            returnString += String.format("%-40s", "" + FormatTime.formatWorkingTime(matchedWorkingTime) + " Total Payed Working Time");
            if(Settings.getInstance().getBoolValue("moneyShow"))
                returnString  += String.format("%10s", FormatMoney.formatMoney(matchedWorkingTime));
        }
        returnString += "\n";
        returnString += String.format("%60s", "#").replace(" ", "#");
        return returnString;
    }
}
