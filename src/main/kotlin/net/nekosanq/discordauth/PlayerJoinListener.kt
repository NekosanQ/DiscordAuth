package net.nekosanq.discordauth

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import java.net.http.WebSocket
import java.util.*

class PlayerJoinListener(private val discordBot: DiscordBot, private val databaseManager: DatabaseManager) :
    WebSocket.Listener, Listener {
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        val authCode = generateAuthCode()
        discordBot.sendAuthCode(player.name, authCode)
        // Store auth code and wait for verification
    }

    private fun generateAuthCode(): String {
        return UUID.randomUUID().toString().substring(0, 8)
    }
}
