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

	private T data;
	private BinarySearchTreeNode<T> left;
	private BinarySearchTreeNode<T> right;

	public BinarySearchTreeNode(T data) {
		this.data = data;
	}

	public boolean add(T data) {
		int comp = data.compareTo(this.data);
		
		if(comp < 0) {
			this.left != null ?  :  add(this.data);
			
		}else if(comp > 0) {
			this.right = new BinarySearchTreeNode(data);
			
		}else
		return false;
				
	}

	private T findMin() {
		if(this.left == null) {
			return this.data;
		}
		
		
		
		return null;
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
		
		if(comp < 0) {
			return left.contains(data);
		}else if(comp > 0) {
			return right.contains(data);
		}else if(comp == 0) {
			return true;
		}
		
		return false;
	}

	public int size() {
		return 0;
	}

	public int depth() {
		return -1;
	}

	public String toString() {
		return "";
	}
}