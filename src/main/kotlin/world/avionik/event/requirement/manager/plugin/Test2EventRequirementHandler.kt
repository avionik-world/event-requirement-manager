package world.avionik.event.requirement.manager.plugin

import org.bukkit.GameMode
import org.bukkit.event.Event
import org.bukkit.event.player.PlayerEvent
import world.avionik.event.requirement.manager.EventRequirementHandler

/**
 * @author Niklas Nieberler
 */

class TestEventRequirementHandler : EventRequirementHandler {

    override fun execute(event: Event): Boolean {
        if (event !is PlayerEvent)
            return false
        return event.player.gameMode == GameMode.SPECTATOR
    }

}

class Test2EventRequirementHandler : EventRequirementHandler {

    override fun execute(event: Event): Boolean {
        if (event !is PlayerEvent)
            return false
        return event.player.gameMode == GameMode.CREATIVE
    }

}