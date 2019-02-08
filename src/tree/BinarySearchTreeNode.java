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
// @SuppressWarnings("unused") // Denna rad ska plockas bort. Den finns här
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

		if (this.data == data) {
			return false;
		} else if (comp < 0) {
			if (left == null) {
				left = new BinarySearchTreeNode(data);
				return true;
			} else {
				return left.add(data);
			}

		} else if (comp > 0) {
			if (right == null) {
				right = new BinarySearchTreeNode(data);
				return true;
			} else
				return right.add(data);
		} else
			return false;

	}

	private T findMin() {
		if (this.data == null) {
			return null;
		} else if (left == null) {
			return this.data;
		}
		return left.findMin();

		// return null;
	}

	public BinarySearchTreeNode<T> remove(T data) {
		if (this.data == null) {
			return null;
		}

//		if (data == this.data) {
//			return this;
//		}

		System.out.println("remove size " + size());
		int comp = data.compareTo(this.data);

		if (comp < 0) {
			if(left == null) {
				return this;
			}
			left = left.remove(data);

		} else if (comp > 0) {
			 if(right == null) {
				 return this;
			 }
			right = right.remove(data);

		} else {
			if (left != null && right != null) {
				this.data = this.right.findMin();
				this.right = this.right.remove(this.data);

			} else {
				return (left != null) ? left : right;
			}
		}
		return this;
		// }else if (this.left == this) {
		// this.left = (left != null) ? left : right;
		//
		// }else if (this.right == this) {
		// this.right = (left != null) ? left : right;
	}

	// } else if (left != null) {
	// return left;
	// } else {
	// return right;

	// else if(left == null && right == null) {
	// return this;
	// }

	// }
	// return null;
	// }

	// return null;

	// (left == null ) {
	// return right.remove(data);
	// }else if(right == null){
	// return left.remove(data);
	// }else {
	// return this;
	// }

	// }else if(left == this) {
	//
	// left = ( left != null ) ? left : right;
	//
	// }else if(right == this) {
	// right = ( left != null) ? left : right;
	// }
	// System.out.println(data);
	// return null;

	public boolean contains(T data) {
		int comp = data.compareTo(this.data);

		if (data == this.data) {
			return true;
		} else if (comp < 0) {
			if (left == null) {
				return false;
			} else {
				return left.contains(data);
			}
		} else if (comp > 0) {
			if (right == null) {
				return false;
			} else {
				return right.contains(data);
			}
		}

		return false;
	}

	public int size() {
		int size = 1;

		if (right == null && left == null) {
			return size = +1;
		} else if (left != null && right == null) {
			return size = +left.size() + 1;
		} else if (right != null && left == null) {
			return size = +right.size() + 1;
		} else if (left != null && right != null) {
			return size = +left.size() + right.size() + 1;
		} else
			System.out.println(size);
		return size;
	}

	public int depth() {
		if (this.data == null) {
			return -1;
		}
		int lDepth = 0;
		int rDepth = 0;

		if (left != null) {
			lDepth = left.depth() + 1;
		} else if (right != null) {
			lDepth = right.depth() + 1;
		}

		if (right != null) {
			rDepth = right.depth() + 1;
		} else if (left != null) {
			rDepth = left.depth() + 1;
		}

		if (rDepth < lDepth) {
			return lDepth;
		} else {
			return rDepth;
		}

	}

	public String toString() {
		String str = "";
		if (left != null) {
			str = str + left.toString() + ", ";
		}
		str = str + data;

		if (right != null) {
			str = str + ", " + right.toString();
		}
		return str;
	}
}