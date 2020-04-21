package cn.endureblaze.kirby.dataclass

data class Chat(
    val id: String,
    val name: String,
    val chat_msg: String,
    val time: String,
    val chat_full_msg: String,
    val show_all: Boolean
)