package data

class ResponseMessages {
    companion object {
        const val NO_ELEMENT = "No element with this id found"
        const val ELEMENT_DELETED = "Element was successfully deleted"
        const val ELEMENT_ADDED = "Element was successfully created"
        const val ELEMENTS_LIST_RECEIVED = "Elements list was successfully received"
        const val ELEMENT_RECEIVED = "Element was successfully received"
    }
}

enum class MessageStatuses {
    SUCCESS,
    ERROR
}