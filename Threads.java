// importing awt class  

class t1 extends Thread {

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Lawda");
			try {
				sleep(1000);
			} catch (Exception e) {

			}
		}
	}
}

class t2 extends Thread {

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("swamy");
			try {
				sleep(2000);
			} catch (Exception e) {

			}
		}
	}
}

class t3 extends Thread {

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("zindabad");
			try {
				sleep(10000);
			} catch (Exception e) {

			}
		}
	}
}

public class Threads {

	// main method
	public static void main(String args[]) {
		t1 tt1 = new t1();
		t2 tt2 = new t2();
		t3 tt3 = new t3();
		tt1.start();
		tt2.start();
		tt3.start();
	}
}
