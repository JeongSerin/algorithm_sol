import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;

public class Test {


	
	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.clear();
		System.out.println(a.size());
		HashSet<Point> hs = new HashSet<>();
		hs.add(new Point(1, 2));
		hs.add(new Point(1, 2));
		System.out.println(hs.size());
	}

}
