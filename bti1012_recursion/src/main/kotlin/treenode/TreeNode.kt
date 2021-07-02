package treenode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/** Programming 2 with Kotlin - FS 19/20,
 *  Computer Science, Bern University of Applied Sciences */

sealed class TreeNode {
    data class Node(val data: String, var left: TreeNode = Terminal, var right: TreeNode = Terminal) : TreeNode() {
        override fun toString() = "Data: $data Left:$left Right:$right"
    }
    object Terminal : TreeNode() {
        override fun toString() = "null"
    }
}

fun TreeNode.Node.isLeaf(): Boolean = this.left == TreeNode.Terminal && this.right == TreeNode.Terminal

fun TreeNode.countNodes() : Int {
    if (this is TreeNode.Terminal) return 0
    if (this is TreeNode.Node) {
        return if (this.isLeaf()) 1
        else 1 + this.left.countNodes() + this.right.countNodes()
    }
    return 0
}

val emptyTree = TreeNode.Terminal

fun TreeNode.Node.addLeft(data: String) {
    this.left = TreeNode.Node(data)
}

fun TreeNode.Node.addLeft(node: TreeNode) {
    this.left = node
}

/**
 * Add a subtree (3 nodes) left.
 */
fun TreeNode.Node.addLeft(data: String, leftData: String, rightData: String) {
    val left = TreeNode.Node(leftData)
    val right = TreeNode.Node(rightData)
    this.left = TreeNode.Node(data, left, right)
}

fun TreeNode.Node.addRight(data: String) {
    this.right = TreeNode.Node(data)
}

fun TreeNode.Node.addRight(node: TreeNode) {
    this.right = node
}

/**
 * Add a subtree (3 nodes) right.
 */
fun TreeNode.Node.addRight(data: String, leftData: String, rightData: String) {
    val left = TreeNode.Node(leftData)
    val right = TreeNode.Node(rightData)
    this.right = TreeNode.Node(data, left, right)
}




internal class TreeNodeKtTest {

    @Test
    fun countNodes_trivial() {
        Assertions.assertEquals(0, emptyTree.countNodes())
        Assertions.assertEquals(1, TreeNode.Node("a").countNodes())
        val ltree = TreeNode.Node("a")
        ltree.addLeft("b", "c", "d")
        Assertions.assertEquals(4, ltree.countNodes())
        ltree.addRight("e", "f", "g")
        Assertions.assertEquals(7, ltree.countNodes())
    }

    @Test
    fun countNodes_left() {
        var tree = TreeNode.Node("0")
        for (i in 1..5) {
            val node = TreeNode.Node(i.toString())
            node.addLeft(tree)
            tree = node
        }
        Assertions.assertEquals(6, tree.countNodes())
    }

    @Test
    fun countNodes_right() {
        var tree = TreeNode.Node("0")
        for (i in 1..3) {
            val node = TreeNode.Node(i.toString())
            node.addRight(tree)
            tree = node
        }
        Assertions.assertEquals(4, tree.countNodes())
    }
}
