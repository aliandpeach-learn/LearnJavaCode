package com.wangjun.datastructure;

import java.util.LinkedList;
import java.util.Stack;

public class Tree {

	public static void main(String[] args) {
		Tree tree = new Tree();
		TreeNode root = new TreeNode("root");
		TreeNode node1 = new TreeNode("ndoe1");
		TreeNode node2 = new TreeNode("ndoe2");
		TreeNode node3 = new TreeNode("ndoe3");
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		System.out.println("树的深度是：" + tree.deepth(root));
		
		System.out.println("先序遍历：");
		tree.showDLR(root);
		System.out.println("\n先序遍历（非递归）：");
		tree.showDLRNotRecursion(root);
		
		System.out.println("\n中序遍历：");
		tree.showLDR(root);
		System.out.println("\n中序遍历（非递归）：");
		tree.showLDRNotRecursion(root);
		
		System.out.println("\n后序遍历：");
		tree.showLRD(root);
		
		System.out.println("\n按层遍历");
		tree.showByLevel(root);
	}
	//查找节点
	public TreeNode findNode(TreeNode treeNode, String value) {
		if(null == treeNode)
			return null;
		
		if(treeNode.value.equals(value))
			return treeNode;
		
		TreeNode leftNode = findNode(treeNode.left, value);
		TreeNode rightNode = findNode(treeNode.right, value);
		if(leftNode.value.equals(value))
			return leftNode;
		if(rightNode.value.equals(value))
			return rightNode;
		
		return null;
	}
	//添加节点
	//leftOrRight 0:left 1:right
	public boolean addNode(TreeNode treeNode, String parentNodeValue, int leftOrRight, TreeNode newNode) {
		TreeNode parentNode = findNode(treeNode, parentNodeValue);
		if(null == parentNode)
			return false;
		
		if(leftOrRight == 0) {
			parentNode.left = newNode;
			return true;
		}else if(leftOrRight == 1) {
			parentNode.right = newNode;
			return true;
		}
		
		return false;
	}
	
	//清空二叉树
	public void clearTreeNode(TreeNode treeNode) {
		if(null != treeNode) {
			clearTreeNode(treeNode.left);
			clearTreeNode(treeNode.right);
			treeNode = null;
		}
	}
	
	//计算树的深度
	//递归方法
	public int deepth(TreeNode treeNode) {
		if(treeNode == null)
			return 0;
		int left = deepth(treeNode.left);
		int right = deepth(treeNode.right);
		return left > right? left + 1: right + 1;
	}
	//显示节点数据
	public void showData(TreeNode treeNode) {
		if(treeNode != null)
			System.out.print(treeNode.value + "-->");
	}
	//遍历1 先序遍历
	public void showDLR(TreeNode treeNode) {
		if(null != treeNode) {
			showData(treeNode);
			showDLR(treeNode.left);
			showDLR(treeNode.right);
		}
	}
	//遍历2 中序遍历
	public void showLDR(TreeNode treeNode) {
		if(null != treeNode) {
			showLDR(treeNode.left);
			showData(treeNode);
			showLDR(treeNode.right);
		}
	}
	//遍历3 后序遍历
	public void showLRD(TreeNode treeNode) {
		if(null != treeNode) {
			showLRD(treeNode.left);
			showLRD(treeNode.right);
			showData(treeNode);
		}
	}
	//遍历4 按层遍历 借助队列 先进先出
	public void showByLevel(TreeNode treeNode) {
		if(null == treeNode)
			return;
		
		LinkedList<TreeNode> list = new LinkedList<>();
		TreeNode current;
		list.offer(treeNode);//将根节点入队
		
		while(!list.isEmpty()) {
			current = list.poll();//队首出队
			showData(current);//打印节点
			if(null != current.left) {
				list.offer(current.left);
			}
			if(null != current.right) {
				list.offer(current.right);
			}
		}
	}
	//遍历5 前序遍历的非递归实现
	public void showDLRNotRecursion(TreeNode treeNode) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = treeNode;
		while(null != node || stack.size() >0) {
			while(null != node) {
				showData(node);
				stack.push(node);
				node = node.left;
			}
			if(stack.size() > 0) {
				node = stack.pop();
				node = node.right;
			}
		}
	}
	//遍历6  中序遍历的非递归实现
	public void showLDRNotRecursion(TreeNode treeNode) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = treeNode;
		while(null != node || stack.size() > 0) {
			while(null != node) {
				stack.push(node);
				node = node.left;
			}
			if(stack.size() > 0) {
				node = stack.pop();
				showData(node);
				node = node.right;
			}
		}
	}
	//遍历7 后续遍历的非递归实现 ......
}

class TreeNode {
	String value;
	TreeNode left;
	TreeNode right;
	public TreeNode() {
		
	}
	public TreeNode(String value) {
		this.value = value;
	}
}
