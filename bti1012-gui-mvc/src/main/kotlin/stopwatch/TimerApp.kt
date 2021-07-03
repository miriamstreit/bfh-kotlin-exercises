package stopwatch

import tornadofx.*
import java.nio.file.Paths


class TimerApp : App(TimerView::class) {
    init {
        importStylesheet(Paths.get("./src/main/resources/stopwatch/TimerStyle.css"))
    }
}

fun main(args: Array<String>) {
    launch<TimerApp>(args)
}