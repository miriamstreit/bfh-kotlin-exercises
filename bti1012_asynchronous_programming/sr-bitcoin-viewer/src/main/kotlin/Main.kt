import tornadofx.launch

class Main {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch<BitcoinViewerApp>(args)
        }
    }
}