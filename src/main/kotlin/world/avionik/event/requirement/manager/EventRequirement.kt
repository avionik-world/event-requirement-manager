package world.avionik.event.requirement.manager

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.plugin.Plugin
import world.avionik.event.requirement.manager.event.ListenerRegisterEvent
import world.avionik.event.requirement.manager.registry.EventRegistry

/**
 * @author Niklas Nieberler
 */

object EventRequirement {

    /**
     * Registers an event with one or more requirements
     * @param listener to register
     * @param plugin where this listener should be registered
     * @param eventRequirement requirements of this event
     */
    fun registerEvents(listener: Listener, plugin: Plugin, vararg eventRequirement: EventRequirementHandler) {
        callEvent(listener)

        val declaredMethods = listener.javaClass.declaredMethods
        val methods = declaredMethods.filter { it.isAnnotationPresent(EventHandler::class.java) }
        methods.forEach { EventRegistry(listener, plugin, it, *eventRequirement).register() }
    }

    private fun callEvent(listener: Listener) {
        val event = ListenerRegisterEvent(listener)
        Bukkit.getPluginManager().callEvent(event)
    }

}