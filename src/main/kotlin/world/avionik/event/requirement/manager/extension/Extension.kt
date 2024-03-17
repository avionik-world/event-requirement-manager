package world.avionik.event.requirement.manager.extension

import org.bukkit.event.Listener
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.PluginManager
import world.avionik.event.requirement.manager.EventRequirement
import world.avionik.event.requirement.manager.EventRequirementHandler

/**
 * @author Niklas Nieberler
 */

fun PluginManager.registerEvents(listener: Listener, plugin: Plugin, eventRequirement: EventRequirementHandler) {
    EventRequirement.registerEvents(listener, plugin, eventRequirement)
}

fun PluginManager.registerEvents(listener: Listener, plugin: Plugin, vararg eventRequirement: EventRequirementHandler) {
    EventRequirement.registerEvents(listener, plugin, *eventRequirement)
}