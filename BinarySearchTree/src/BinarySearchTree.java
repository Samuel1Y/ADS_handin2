
public class BinarySearchTree <E extends Comparable<E>> extends BinaryTree
{

  private BinarySearchTreeNode root;

  public BinarySearchTree(E root)
  {
    super(root);
    this.root = new BinarySearchTreeNode(root);
  }

  public boolean insert(E element)
  {
    return insert(root, element);
  }

  public boolean removeElement(E element)
  {
    BinarySearchTreeNode curr = root;
    BinarySearchTreeNode parent = null;

    //look for element to remove and set parent node
      while (curr != null && curr.getElement() != element)
      {
        parent = curr;

        if (element.compareTo((E) root.getElement()) < 0) {
          curr = (BinarySearchTreeNode) curr.getLeftChild();
        }
        else {
          curr = (BinarySearchTreeNode) curr.getRightChild();
        }
      }

      // if element to remove was not found return false (remove failed)
      if (curr == null) {
        return false;
      }

      //if node to delete has no children
      if (curr.getLeftChild() == null && curr.getRightChild() == null)
      {
        // if the node to be deleted is not a root node
        // then set parent's left/right child to null
        if (curr != root)
        {
          if (curr == parent.getLeftChild()) {
            parent.getLeftChild() = null;
          }
          else {
            parent.getRightChild() = null;
          }
        }
        else {
          root = null;
        }
        return true;
      }

      //node to delete has two children
      else if (curr.getLeftChild() != null && curr.getRightChild() != null)
      {
        // find  successor node
        BinarySearchTreeNode successor = (BinarySearchTreeNode) findMin(
            (BinarySearchTreeNode) curr.getRightChild());

        E val = (E) successor.getElement();

        removeElement((E) successor.getElement());

        // copy value of the successor to the current node
        curr.getElement() = val;
        return true;
      }

      //node to delete has one child
      else {
        BinarySearchTreeNode child = (BinarySearchTreeNode) ((curr.getLeftChild() != null)? curr.getLeftChild(): curr.getRightChild());

        if (curr != root)
        {
          if (curr == parent.getLeftChild()) {
            parent.getLeftChild() = child;
          }
          else {
            parent.getRightChild() = child;
          }
        }

        // if node to delete is root, set root to child
        else {
          root = child;
        }
      }
      return true;
    }

  public E findMin()
  {
    return findMin(root);
  }

  public E findMax()
  {
    return findMax(root);
  }

  @Override public boolean contains(Comparable element)
  {
    if(root == null) return false;
    if(element.compareTo((E)root.getElement())  == 0) return true;
    if(element.compareTo((E) root.getElement()) < 0 && root.getLeftChild() != null && root.getLeftChild().contains(element)) return true;
    if(element.compareTo((E) root.getElement()) > 0 && root.getRightChild() != null && root.getRightChild().contains(element)) return true;
    return false;
  }

  public void reBalance()
  {

  }

  private Boolean insert(BinarySearchTreeNode node, E element)
  {
    if(node == null)
    {
      node = new BinarySearchTreeNode(element);
      return true;
    }

    if (node.getElement().compareTo(element) < 0)
    {
      insert((BinarySearchTreeNode) node.getLeftChild(), element);
    }
    else if (node.getElement().compareTo(element) > 0)
    {
      insert((BinarySearchTreeNode) node.getRightChild(), element);
    }
    return false;
  }

  private E findMin(BinarySearchTreeNode node)
  {
    BinarySearchTreeNode current = node;

    while (current.getLeftChild() != null) {
      current = (BinarySearchTreeNode) current.getLeftChild();
    }
    return ((E) current.getElement());
  }

  private E findMax(BinarySearchTreeNode node)
  {
    BinarySearchTreeNode current = node;

    while (current.getRightChild() != null) {
      current = (BinarySearchTreeNode) current.getRightChild();
    }
    return ((E) current.getElement());
  }
}
