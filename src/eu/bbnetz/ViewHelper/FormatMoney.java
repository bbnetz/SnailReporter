package eu.bbnetz.ViewHelper;

import eu.bbnetz.Model.Settings;

/**
 * Created with IntelliJ IDEA.
 * User: avalarion
 * Date: 28.03.14
 * Time: 02:40
 * To change this template use File | Settings | File Templates.
 */
public class FormatMoney {

    public static String formatMoney(int time) {
        int amount = ( time / 3600 * Settings.getInstance().getIntValue("moneyAmount"));
        return "" + ("" + (amount/100)).replaceAll("\\.", ",")  + "€";
    }
}
