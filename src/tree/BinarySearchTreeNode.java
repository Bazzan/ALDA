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