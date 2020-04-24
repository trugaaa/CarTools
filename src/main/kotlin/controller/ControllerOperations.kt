package controller

import javax.servlet.http.HttpServletRequest

class ControllerOperations {
    companion object {
        fun returnStringBody(req: HttpServletRequest): String {
            val buffer = StringBuilder()
            val reader = req.reader
            for (line in reader.lines()) {
                buffer.append(line)
            }
            return buffer.toString()
        }
    }
}