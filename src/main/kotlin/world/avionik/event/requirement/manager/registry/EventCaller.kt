package world.avionik.event.requirement.manager.registry

import org.bukkit.event.Event
import org.bukkit.event.Listener
import org.bukkit.plugin.Plugin
import org.bukkit.scheduler.BukkitRunnable
import world.avionik.event.requirement.manager.InvokeEventAsync
import java.lang.reflect.Method

/**
 * @author Niklas Nieberler
 */

class EventCaller(
    private val plugin: Plugin,
    private val listener: Listener,
    private val method: Method,
    private val event: Event
) {

    fun callEvent() {
        val bukkitRunnable = executeRunnable()
        val callEventAsync = this.method.isAnnotationPresent(InvokeEventAsync::class.java)
        if (callEventAsync) {
            bukkitRunnable.runTaskAsynchronously(this.plugin)
        } else {
            bukkitRunnable.runTask(this.plugin)
        }
    }

    private fun executeRunnable(): BukkitRunnable {
        return object : BukkitRunnable() {
            override fun run() {
                invokeBukkitEvent()
            }
        }
    }

    private fun invokeBukkitEvent() {
        this.method.invoke(this.listener, this.event)
    }

}