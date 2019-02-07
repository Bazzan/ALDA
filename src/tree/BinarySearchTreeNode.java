package tree;

/**
 * 
 * Detta �r den enda av de tre klasserna ni ska g�ra n�gra �ndringar i. (Om ni
 * inte vill l�gga till fler testfall.) Det �r ocks� den enda av klasserna ni
 * ska l�mna in. Gl�m inte att namn och anv�ndarnamn ska st� i en kommentar
 * h�gst upp, och att paketdeklarationen m�ste plockas bort vid inl�mningen f�r
 * att koden ska g� igenom de automatiska testerna.
 * 
 * De �ndringar som �r till�tna �r begr�nsade av f�ljande:
 * <ul>
 * <li>Ni f�r INTE byta namn p� klassen.
 * <li>Ni f�r INTE l�gga till n�gra fler instansvariabler.
 * <li>Ni f�r INTE l�gga till n�gra statiska variabler.
 * <li>Ni f�r INTE anv�nda n�gra loopar n�gonstans. Detta g�ller ocks� alterntiv
 * till loopar, s� som str�mmar.
 * <li>Ni F�R l�gga till fler metoder, dessa ska d� vara privata.
 * <li>Ni f�r INTE l�ta N�GON metod ta en parameter av typen
 * BinarySearchTreeNode. Enbart den generiska typen (T eller vad ni v�ljer att
 * kalla den), String, StringBuilder, StringBuffer, samt primitiva typer �r
 * till�tna.
 * </ul>
 * 
 * @author henrikbe
 * 
 * @param <T>
 */
//@SuppressWarnings("unused") // Denna rad ska plockas bort. Den finns h�r
							// tillf�lligt f�r att vi inte ska tro att det �r
							// fel i koden. Varningar ska normalt inte d�ljas p�
							// detta s�tt, de �r (oftast) fel som ska fixas.
public class BinarySearchTreeNode<T extends Comparable<T>> {

	public T data;
	public BinarySearchTreeNode<T> left;
	public BinarySearchTreeNode<T> right;

	public BinarySearchTreeNode(T data) {
		this.data = data;
		
		
	}

	public boolean add(T data) {
		int comp = data.compareTo(this.data);
		
		if(this.data == data) {
			return false;			
		}else if(comp < 0) {
			if(left == null) {
				left = new BinarySearchTreeNode(data);
				return true;
			}else {
				return left.add(data);
			}
			
		}else if(comp > 0) {
			if(right == null) {
				right = new BinarySearchTreeNode(data);
				return true;
			}else
				return right.add(data);
		}else 
			return false;
				
	}

	private T findMin() {
		if(this.data == null) {
			return null;
		}else if(left == null) {
			return data;
		}return left.findMin();
		
		
		
//		return null;
	}

	public BinarySearchTreeNode<T> remove(T data) {
		if(this.data == null) {
			return this;
		}
		
		int comp = data.compareTo(this.data);
		
//		if (data == this.data) {
//			return this.data = null;
//		
//		}
		if(comp < 0) {
			 return left.remove(data);
		
		}else if(comp > 0) {	
			return right.remove(data);
		
		}else if(left != null && right != null) {	
			this.data = right.findMin();
			right.remove(this.data);

		}else
			this.data = (left != null ) ? left.remove(data) : right.remove(data);
			return null;
		
			
//		}else if(left == this) {
//
//			left = ( left != null ) ?  left : right;
//		
//		}else if(right == this) {
//			right = ( left != null) ? left : right;
//		}
//		System.out.println(data);
//		return null;
	}

	public boolean contains(T data) {
		int comp = data.compareTo(this.data);
		
		if(data == this.data) {
			return true;
		}else if(comp < 0) {
			if(left == null) {
				return false;
			}else {
				return left.contains(data);
			}
		}else if(comp > 0) {
			if(right == null) {
				return false;
			}else {
				return right.contains(data);
			}
		}
		
		return false;
	}

	public int size() {
		int size = 1;
		
		if(right == null && left == null) {
			return size =+ 1;
		}else if(left != null && right == null) {
			return size =+ left.size() + 1;
		}else if(right != null && left == null) {
			return size =+ right.size() + 1;
		}else if (left != null && right != null) {
			return size =+left.size() + right.size() + 1;
		}else
		System.out.println(size);
		return size;
	}

	public int depth() {
		if(this.data == null) {
			return -1;
			}
		int lDepth = 0;
		int rDepth = 0;
		
		if(left != null) {
			lDepth = left.depth() + 1;
		}else if(right != null ) {
			lDepth = right.depth() + 1;
		}

		if(right != null) {
			rDepth = right.depth() + 1;
		}else if(left != null) {
			rDepth = left.depth() +1;
		}
		
		if(rDepth < lDepth) {
			return lDepth;
		}else {
			return rDepth;
		}
		
	}

	public String toString() {
		String str = "";
		if (left != null) {
			str = str + left.toString() + ", ";
		}
		str = str + data;
		
		if(right != null){
			str = str +  ", " + right.toString();
		}
		return str;
	}
}