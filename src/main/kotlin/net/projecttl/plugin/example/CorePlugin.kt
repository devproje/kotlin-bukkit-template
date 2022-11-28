package net.projecttl.plugin.example

import io.github.monun.kommand.kommand
import net.projecttl.plugin.example.listeners.JoinQuit
import org.bukkit.plugin.java.JavaPlugin

lateinit var instance: CorePlugin

class CorePlugin : JavaPlugin() {
    override fun onEnable() {
        instance = this
        kommand {
            CommandDispatcher.register(this)
        }
        server.pluginManager.apply {
            registerEvents(JoinQuit(), this@CorePlugin)
        }
    }

    override fun onDisable() {}
}