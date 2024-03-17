package world.avionik.event.requirement.manager.extension

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