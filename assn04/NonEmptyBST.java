package assn04;

public class NonEmptyBST<T extends Comparable<T>> implements BST<T> {
	private T _element;
	private BST<T> _left;
	private BST<T> _right;

	public NonEmptyBST(T element) {
		_left = new EmptyBST<T>();
		_right = new EmptyBST<T>();
		_element = element;
	}

	// TODO: insert
	@Override
	public BST<T> insert(T element){
		if(_element.compareTo(element) > 0){
			this._left = _left.insert(element);
		}
		else if(_element.compareTo(element) < 0){
			this._right = _right.insert(element);
		}
		return this;
	}

	// TODO: findMin
	@Override
	public T findMin() {
		while(!_left.isEmpty()){
			return this._left.findMin();
		}
		return this.getElement();
	}

	// TODO: remove
	@Override
	public BST<T> remove(T element) {
		if(_element.compareTo(element) < 0){
			_right = _right.remove(element);
			return this;
		}
		else if(_element.compareTo(element) > 0){
			_left = _left.remove(element);
			return this;
		}
		else{
			if(_right.isEmpty() && _left.isEmpty()){

				return new EmptyBST<>();
			}
			else if (!_left.isEmpty() && !_right.isEmpty()){
				this._element = this.getRight().findMin();
				_right = this.getRight().remove(_element);

				//_element = this._right.findMin();
				//return this._right = this._right.remove(element)

			}
			else if(!_left.isEmpty() && _right.isEmpty()){
				return _left;
			}
			else if(_left.isEmpty() && !_right.isEmpty()){
				return _right;
			}
		}
		return this;
	}


	// TODO: printPreOrderTraversal
	@Override
	public void printPreOrderTraversal() {
		System.out.print(this._element + " ");
		if(this._left != null){
			this._left.printPreOrderTraversal();
		}
		if(this._right != null){
			this._right.printPreOrderTraversal();
		}

	}

	// TODO: printPostOrderTraversal
	@Override
	public void printPostOrderTraversal() {
		if(this.isEmpty()){
			return;
		}
		this._left.printPostOrderTraversal();
		this._right.printPostOrderTraversal();
		System.out.print(this._element + " ");

	}

	@Override
	public int getHeight() {
		   return Math.max(_left.getHeight(), _right.getHeight())+1;
	}

	@Override
	public BST<T> getLeft() {
		return _left;
	}

	@Override
	public BST<T> getRight() {
		return _right;
	}

	@Override
	public T getElement() {
		return _element;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}
}
