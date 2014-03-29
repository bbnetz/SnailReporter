package eu.bbnetz.Model;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: avalarion
 * Date: 26.03.14
 * Time: 12:13
 * To change this template use File | Settings | File Templates.
 */
public class Customer {

    protected String title;

    protected ArrayList<Entry> entries = new ArrayList<Entry>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Entry> getEntries() {
        return entries;
    }

    public void setEntries(ArrayList<Entry> entries) {
        this.entries = entries;
    }

    public void addEntry(Entry tmpEntry) {
        this.entries.add(tmpEntry);
    }
}
