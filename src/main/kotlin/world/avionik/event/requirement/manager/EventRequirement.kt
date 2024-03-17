package world.avionik.event.requirement.manager

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.plugin.Plugin
import world.avionik.event.requirement.manager.registry.EventRegistry

/**
 * @author Niklas Nieberler
 */

object EventRequirement {

    fun registerEvents(listener: Listener, plugin: Plugin, vararg eventRequirement: EventRequirementHandler) {
        val declaredMethods = listener.javaClass.declaredMethods
        val methods = declaredMethods.filter { it.isAnnotationPresent(EventHandler::class.java) }
        methods.forEach { EventRegistry(listener, plugin, it, *eventRequirement).register() }
    }

}