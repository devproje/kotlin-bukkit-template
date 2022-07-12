package net.projecttl.plugin.example

import io.github.monun.kommand.PluginKommand
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor

object CommandDispatcher {

    fun register(kommand: PluginKommand) {
        kommand.register("test") {
            executes {
                sender.sendMessage(Component.text("Hello!", NamedTextColor.GREEN))
            }
        }
    }
}