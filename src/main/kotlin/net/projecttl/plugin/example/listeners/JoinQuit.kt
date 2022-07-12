package net.projecttl.plugin.example.listeners

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class JoinQuit : Listener {

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        event.joinMessage(Component.text("+", NamedTextColor.GREEN).append(
            Component.text(": ", NamedTextColor.WHITE).append(
                Component.text(event.player.toString(), NamedTextColor.YELLOW)
            )
        ))
    }
}