/** Programming 2 with Kotlin - FS 20/21,
 *  Computer Science, Bern University of Applied Sciences */

package stopwatch

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport

class Timer(private val interval: Int) : Runnable {
    private var ticks = 0
    private val factor = 1000.0
    private var thread: Thread? = null

    // Returns the current value of the timer
    val time: Double
        get() = ticks * interval / factor

    private val support = PropertyChangeSupport(this)

    fun start() {
        if (thread == null) {
            val newThread = Thread(this)
            newThread.isDaemon = true
            newThread.start()
            thread = newThread

            support.firePropertyChange("started", 0L, time)
        }
    }

    fun stop() {
        if (thread != null) {
            thread = null
        }

        support.firePropertyChange("stopped", 0L, time)
    }

    fun reset() {
        ticks = 0
        support.firePropertyChange("reset", time, 0L)
    }

    override fun run() {
        while (thread != null) {
            val oldTime = time
            Thread.sleep(interval.toLong())
            ticks++
            support.firePropertyChange("changed", oldTime, time)
        }
    }

    fun addObserver(l: PropertyChangeListener) {
        support.addPropertyChangeListener(l)
    }

    fun removeObserver(l: PropertyChangeListener) {
        support.removePropertyChangeListener(l)
    }
}