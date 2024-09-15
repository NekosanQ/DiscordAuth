package net.nekosanq.discordauth

import ConfigManager
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class DiscordBot(configManager: ConfigManager, databaseManager: DatabaseManager) {
    private val jda: JDA = JDABuilder.createDefault(configManager.discordToken).build()
    private val channelId: String = configManager.channelId

    init {
        jda.addEventListener(MessageListener())
    }

    fun sendAuthCode(playerName: String, authCode: String) {
        val channel = jda.getTextChannelById(channelId)
        channel?.sendMessage("Player $playerName, your auth code is: $authCode")?.queue()
    }

    private inner class MessageListener : ListenerAdapter() {
        override fun onMessageReceived(event: MessageReceivedEvent) {
            val message = event.message.contentRaw
            // Handle the message and verify the auth code
        }
    }
}
