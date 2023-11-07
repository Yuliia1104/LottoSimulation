package libs;

import java.util.ArrayList;
import java.util.Arrays;

public class TestData {
    public final static String MAIN_TITLE = "Free Lottery Simulation";
    public final static String  AUSTRALIA_POWERBALL_TITLE = "Simulate playing the Australian Powerball";
    public final static String  AUSTRALIA_OZ_LOTTO_TITLE = "Simulate playing Oz Lotto Australia";
    public final static String  AUSTRALIA_SATURDAY_LOTTO_TITLE = "Simulate playing Saturday Lotto Australia";
    public final static String  AUSTRALIA_MON_AND_WEDN_LOTTO_TITLE = "Simulate playing Monday & Wednesday Lotto Australia";

    public static ArrayList<String> MAIN_MENU_ITEMS = new ArrayList<>(Arrays.asList("Australia","United States","Europe"));
    public static ArrayList<String> SUB_MENU_AUSTRALIA = new ArrayList<>(Arrays.asList("Powerball", "Oz Lotto", "Saturday Lotto", "Monday & Wednesday Lotto"));
    public static ArrayList<String> SUB_MENU_US = new ArrayList<>(Arrays.asList("Powerball", "Mega Millions"));
    public static ArrayList<String> SUB_MENU_EU = new ArrayList<>(Arrays.asList("Euro Millions", "Euro Jackpot"));
}

