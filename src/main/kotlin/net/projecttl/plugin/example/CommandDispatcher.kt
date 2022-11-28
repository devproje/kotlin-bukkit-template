package net.projecttl.plugin.example

import io.github.monun.kommand.PluginKommand
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.projecttl.plugin.example.utils.ExampleUtil

object CommandDispatcher {
    fun register(kommand: PluginKommand) {
        kommand.register("test") {
            executes {
                val util = ExampleUtil()
                sender.sendMessage(Component.text(util.str, NamedTextColor.GREEN))
            }
        }
    }
}