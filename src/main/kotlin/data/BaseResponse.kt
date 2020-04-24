package data

import java.time.LocalDateTime

data class BaseResponse<T>(
    val payload: T?,
    val message: Message?,
    var httpCode: Int,
    var time: LocalDateTime?
)

data class ResponseWithList<T>(val list: List<T>)
data class Message(val message: String, val type: MessageStatuses)