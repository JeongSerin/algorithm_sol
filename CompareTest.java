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
		
		// 2순위 비교
		@Override
		public int compareTo(AA o) {
			Integer a1 = this.a;
			Integer a2 = o.a;
			if (a1.compareTo(a2) == 0) {
				Integer b1 = this.b;
				Integer b2 = o.b;
				return b1.compareTo(b2);
			}
			return a1.compareTo(a2);
		}
		@Override
		public String toString() {
			return "(" + this.a + " " + this.b + ")"+ " ";
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
		for (Point pp : p) {
			System.out.print("("+pp.x + " " + pp.y + ")" + " ");
		}

		
		System.out.println();
		AA[] a = new AA[3];
		a[0] = new AA(3, 6);
		a[1] = new AA(2, 4);
		a[2] = new AA(3, 1);
		Arrays.sort(a);
		for (AA aa : a) {
			System.out.print(aa.toString());
		}
		
		Integer[] arr = new Integer[] {1, 8, 5, 6, 4};
		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		System.out.println();
		System.out.println(Arrays.toString(arr));
	}

}
