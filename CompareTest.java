import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;

public class CompareTest {

	static class AA implements Comparable<AA> {
		int a;
		int b;

		AA() {}

		AA(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(AA o) {
			Integer a1 = this.a;
			Integer a2 = o.a;
			return a1.compareTo(a2);
		}
	}

	public static void main(String[] args) {
		Point[] p = new Point[2];
		p[0] = new Point(5, 1);
		p[1] = new Point(0, 1);
		Arrays.sort(p, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				Integer x1 = o1.x;
				Integer x2 = o2.x;
				return x1.compareTo(x2);
			}
		});
		System.out.println(p[0].x + " " + p[0].y);
		System.out.println(p[1].x + " " + p[1].y);

		
		System.out.println();
		AA[] a = new AA[2];
		a[0] = new AA(3, 1);
		a[1] = new AA(2, 4);
		Arrays.sort(a);
		System.out.println(a[0].a + " " + a[0].b);
		System.out.println(a[1].a + " " + a[1].b);
	}

}
