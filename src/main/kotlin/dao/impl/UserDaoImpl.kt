package dao.impl

import dao.Dao
import dao.UserDao
import manager.ConnectionManager
import model.Users
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

/**
 * @author trugaaa ( Andrey Kolesnyk )
 *
 * Class tha implements behavior described Dao interface for "users" table and Users dataclass
 * @see Dao<T> to check basic behaviour documentation
 * */
class UserDaoImpl : UserDao {
    companion object {
        const val SAVE: String =
            "INSERT INTO users (username,email,firstName,secondName,password,phone) VALUES(?,?,?,?,?,?)"
        const val DELETE_BY_ID: String =
            "DELETE FROM users WHERE id = ?"
        const val SELECT_ALL: String =
            "SELECT id,username,email, firstName,secondName,password,phone FROM users"
        const val SELECT_BY_ID: String =
            "SELECT id,username ,email,firstName,secondName,password,phone FROM users WHERE id = ?"
        const val UPDATE_BY_ID: String =
            "UPDATE users SET  username = ?, email = ?,firstName = ?, secondName = ?, password = ?, phone = ? WHERE id = ?"
    }

    private val connection = ConnectionManager.getConnection()

    override fun findAll(): List<Users> {
        val stmt = connection.prepareStatement(SELECT_ALL)
        val resultSet: ResultSet = stmt.executeQuery()
        val users = mutableListOf<Users>()
        while (resultSet.next()) {
            users.add(
                Users(
                    resultSet.getLong("id"),
                    resultSet.getString("username"),
                    resultSet.getString("email"),
                    resultSet.getString("firstName"),
                    resultSet.getString("secondName"),
                    resultSet.getString("password"),
                    resultSet.getLong("phone")
                )
            )
        }
        return users
    }

    override fun findById(id: Long): Users? {
        val stmt = connection.prepareStatement(SELECT_BY_ID)
        stmt.setLong(1, id)
        val resultSet: ResultSet = stmt.executeQuery()
        return if (resultSet.next()) {
            Users(
                resultSet.getLong("id"),
                resultSet.getString("username"),
                resultSet.getString("email"),
                resultSet.getString("firstName"),
                resultSet.getString("secondName"),
                resultSet.getString("password"),
                resultSet.getLong("phone")
            )
        } else throw SQLException("Not found")
    }


    override fun save(obj: Users): Users {
        val stmt = connection.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS)
        stmt.setString(1, obj.username)
        stmt.setString(2, obj.email)
        stmt.setString(3, obj.firstName)
        stmt.setString(4, obj.secondName)
        stmt.setString(5, obj.password)
        stmt.setLong(6, obj.phone)
        stmt.executeUpdate()
        val rs: ResultSet = stmt.generatedKeys
        if (rs.next()) {
            val newId = rs.getInt(1)
            obj.id = newId.toLong()
        }
        return obj
    }

    override fun delete(id: Long) {
        val stmt = connection.prepareStatement(DELETE_BY_ID)
        stmt.setLong(1, id)
        stmt.executeUpdate()
    }

    override fun update(obj: Users): Users {
        val stmt = connection.prepareStatement(UPDATE_BY_ID)
        stmt.setString(1, obj.username)
        stmt.setString(2, obj.email)
        stmt.setString(3, obj.firstName)
        stmt.setString(4, obj.secondName)
        stmt.setString(5, obj.password)
        stmt.setLong(6, obj.phone)
        stmt.setLong(7, obj.id!!)
        stmt.executeUpdate()
        return obj
    }
}