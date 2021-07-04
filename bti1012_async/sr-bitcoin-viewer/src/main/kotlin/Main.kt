import tornadofx.launch

const val url = "https://api.coindesk.com/v1/bpi/currentprice.json"

class Main {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch<BitcoinViewerApp>(args)
        }
    }
}