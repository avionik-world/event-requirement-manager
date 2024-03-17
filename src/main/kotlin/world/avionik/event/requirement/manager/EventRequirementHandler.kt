package world.avionik.event.requirement.manager

import org.bukkit.event.Event

/**
 * @author Niklas Nieberler
 */

fun interface EventRequirementHandler {

    fun execute(event: Event): Boolean

}