import java.lang.System.getenv

val token = getenv("TOKEN")

val channel = getenv("channel")

fun main() {
  bot {
    token = getenv("TOKEN")
    dispatch {
      message {
        val chatId = fromId(message.chat.id)
        bot.sendMessage(chatId, "Hello, telegram user!")
      }
    }
  }
}

