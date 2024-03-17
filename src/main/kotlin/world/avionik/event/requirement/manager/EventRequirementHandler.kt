package world.avionik.event.requirement.manager

import org.bukkit.event.Event

/**
 * @author Niklas Nieberler
 */

fun interface EventRequirementHandler {

    /**
     * This method is executed when an event with this requirement is called.
     * @param event that is about to be executed
     * @return whether this event should be executed or not
     */
    fun execute(event: Event): Boolean

}