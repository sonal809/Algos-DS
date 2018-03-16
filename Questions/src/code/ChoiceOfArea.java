package code;
import java.util.Arrays;
import java.util.List;

public class ChoiceOfArea {

	static class Area {
		public int powA;
		public int powB;
		public String name;
		
		public Area (int A, int B) {
			powA = A;
			powB = B;
		}
		
		public Area(int A, int B, String name) {
			this(A, B);
			this.name = name;
		}
	}
	public static List<ChoiceOfArea.Area> list= Arrays.asList(
		new Area(3,2, "X"),
		new Area(-5,-10, "Y"),
		new Area(-20,5,"Z")
	);
	
	public static List<Area> getPossibleAreas(String name) {
		if (name == null) return list;
		if (name.equals("X")) {
			return list.subList(1, 3);
		}
		if (name.equals("Y")) {
			return Arrays.asList(list.get(0), list.get(2));
		}
		else return Arrays.asList(list.get(0), list.get(1));
	}

    
    public static int getMaxSurvivalTime(int A, int B, int st, Area op) {
        A = A + op.powA;
        B = B + op.powB;
        if (A < 0 || B < 0) {
        	return st;
        } else st += 1;

        List<Area> areas = getPossibleAreas(op.name);
        int maxtime = st;
        for (Area area : areas) {
        	int time = getMaxSurvivalTime(A, B, st, area);
        	if (time > maxtime) {
        		maxtime = time;
        	}
        }
        return maxtime;
        
    }
    
	public static void main (String[] args) {
		System.out.println(getMaxSurvivalTime(20, 8, -1, new Area(0,0)));
	}
}
