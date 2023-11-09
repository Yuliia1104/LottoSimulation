package libs;

import java.util.ArrayList;
import java.util.Arrays;

public class TestData {
    public final static String MAIN_TITLE = "Free Lottery Simulation";
    public final static String  AUSTRALIA_POWERBALL_TITLE = "Simulate playing the Australian Powerball";
    public final static String  AUSTRALIA_OZ_LOTTO_TITLE = "Simulate playing Oz Lotto Australia";
    public final static String  AUSTRALIA_SATURDAY_LOTTO_TITLE = "Simulate playing Saturday Lotto Australia";
    public final static String  AUSTRALIA_MON_AND_WEDN_LOTTO_TITLE = "Simulate playing Monday & Wednesday Lotto Australia";
    public final static String  GAME_RULES_AND_DETAILS_TITLE = "Details & rules";
    public final static String GAME_RULES_CONTENT = "The main balls and the Powerball are drawn from 2 separate barrels. The main barrel contains numbers from 1 to 35, and the Powerball barrel numbers from 1 to 20. 7 numbers are drawn from the main barrel, and one Powerball is drawn from the Powerball barrel.";
    public final static String JP_AMOUNT = "The Australian Powerball Jackpot currently sits at A$8M.";
    public final static String ONE_HUNDRED = "$100.00";
    public final static String ONE_THOUSAND = "$1,000.00";
    public final static String TEN_THOUSAND = "$10,000.00";
    public final static String ONE_HUNDRED_THOUSAND = "$100,000.00";
    public final static String END_BALANCE = "$111,100.00";

    public static ArrayList<String> MAIN_MENU_ITEMS = new ArrayList<>(Arrays.asList("Australia","United States","Europe"));
    public static ArrayList<String> SUB_MENU_AUSTRALIA = new ArrayList<>(Arrays.asList("Powerball", "Oz Lotto", "Saturday Lotto", "Monday & Wednesday Lotto"));
    public static ArrayList<String> SUB_MENU_US = new ArrayList<>(Arrays.asList("Powerball", "Mega Millions"));
    public static ArrayList<String> SUB_MENU_EU = new ArrayList<>(Arrays.asList("Euro Millions", "Euro Jackpot"));
    public static ArrayList<String> MONETARY_OPTIONS = new ArrayList<>(Arrays.asList("$100", "$1K", "$10K", "$100K"));

}

