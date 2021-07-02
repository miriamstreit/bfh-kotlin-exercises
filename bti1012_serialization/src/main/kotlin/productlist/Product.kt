package productlist

import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.Serializable

data class Product(val name: String, val price: Double = 0.0, val quantity: Int = 0) : Serializable {
    @Throws(IOException::class)
    private fun writeObject(out: ObjectOutputStream) {
        out.writeObject(name)
        out.writeDouble(price)
        out.writeInt(quantity)
    }

    @Throws(IOException::class, ClassNotFoundException::class)
    private fun readObject(inp: ObjectInputStream) {
        inp.readObject() as String
        inp.readDouble()
        inp.readInt()
    }

    override fun toString() = "Name: $name, Price: $price, Quantity: $quantity\n"
}