package twobuttons

import tornadofx.App
import tornadofx.importStylesheet
import tornadofx.launch
import java.nio.file.Paths


class TwoButtonsApp : App(TwoButtonsView::class) {
    init {
        importStylesheet(Paths.get("./src/main/resources/twobuttons/TwoButtonsStyle.css"))
    }
}

fun main(args: Array<String>) {
    launch<TwoButtonsApp>(args)
}

