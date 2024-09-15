package net.nekosanq.discordauth

import ConfigManager
import org.bukkit.plugin.java.JavaPlugin

class DiscordAuth : JavaPlugin() {
    private lateinit var configManager: ConfigManager
    private lateinit var discordBot: DiscordBot
    private lateinit var databaseManager: DatabaseManager

    override fun onEnable() {
        saveDefaultConfig()
        databaseManager = DatabaseManager(configManager) // databaseManagerの初期化を先に行います
        configManager = ConfigManager(this, databaseManager)
        discordBot = DiscordBot(configManager, databaseManager)
        server.pluginManager.registerEvents(PlayerJoinListener(discordBot, databaseManager), this)
    }

    override fun onDisable() {

    }
}
