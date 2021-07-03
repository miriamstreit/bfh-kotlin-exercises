package stopwatch

import javafx.application.Platform
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import tornadofx.View
import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener

class StopWatch(timer : Timer) : Label(), PropertyChangeListener {
	init {
	    timer.addObserver(this)
		text = 0.0.toString()
		id = "timeLabel"
	}

	override fun propertyChange(evt: PropertyChangeEvent?) {
		Platform.runLater{
			text = evt?.newValue.toString()
		}
	}

}

class TimerView : View("Stopwatch") {
    override val root: VBox by fxml()

	val statusLabel : Label by fxid()

	val startButton : Button by fxid()
	val stopButton : Button by fxid()
	val resetButton : Button by fxid()

	var timer : Timer = Timer(100)

	init {
		var timeLabel = StopWatch(timer)

		root.children[0] = StopWatch(timer)
	}

	fun runStart() {
		timer.start()

		startButton.isDisable = true
		resetButton.isDisable = true
		stopButton.isDisable= false
		statusLabel.text = "Running..."
	}

	fun runStop() {
		timer.stop()

		startButton.isDisable = false
		resetButton.isDisable = false
		stopButton.isDisable= true
		statusLabel.text = "Stopped"
	}

	fun runReset() {
		timer.reset()

		startButton.isDisable = false
		resetButton.isDisable = false
		stopButton.isDisable= true
		statusLabel.text = "Reset to 0"
	}
}

