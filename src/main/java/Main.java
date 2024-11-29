
public class Main {

	public static void main(String[] args) {
		
		Node <Integer> n1 = new Node <Integer> (7);
		Node <Integer> n2 = new Node <Integer> (3);
		Node <Integer> n3 = new Node <Integer> (5);
		
		n1.setNext(n2);
		n2.setNext(n3);
		
		//System.out.println(n1);
		
		int [] arr = {5,8,12};
		System.out.println(bulid(arr));
		
		Node <Integer> h = bulid(arr);
		h = delate(h,8);
		System.out.println(h);
		
		
	}
	
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

}
