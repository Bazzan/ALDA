package tree;

/**
 * 
 * Detta är den enda av de tre klasserna ni ska göra några ändringar i. (Om ni
 * inte vill lägga till fler testfall.) Det är också den enda av klasserna ni
 * ska lämna in. Glöm inte att namn och användarnamn ska stå i en kommentar
 * högst upp, och att paketdeklarationen måste plockas bort vid inlämningen för
 * att koden ska gå igenom de automatiska testerna.
 * 
 * De ändringar som är tillåtna är begränsade av följande:
 * <ul>
 * <li>Ni får INTE byta namn på klassen.
 * <li>Ni får INTE lägga till några fler instansvariabler.
 * <li>Ni får INTE lägga till några statiska variabler.
 * <li>Ni får INTE använda några loopar någonstans. Detta gäller också alterntiv
 * till loopar, så som strömmar.
 * <li>Ni FÅR lägga till fler metoder, dessa ska då vara privata.
 * <li>Ni får INTE låta NÅGON metod ta en parameter av typen
 * BinarySearchTreeNode. Enbart den generiska typen (T eller vad ni väljer att
 * kalla den), String, StringBuilder, StringBuffer, samt primitiva typer är
 * tillåtna.
 * </ul>
 * 
 * @author henrikbe
 * 
 * @param <T>
 */
//@SuppressWarnings("unused") // Denna rad ska plockas bort. Den finns här
							// tillfälligt för att vi inte ska tro att det är
							// fel i koden. Varningar ska normalt inte döljas på
							// detta sätt, de är (oftast) fel som ska fixas.
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