package manager

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.util.*

/**
 * @author trugaaa ( Andrey Kolesnyk )
 *
 * Class that describes behavior of DB connection
 * @param username - username of user with access to DB
 * @param password - password of user with access to DB
 * @param conn - instanse of connection
 *
 * */
class ConnectionManager {
    private val username = "trugaaa"
    private val password = "9421zz"
    private lateinit var conn: Connection


    /**
     * Initialization block that describes initialization of connection to DB
      */
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

        /**
         * Static method that returns instanse of DB connection
         * @return Conncetion - Instanse of DB connection
         */
        fun getConnection(): Connection {
            return ConnectionManager().conn
        }
    }
}