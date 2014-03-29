package eu.bbnetz.Service;

import eu.bbnetz.Model.Csv;
import eu.bbnetz.Model.Customer;
import eu.bbnetz.Model.Entry;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created with IntelliJ IDEA.
 * User: avalarion
 * Date: 26.03.14
 * Time: 12:19
 * To change this template use File | Settings | File Templates.
 */
public class IdentifySnail {

    public static ArrayList<Customer> read(Csv csv) {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        for(int i = 0; i < csv.getLineCounter(); i++) {
            if(csv.isEmptyLine(i)) continue;
            String customerName = IdentifySnail.identifyCustomer(csv.getLineValue(i, "Title"));
            Customer tmp = IdentifySnail.getCustomer(customerName, customers);
            tmp.addEntry(IdentifySnail.generateEntry(csv, i));
        }
        return customers;
    }

    private static Entry generateEntry(Csv csv, int i) {
        Entry tmpEntry = new Entry();
        tmpEntry.setStatus(csv.getLineValue(i, "Status"));
        tmpEntry.setTitle(IdentifySnail.removeCustomerFromTask(csv.getLineValue(i, "Title")));
        tmpEntry.setSpentedTime(IdentifySnail.getMinutes(csv.getLineValue(i, "Time Spent")));
        tmpEntry.setStartDate(IdentifySnail.renderGregorianCalendar(csv.getLineValue(i, "Start Date")));
        tmpEntry.setCompletionDate(IdentifySnail.renderGregorianCalendar(csv.getLineValue(i, "Completion Date")));
        return tmpEntry;
    }

    protected static Customer getCustomer(String customerName, ArrayList<Customer> customers) {
        for(Customer c:customers)
            if(c.getTitle().equals(customerName))
                return c;
        Customer tmpCustomer = new Customer();
        tmpCustomer.setTitle(customerName);
        customers.add(tmpCustomer);
        return tmpCustomer;
    }

    /**
     *
     * @param task
     * @return
     */
    protected static String identifyCustomer(String task) {
        return task.replaceAll("\\].*", "").replaceFirst("\\[", "").replaceAll("\"", "");
        // return task.split("^..")[1].split("]")[0];
    }

    protected static String removeCustomerFromTask(String task) {
        return task.replaceFirst("\\[.*\\]", "").replaceAll("\"", "");
    }

    protected static int getMinutes(String time) {
        int secs = 0;
        String[] times = time.split(":");
        secs += Integer.parseInt(times[0]) * 60 * 60;
        secs += Integer.parseInt(times[1]) * 60;
        secs += Integer.parseInt(times[2]);
        return secs;
    }

    protected static GregorianCalendar renderGregorianCalendar(String date) {
        String[] dates = date.split("-");
        if(date.equals("") || dates.length != 3)
            return null;
        return new GregorianCalendar(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2]));
    }
}
