package utils;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinPriorityQueue<Integer> a = new MinPriorityQueue();
		a.add(10);
		a.add(8);
		a.add(9);
		a.add(7);
		a.add(6);
		a.add(5);
		a.add(4);
		a.print();
		a.remove();
		a.print();
		a.remove();
		a.print();
		a.remove();
		a.print();
		a.remove();
		a.print();
		a.remove();
		a.print();
		a.remove();
		a.print();
	}

}
