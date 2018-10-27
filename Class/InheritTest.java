package DemoPKG1;

public class InheritTest {
	
	public static void main(String[] args) {
		
//		Student s1 = new Student();
//		s1.setName("John");
//		s1.setSchool("Southeast");
//		s1.setAge(25);
//		Person p1 = new Person();
//		p1.setName("Mike");
//		p1.setAge(73);
//		System.out.println(s1.getInfo());
//		System.out.println(p1.getInfo());
		
//		ChildClass cc = new ChildClass();
//		cc.f();
		
//		SubClass s1 = new SubClass();
//		SubClass s2 = new SubClass(200);
		
		B b = new B();
		b.f();
		
	}

}

class Person {
	private int age;
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	protected String getInfo() {
		return "Name: " + this.name + " Age: " + this.age;
	}
}

class Student extends Person {
	private String school;
	
	public String getSchool() {
		return school;
	}
	
	public void setSchool(String school) {
		this.school = school;
	}
	
	protected String getInfo() {
		return "Name: " + this.getName() + " Age: " + this.getAge();
	}
}

class FatherClass {
	protected int val;
	
	public void f() {
		val = 100;
		
		System.out.println("FatherClass.val=" + val);
	}
}

class ChildClass extends FatherClass {
	private int val;
	
	public void f() {
		super.f();
		this.val = 200;
		System.out.println("ChildClass.val=" + this.val);
		System.out.println(super.val);
	}
}

class SuperClass {
	private int n;
	
	SuperClass() {
		System.out.println("SuperClass()");
		this.n = 0;
	}
	
	SuperClass(int n) {
		System.out.println("SuperClass(" + n + ")");
		this.n= n;
	}
}

class SubClass extends SuperClass {
	private int n;
	
	SubClass(int n) {
		System.out.println("SubClass(" + n + ")");
		this.n = n;
	}
	
	SubClass() {
		super(300);
		System.out.println("SubClass");
	}
}

class A {
	protected void print(String s) {
		System.out.println(s);
	}
	
	A() {
		this.print("A()");
	}
	
	public void f() {
		this.print("A:f()");
	}
}

class B extends A {
	B() {
		this.print("B()");
	}
	
	public void f() {
		this.print("B:f()");
	}
}