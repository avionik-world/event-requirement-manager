package world.avionik.event.requirement.manager.plugin

import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerEvent
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.plugin.java.JavaPlugin
import world.avionik.event.requirement.manager.extension.registerEvents

/**
 * @author Niklas Nieberler
 */

class SpigotPlugin : JavaPlugin() {

    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(TestListener(), this, TestEventRequirementHandler(), Test2EventRequirementHandler())
    }

}

class TestListener : Listener {

    @EventHandler
    fun handleTest(event: PlayerMoveEvent) {
        event.player.sendMessage("asd")
    }

}