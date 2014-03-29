package eu.bbnetz.ViewHelper;

/**
 * Created with IntelliJ IDEA.
 * User: avalarion
 * Date: 26.03.14
 * Time: 12:19
 * To change this template use File | Settings | File Templates.
 */
public class FormatTime {

    public static String formatWorkingTime(int seconds) {
        int hours = (int)(seconds / (60 * 60));
        int minutes = (int)((seconds - (hours * 60 * 60)) / 60);
        seconds = (int)(seconds - hours * 60 * 60 - minutes * 60);
        return hours + ":" + minutes;
    }
}
