package tplanner.dimooon.com.tplanner.team;

import java.util.HashMap;

public abstract class PositionType {

    public static final int OUTSIDE_HITTER = 0;
    public static final int RIGHT_SIDE_HITTER = 1;
    public static final int OPPOSITE_HITTER = 2;
    public static final int MIDDLE_BLOCKER = 3;
    public static final int LIBERO = 4;
    public static final int DEFENSIVE = 5;
    public static final int SETTER = 6;

    private static HashMap<Integer , String> names = new HashMap<Integer,String>();

    static{
        names.put(OUTSIDE_HITTER,"Outside hitter (also called wing spiker, left side)");
        names.put(RIGHT_SIDE_HITTER,"Right side hitter (wing spiker, right side)");
        names.put(OPPOSITE_HITTER,"Opposite Hitter (attacker)");
        names.put(MIDDLE_BLOCKER,"Middle Blocker (center, middle hitter)");
        names.put(LIBERO,"Libero");
        names.put(DEFENSIVE,"Defensive Specialist");
        names.put(SETTER,"Setter");
    }

    public String getName(int type){
        return names.get(type);
    }
}