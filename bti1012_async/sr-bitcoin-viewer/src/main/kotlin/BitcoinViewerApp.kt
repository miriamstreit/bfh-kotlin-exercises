import javafx.stage.Stage
import tornadofx.*

class BitcoinViewerApp: App(BitcoinViewerView::class) {

    override fun start(stage: Stage) {
        stage.width = 600.0
        stage.height = 500.0
        super.start(stage)
    }
}