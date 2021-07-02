package productlist

import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.lang.ClassCastException

class ProductListStorageManager(products : ArrayList<Product>) {
    init {
        println("Serializing products to file...")
        products.forEach { p ->
            print(p.toString())
            ObjectOutputStream(FileOutputStream("ProductData.txt")).use { it.writeObject(p) }
        }
        println("Serializing finished")
    }

    fun readProducts(): List<Product> {
        val products = mutableListOf<Product>()
        println("Trying to read products...")
        try {
            ObjectInputStream(FileInputStream("ProductData.txt")).use {
                val p = it.readObject() as Product
                products.add(p)
            }
        } catch (e : ClassCastException) {
            System.err.println("unexpected object type")
            return emptyList()
        }
        println("Done deserializing products")
        return products
    }

}

fun main() {
    val products = arrayListOf(Product("milk", 3.5, 7), Product("bread", 1.5, 4), Product("tomato", 2.0, 5))
    val plsm = ProductListStorageManager(products)
    val deserializedProducts = plsm.readProducts()
    println("Deserialized products: ${deserializedProducts.size}")
    deserializedProducts.forEach {
        print(it.toString())
    }
}