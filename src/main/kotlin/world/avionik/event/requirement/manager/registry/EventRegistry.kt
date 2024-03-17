package world.avionik.event.requirement.manager.registry

import org.bukkit.Bukkit
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.plugin.EventExecutor
import org.bukkit.plugin.Plugin
import world.avionik.event.requirement.manager.EventRequirementHandler
import java.lang.IllegalArgumentException
import java.lang.reflect.Method

/**
 * @author Niklas Nieberler
 */

@Suppress("UNCHECKED_CAST")
class EventRegistry(
    private val listener: Listener,
    private val plugin: Plugin,
    private val method: Method,
    private vararg val eventRequirement: EventRequirementHandler
) {

    fun register() {
        checkRequirements()
        registerEvent()
    }

    private fun checkRequirements() {
        if (this.method.parameters.size != 1)
            throw IllegalArgumentException("Method must have one parameter")
        val eventClass = this.method.parameterTypes.first()
        if (!Event::class.java.isAssignableFrom(eventClass))
            throw IllegalArgumentException("parameter must inherit from org.bukkit.Event")
    }

    private fun registerEvent() {
        val eventHandler = this.method.getAnnotation(EventHandler::class.java)
        val eventClass = this.method.parameterTypes.first() as Class<out Event>
        registerBukkitEvent(eventHandler, eventClass) { _, event -> callEvent(event) }
    }

    private fun callEvent(event: Event) {
        if (isAnyEventRequirement(event)) {
            EventCaller(this.plugin, this.listener, this.method, event).callEvent()
        }
    }

    private fun isAnyEventRequirement(event: Event): Boolean {
        return this.eventRequirement.any { it.execute(event) }
    }

    private fun registerBukkitEvent(
        eventHandler: EventHandler,
        eventClass: Class<out Event>,
        eventExecutor: EventExecutor
    ) {
        Bukkit.getPluginManager().registerEvent(
            eventClass,
            this.listener,
            eventHandler.priority,
            eventExecutor,
            this.plugin,
            eventHandler.ignoreCancelled
        )
    }

}