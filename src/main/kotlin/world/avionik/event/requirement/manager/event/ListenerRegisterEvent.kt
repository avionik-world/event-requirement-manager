package world.avionik.event.requirement.manager.event

import org.bukkit.event.Event
import org.bukkit.event.HandlerList
import org.bukkit.event.Listener

/**
 * @author Niklas Nieberler
 */

class ListenerRegisterEvent(
    val listener: Listener
) : Event() {

    companion object {
        private val handlerList = HandlerList()

        @JvmStatic
        fun getHandlerList(): HandlerList = handlerList
    }

    override fun getHandlers(): HandlerList = handlerList


}