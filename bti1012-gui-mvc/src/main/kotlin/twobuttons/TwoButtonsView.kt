package twobuttons

import javafx.scene.control.Label
import javafx.scene.layout.VBox
import tornadofx.*

class TwoButtonsView : View("My View") {
    override val root: VBox by fxml()

    private var counter1 = 0;
    private var counter2 = 0;

    private val label1 : Label by fxid()
    private val label2 : Label by fxid()

    fun click1() {
        label1.text = (++counter1).toString()
    }

    fun click2() {
        label2.text = (++counter2).toString()
    }
}
