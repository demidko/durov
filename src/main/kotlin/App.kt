import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.message
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.ChatId.Companion.fromId
import java.lang.System.getenv


class Durov(val token: String, val channel: String) {

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

}

