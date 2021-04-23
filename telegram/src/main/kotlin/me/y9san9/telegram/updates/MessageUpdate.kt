package me.y9san9.telegram.updates

import dev.inmo.tgbotapi.bot.TelegramBot
import dev.inmo.tgbotapi.extensions.api.delete
import dev.inmo.tgbotapi.types.message.abstracts.ContentMessage
import dev.inmo.tgbotapi.types.message.abstracts.PrivateContentMessage
import dev.inmo.tgbotapi.types.message.content.TextContent
import me.y9san9.telegram.updates.hierarchies.FromChatLocalizedDIBotUpdate
import me.y9san9.telegram.updates.primitives.*
import me.y9san9.telegram.extensions.languageCode


class MessageUpdate<out DI> (
    override val bot: TelegramBot,
    override val di: DI,
    private val message: ContentMessage<*>,
) : FromChatLocalizedDIBotUpdate<DI>, HasTextUpdate {
    suspend fun delete() = message.delete(bot)

    override val languageCode: String? = message.languageCode
    override val chatId: Long = message.chat.id.chatId
    override val text: String? = (message.content as? TextContent)?.text
}