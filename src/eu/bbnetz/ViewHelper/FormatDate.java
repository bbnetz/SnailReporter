package eu.bbnetz.ViewHelper;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Created with IntelliJ IDEA.
 * User: avalarion
 * Date: 28.03.14
 * Time: 02:33
 * To change this template use File | Settings | File Templates.
 */
public class FormatDate {

    public static String formatGregorianCalendar(GregorianCalendar calendar) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.format(calendar.getTime());
    }
}
