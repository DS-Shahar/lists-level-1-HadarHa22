import java.util.*;
public class Main {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		Node <Integer> n1 = new Node <Integer> (7);
		Node <Integer> n2 = new Node <Integer> (4);
		Node <Integer> n3 = new Node <Integer> (5);
		
		n1.setNext(n2);
		n2.setNext(n3);
		
		ex4(n1); // ex4
		System.out.println(ex5(n1,4)); // ex5
		
		int [] arr = {5,8,12};
		Node <Integer> first = bulid(arr);
		
		// סעיף 2
		Node<Integer> current = first;
	        while (current != null) {
	            System.out.println(current.getValue());
	            current = current.getNext();
	        } 
	   // סעיף 2 רקורסיה
	    printRec(first);	    
		
		
		Node <Integer> h = bulid(arr);
		h = delate(h,8); //ex6
		h = ex7(h,2); //ex7
		System.out.println(h);
		
		
		
		
	}
	
	public static void printRec(Node <Integer> n) {
		if (n==null) {
			return;
		}
		System.out.println(n.getValue());
		printRec(n.getNext());
	}
	
	//סעיף 1
	public static Node <Integer> bulid(int [] a){
		Node <Integer> first = new Node<Integer> (a[0]);
		Node <Integer> prev = first;
		for (int i=1; i<a.length; i++) {
			Node <Integer> current = new Node<Integer>(a[i]);
			prev.setNext(current);
			prev = current;
			
		}
		return first;
	}
	
	// סעיף 3
	public static Node <Integer> ex3(){
		Node <Integer> first = null;
		Node <Integer> last = null;
		System.out.println("enter value for node");
		int n = input.nextInt();
		while (n!=-1) {
			Node <Integer> newN = new Node<Integer>(n);
			if (first==null) {
				first = newN;
				last = first;
			}
			else {
				last.setNext(newN);
				last = newN;
			}
			System.out.println("enter value for node");
			n = input.nextInt();
		}
		return first;
	}
	
	//סעיף 4
	public static void ex4(Node <Integer> h) {
		Node <Integer> p = h;
		while(p.hasNext()) {
			if (p.getValue() % 2 == 0) {
				System.out.println(p.getValue());
			}
			p = p.getNext();
		}
	}
	// סעיף 5
	public static boolean ex5(Node <Integer> h, int x) {
		Node <Integer> p = h;
		while(p != null) {
			if (p.getValue() == x) {
				return true;
			}
			p = p.getNext();
		}
		return false;
	}
	// סעיף 5 רקורסיה
	public static boolean ex5b(Node <Integer> h, int x) {
		Node <Integer> p = h;	
		if (p == null)
			return false;
		if (p.getValue() == x) {
			return true;
		}
		return ex5b(p.getNext() , x);
	}
	
	// סעיף 6
	public static Node<Integer> delate(Node <Integer> h, int x){
		Node <Integer> p = h;
		if (p.getValue() == x) {
			return h.getNext();
		}
		while (p.hasNext()) {
			Node <Integer> t;
			if (p.getNext().getValue() == x) {
				t = p.getNext();
				p.setNext(p.getNext().getNext());
				t.setNext(null);
				return h;
			}
			p.getNext();
		}
		return h;
	}
	
	// סעיף 7
	public static Node <Integer> ex7(Node <Integer> h, int x){
		int count = 1;
		if (x == count) {
			h.setNext(null);
			return h.getNext();
			}
		Node <Integer> p = h;
		while (p.hasNext()) {
			Node <Integer> t;
			if (count == x-1) {
				t = p.getNext();
				p.setNext(t.getNext());
				t.setNext(null);
				return h;
			}
			count ++;
			p = p.getNext();
		}
		return h;
	}
}
