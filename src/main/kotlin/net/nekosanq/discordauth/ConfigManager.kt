import net.nekosanq.discordauth.DatabaseManager
import net.nekosanq.discordauth.DiscordAuth
import org.bukkit.configuration.file.FileConfiguration

class ConfigManager(plugin: DiscordAuth, databaseManager: DatabaseManager) {
    private val config: FileConfiguration = plugin.config

    init {
        plugin.saveDefaultConfig()
    }

    val discordToken: String
        get() = config.getString("discord.token") ?: ""

    val channelId: String
        get() = config.getString("discord.channelId") ?: ""

    val databaseUrl: String
        get() = config.getString("database.url") ?: ""

    val databaseUser: String
        get() = config.getString("database.user") ?: ""

    val databasePassword: String
        get() = config.getString("database.password") ?: ""
}
