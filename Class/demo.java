package demo;

public class demo {
	
	public static void main(String[] args) {
		/*
		System.out.println("hello world!");
		Dog d = new Dog(0xFFFF, 0.8f, 0.5f);
		Mouse m = new Mouse();
		d.catchMouse(m);
		Person p = new Person(123456, 30, 220170753);
		System.out.println(p.getAge());
		System.out.println(p.email);
		System.out.println(d.furColor);
		*/
		
		/*
		demo test = new demo();
		int date = 9;
		Birthday d1 = new Birthday(1970, 7, 7);
		Birthday d2 = new Birthday(2000, 1, 1);
		test.change1(date);
		test.change2(d1);
		test.change3(d2);
		System.out.println("date->" + date);
		d1.display();
		d2.display();
		*/
		
		Point p = new Point(1.0, 2.0, 3.0);
		Point p1 = new Point(0.0, 0.0, 0.0);
		System.out.println(p.getDistance(p1));
		p.setX(5.0);
		System.out.println(p.getDistance(new Point(1.0, 1.0, 1.0)));
		
		Max m = new Max();
		m.max(4.7,  5.9);
		
	}
	
	/*
	public void change1(int i) {
		i = 1234;
	}
	
	public void change2(Birthday b) {
		b = new Birthday(2004, 2, 22);
	}
	
	public void change3(Birthday b) {
		b.setDay(22);
	}
	*/

}

//OverLoad
class Max {
	public void max(int a, int b) {
		System.out.println(a>b ? a : b);
	}
	
	public void max(float a, float b) {
		System.out.println(a>b ? a : b);
	}
	
	public void max(double a, double b) {
		System.out.println(a>b ? a : b);
	}
}

class Dog {
	int furColor;
	float height;
	float weight;
	
	Dog(int _furColor, float _height, float _weight) {
		furColor = _furColor;
		height = _height;
		weight = _weight;
	}
	
	void catchMouse(Mouse m) {
		m.scream();
	}
}

class Mouse {
	int furColor;
	float size;
	
	void scream() {
		
	}
}

class Person {
	private int id;
	private int age = 20;
	public int email;
	
	Person(int _id, int _age, int _email) {
		id = _id;
		age = _age;
		email = _email;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int i) {
		age = i;
	}
	
	public int getId() {
		return id;
	}
	
	void info() {
		System.out.println("My id is : " + id);
	}
	
	void info(String t) {
		System.out.println(t + " id " + id);
	}
}

class Birthday {
	private int year;
	private int month;
	private int day;
	
	Birthday(int y, int m, int d) {
		year = y;
		month = m;
		day = d;
	}
	
	public void setYear(int y) {
		year = y;
	}
	
	public void setMonth(int m) {
		month = m;
	}
	
	public void setDay(int d) {
		day = d;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
	
	public void display() {
		System.out.println(day+"-"+month+"-"+year);
	}
}

class Point {
	double x;
	double y;
	double z;
	
	Point(double _x, double _y, double _z) {
		x = _x;
		y = _y;
		z = _z;
	}
	
	public void setX(double _x) {
		x = _x;
	}
	
	public void setY(double _y) {
		y = _y;
	}
	
	public void setZ(double _z) {
		z = _z;
	}
	
	public double getDistance(Point p) {
		return (x-p.x)*(x-p.x)+(y-p.y)*(y-p.y)+(z-p.z)*(z-p.z);
	}
}
