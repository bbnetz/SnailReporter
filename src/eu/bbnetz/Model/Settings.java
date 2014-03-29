package eu.bbnetz.Model;

import java.util.HashMap;

public class Settings {

    protected static Settings settings;

    protected HashMap<String, Integer> values = new HashMap<String, Integer>();

    public static Settings getInstance() {
        if(settings == null)
            settings = new Settings();
        return settings;
    }

    public Settings() {
        // TODO show Money
        values.put("moneyShow", 0);
        values.put("moneyAmount", 5500);
        values.put("timeIntervals", 3600);
        values.put("showStart", 1);
        values.put("showStop", 1);
        values.put("showStatus", 1);
        values.put("showNormalTime", 1);
        values.put("showWorkedTime", 1);
        values.put("displayOnlyCompleted", 0);
    }

    public int getIntValue(String title) {
        return values.get(title);
    }

    public boolean getBoolValue(String title) {
        return values.get(title) == 1;
    }

    public void setValue(String title, String amount) {
        if(values.containsKey(title))
            values.remove(title);
        values.put(title, Integer.parseInt(amount));
    }

    public void setArgument(String arg) {
        String[] tmp = arg.split("=");
        this.setValue(tmp[0].replaceFirst("^--", ""), tmp[1]);
    }
}
