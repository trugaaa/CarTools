package manager

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.util.*

class ConnectionManager {
    private val username = "trugaaa"
    private val password = "9421zz"
    private lateinit var conn: Connection

    init {
        val connectionProps = Properties()
        connectionProps["user"] = username
        connectionProps["password"] = password
        try {
            Class.forName("com.mysql.cj.jdbc.Driver")
            conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/cartools?useUnicode=true&serverTimezone=UTC",
                connectionProps
            )
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } catch (ex: Exception) {
            // handle any errors
            ex.printStackTrace()
        }
    }
    companion object {
        fun getConnection(): Connection {
            return ConnectionManager().conn
        }
    }
}