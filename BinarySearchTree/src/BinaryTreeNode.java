import javax.lang.model.element.Element;

public class BinaryTreeNode <E extends Comparable<E>>
{
  private E element;
  private BinaryTreeNode leftChild;
  private BinaryTreeNode rightChild;

  public BinaryTreeNode(E element)
  {
    this.element = element;
    this.leftChild = null;
    this. rightChild = null;
  }

  public void setElement(E element)
  {
    this.element = element;
  }
  public E getElement()
  {
    return element;
  }

  public void addLeftChild(BinaryTreeNode leftChildNode)
  {
    this.leftChild = leftChildNode;
  }

  public void addRightChild(BinaryTreeNode rightChildNode)
  {
    this.rightChild = rightChildNode;
  }

  public BinaryTreeNode getLeftChild()
  {
    return leftChild;
  }

  public BinaryTreeNode getRightChild()
  {
    return rightChild;
  }

 /* public Boolean contains(E element)
  {
    return this.element.compareTo(element) == 0;
  }*/

  public boolean contains(E element)
  {
    if(element.compareTo(this.element) == 0) return true;
    if(leftChild != null) leftChild.contains(element);
    if(rightChild != null) rightChild.contains(element);
    // no matching node was found
    return false;
}
}
