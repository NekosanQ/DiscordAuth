package net.nekosanq.discordauth

import ConfigManager
import org.ktorm.database.Database
import org.ktorm.dsl.insert
import org.ktorm.schema.Table
import org.ktorm.schema.varchar

class DatabaseManager(configManager: ConfigManager) {
    private val database: Database = Database.connect(
        url = configManager.databaseUrl,
        user = configManager.databaseUser,
        password = configManager.databasePassword
    )
    fun linkUser(minecraftId: String, discordId: String) {
        database.useTransaction {
            database.insert(UserTable) {
                set(it.minecraftId, minecraftId)
                set(it.discordId, discordId)
            }
        }
    }
}
object UserTable : Table<Nothing>("users") {
    val minecraftId = varchar("minecraft_id").primaryKey()
    val discordId = varchar("discord_id")
}
