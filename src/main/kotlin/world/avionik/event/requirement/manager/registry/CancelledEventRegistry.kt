package world.avionik.event.requirement.manager.registry

import org.bukkit.Bukkit
import org.bukkit.event.Cancellable
import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.plugin.EventExecutor
import org.bukkit.plugin.Plugin
import world.avionik.event.requirement.manager.EventRequirementHandler

/**
 * @author Niklas Nieberler
 */

class CancelledEventRegistry(
    private val eventClass: Class<out Event>,
    private val plugin: Plugin,
    private val eventPriority: EventPriority,
    private vararg val eventRequirement: EventRequirementHandler
) {

    fun register() {
        registerBukkitEvent(this.eventPriority, this.eventClass) { _, event -> callEvent(event) }
    }

    private fun callEvent(event: Event) {
        if (isAnyEventRequirement(event) && event is Cancellable) {
            event.isCancelled = true
        }
    }

    private fun isAnyEventRequirement(event: Event): Boolean {
        return this.eventRequirement.any { it.execute(event) }
    }

    private fun registerBukkitEvent(
        eventPriority: EventPriority,
        eventClass: Class<out Event>,
        eventExecutor: EventExecutor
    ) {
        Bukkit.getPluginManager().registerEvent(
            eventClass,
            CancelledListener(),
            eventPriority,
            eventExecutor,
            this.plugin,
        )
    }

    class CancelledListener : Listener

}