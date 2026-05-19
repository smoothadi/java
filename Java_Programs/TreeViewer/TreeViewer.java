import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class TreeViewer {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tree Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("Child 1");
        DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("Child 2");
        DefaultMutableTreeNode child3 = new DefaultMutableTreeNode("Child 3");
        root.add(child1);
        root.add(child2);
        root.add(child3);
        DefaultMutableTreeNode subChild1 = new DefaultMutableTreeNode("Sub Child 1");
        DefaultMutableTreeNode subChild2 = new DefaultMutableTreeNode("Sub Child 2");
        child1.add(subChild1);
        child1.add(subChild2);
        JTree tree = new JTree(root);
        JScrollPane treeView = new JScrollPane(tree);
        frame.add(treeView,
                BorderLayout.CENTER);
        frame.setVisible(true);
    }
}