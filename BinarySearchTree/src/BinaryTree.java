import org.w3c.dom.Node;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree <E extends Comparable<E>>
{
  private BinaryTreeNode root;
  private int size;
  private ArrayList a;


  public BinaryTree(E root)
  {
    this.root = new BinaryTreeNode(root);
    size = 0;
  }

  public BinaryTree()
  {
    this.root = null;
    size = 0;
  }

  public BinaryTreeNode getRoot()
  {
    return root;
  }

  public void setRoot(BinaryTreeNode newRoot)
  {
    this.root = newRoot;
  }

  public boolean isEmpty()
  {
    return (size == 0);
  }

  public int getSize()
  {
    return size;
  }

  public boolean contains(E element)
  {
    return contains(root, element);
  }

  private boolean contains(BinaryTreeNode node, E element)
  {
    if (node.getElement() == element) {
      return true;
    }

    if (node.getLeftChild() != null) {
      return contains(node.getLeftChild(), element);
    }
    if (node.getRightChild() != null) {
      return contains(node.getRightChild(), element);
    }
    return false;
  }

    public ArrayList<E> inOrder()
    {
      this.a = new ArrayList();

      if(root == null)  return null;
      inOrder(root);
      return a;
    }

    public ArrayList<E> preOrder()
  {
    this.a = new ArrayList();

    if(root == null)  return null;
    preorderTraversal(root);
    return a;
  }

  public ArrayList<E> postOrder()
  {
    this.a = new ArrayList();

    if(root == null)  return null;
    postOrderTraversal(root);
    return a;
  }

  public ArrayList<E> leverOrder()
  {
    this.a = new ArrayList();

    if(root == null)  return null;
    levelOrderTraversal(root);
    return a;
  }

  public int height()
  {
    if (root == null) return -1;
    return findHeight(root);
  }


    private void inOrder(BinaryTreeNode node)
    {
      if (node == null) {
        return;
      }
      inOrder(node.getLeftChild());
      a.add(node.getElement());
      inOrder(node.getRightChild());
    }

  private void preorderTraversal(BinaryTreeNode node) {
    if (node == null)
      return;

    a.add(node.getElement());
    preorderTraversal(node.getLeftChild());
    preorderTraversal(node.getRightChild());
  }

  private void postOrderTraversal(BinaryTreeNode node) {

    if(node == null) return;

      postOrderTraversal(node.getLeftChild());
      postOrderTraversal(root.getRightChild());
      //Visit the node by Printing the node data
      a.add(node.getElement());
  }

  private void levelOrderTraversal(BinaryTreeNode node) {
    Queue<BinaryTreeNode> queue=new LinkedList<BinaryTreeNode>();
    queue.add(node);
    while(!queue.isEmpty())
    {
      BinaryTreeNode tempNode=queue.poll();
      a.add(tempNode.getElement());
      if(tempNode.getLeftChild()!=null)
        queue.add(tempNode.getLeftChild());
      if(tempNode.getRightChild()!=null)
        queue.add(tempNode.getRightChild());
    }
  }

  private int findHeight(BinaryTreeNode node)
  {
    int leftH = findHeight(node.getLeftChild());
    int rightH = findHeight(node.getRightChild());

    if (leftH > rightH) {
      return leftH + 1;
    } else {
      return rightH + 1;
    }
  }

}
