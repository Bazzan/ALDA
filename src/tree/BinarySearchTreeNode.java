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

//
//		if(comp < 0) {
//			this.left.add(data);
//		}else if(comp > 0) {
//			this.right.add(data);
//		}else 
//			return false;
//		
//		if(comp < 0) {
//			this.left = new BinarySearchTreeNode<T>(data);
//		}else if(comp > 0) {
//			this.right = new BinarySearchTreeNode<T>(data);
//		}else if (comp == 0) {
//
//			return true;
//			
//		}
		
	
				
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
		if(this == null) {
			return this;
		}
		
		int comp = data.compareTo(this.data);
		
		if(comp < 0) {
			this.left.remove(data);
		}
		System.out.println(data);
		return null;
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
		int lSize =
		
		return 0;
	}

	public int depth() {
		return -1;
	}

	public String toString() {
		return "";
	}
}