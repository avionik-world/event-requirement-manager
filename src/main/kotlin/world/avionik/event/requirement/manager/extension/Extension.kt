package world.avionik.event.requirement.manager.extension

import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.PluginManager
import world.avionik.event.requirement.manager.EventRequirement
import world.avionik.event.requirement.manager.EventRequirementHandler

/**
 * @author Niklas Nieberler
 */

/**
 * Registers an event with one or more requirements
 * @param listener to register
 * @param plugin where this listener should be registered
 * @param eventRequirement requirement of this event
 */
fun PluginManager.registerEvents(listener: Listener, plugin: Plugin, eventRequirement: EventRequirementHandler) {
    EventRequirement.registerEvents(listener, plugin, eventRequirement)
}

/**
 * Registers an event with one or more requirements
 * @param listener to register
 * @param plugin where this listener should be registered
 * @param eventRequirements requirements of this event
 */
fun PluginManager.registerEvents(listener: Listener, plugin: Plugin, vararg eventRequirements: EventRequirementHandler) {
    EventRequirement.registerEvents(listener, plugin, *eventRequirements)
}


/**
 * Registers a cancellable event with requirements
 * @param priority event priority
 * @param plugin where this listener should be registered
 * @param eventRequirement requirements of this event
 */
inline fun <reified E : Event> PluginManager.registerCancelledEvent(
    priority: EventPriority,
    plugin: Plugin,
    eventRequirement: EventRequirementHandler
) {
    EventRequirement.registerCancelledEvent(E::class.java, priority, plugin, eventRequirement)
}

/**
 * Registers a cancellable event with requirements
 * @param priority event priority
 * @param plugin where this listener should be registered
 * @param eventRequirement requirements of this event
 */
inline fun <reified E : Event> PluginManager.registerCancelledEvent(
    priority: EventPriority,
    plugin: Plugin,
    vararg eventRequirement: EventRequirementHandler
) {
    EventRequirement.registerCancelledEvent(E::class.java, priority, plugin, *eventRequirement)
}