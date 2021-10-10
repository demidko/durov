import com.github.kotlintelegrambot.Bot
import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.message
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.ChatId.Companion.fromChannelUsername
import com.github.kotlintelegrambot.entities.ChatId.Companion.fromId
import java.io.File
import java.lang.System.getenv


/**
 * Telegram-based embedded database
 */
class Durov(private val bot: Bot, private val channel: ChatId) {

  fun save(description: String, file: File) {
    val x = bot.getChat(channel).get()

    val message = bot.sendDocument(channel, file, description).first
    if (message?.isSuccessful == true) {
      val id = message.body()?.result?.document?.fileId
      if (id != null) {

      }
    }
  }
}

/**
 * Telegram-based embedded database
 */
fun Durov(botToken: String, channelName: String): Durov {
  val bot = bot { token = botToken }
  val channel = fromChannelUsername(channelName)
  return Durov(bot, channel)
}

fun main() {
  val bot = bot {
    token = getenv("TOKEN")
    dispatch {
      message {
        val chatId = fromId(message.chat.id)
        bot.sendMessage(chatId, "Hello, telegram user!")
      }
    }
  }
  bot.downloadFile()
}

