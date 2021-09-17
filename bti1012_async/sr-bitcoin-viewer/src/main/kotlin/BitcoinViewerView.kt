import javafx.scene.control.Label
import javafx.scene.layout.HBox
import model.BitcoinData
import tornadofx.View

class BitcoinViewerView: View("Bitcoin Viewer") {
    override val root: HBox by fxml("bitcoin_dashboard.fxml");

    val bitcoinRateLabel: Label by fxid();

    lateinit var bitcoinData: BitcoinData;

    init {
        bitcoinRateLabel.text = "BITCOIN :D";

        updateRate();
    }

    private fun updateRate() {
        println("Updating rate by calling API...")
        val apiRequester: ApiRequester = ApiRequester();
        this.bitcoinData = apiRequester.callUrl(coindeskUrl);
        bitcoinRateLabel.text = "The USD-rate is currently: " + this.bitcoinData.bpi.USD.rate;
    }

    fun onUpdateRateClick() {
        updateRate();
    }
}