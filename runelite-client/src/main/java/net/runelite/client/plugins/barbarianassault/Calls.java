package net.runelite.client.plugins.barbarianassault;

import java.util.HashMap;
import java.util.Map;

public enum Calls
{
    //Attacker Calls
    RED_EGG("Red egg", "Tell-red"),
    GREEN_EGG("Green egg", "Tell-green"),
    BLUE_EGG("Blue egg", "Tell-blue"),
    //Collector Calls
    CONTROLLED("Controlled/Bullet/Wind", "Tell-controlled"),
    ACCURATE("Accurate/Field/Water", "Tell-accurate"),
    AGGRESSIVE("Aggressive/Blunt/Earth", "Tell-aggressive"),
    DEFENSIVE("Defensive/Barbed/Fire", "Tell-defensive"),
    //Healer Calls
    TOFU("Tofu", "Tell-tofu"),
    CRACKERS("Crackers", "Tell-crackers"),
    WORMS("Worms", "Tell-worms"),
    //Defender Calls
    POIS_WORMS("Pois. Worms", "Tell-worms"),
    POIS_TOFU("Pois. Tofu", "Tell-tofu"),
    POIS_MEAT("Pois. Meat", "Tell-meat");

    private final String call;
    private final String option;

    private static final Map<String, String> CALL_MENU = new HashMap<>();

    static
    {
        for (Calls s : values())
        {
            CALL_MENU.put(s.getCall(), s.getOption());
        }
    }

    Calls(String call, String option)
    {
        this.call = call;
        this.option = option;
    }

    public String getCall()
    {
        return call;
    }

    public String getOption()
    {
        return option;
    }

    public static String getOption(String call)
    {
        return CALL_MENU.get(call);
    }

}
