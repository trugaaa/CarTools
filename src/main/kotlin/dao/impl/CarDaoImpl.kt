package dao.impl

import dao.CarDao
import manager.ConnectionManager.Companion.getConnection
import model.Cars
import java.sql.ResultSet
import java.sql.Statement

class CarDaoImpl : CarDao {

    companion object {
        const val SAVE: String = "INSERT INTO cars (mark,model,user_id,price) VALUES(?,?,?,?)"
        const val DELETE_BY_ID: String = "DELETE FROM cars WHERE cars.id = ?"
        const val SELECT_ALL: String = "SELECT id,mark,model,user_id,price FROM cars"
        const val SELECT_BY_ID: String = "SELECT id,mark,model,user_id,price FROM cars WHERE id = ?"
        const val UPDATE_BY_ID: String = "UPDATE cars SET  mark = ?, model = ?,user_id = ?, price = ? WHERE cars.id = ?"
    }

    private val connection = getConnection()

    override fun findAll(): List<Cars> {
        val stmt = connection.prepareStatement(SELECT_ALL)
        val resultSet: ResultSet = stmt.executeQuery()
        val cars = mutableListOf<Cars>()
        while (resultSet.next()) {
            cars.add(
                Cars(
                    resultSet.getLong("id"),
                    resultSet.getString("mark"),
                    resultSet.getString("model"),
                    resultSet.getLong("user_id"),
                    resultSet.getDouble("price")
                )
            )
        }
        return cars
    }

    override fun findById(id: Long): Cars? {
        val stmt = connection.prepareStatement(SELECT_BY_ID)
        stmt.setLong(1, id)
        val resultSet: ResultSet = stmt.executeQuery()
        return if (resultSet.next()) {
            Cars(
                resultSet.getLong("id"),
                resultSet.getString("mark"),
                resultSet.getString("model"),
                resultSet.getLong("user_id"),
                resultSet.getDouble("price")
            )
        } else null
    }

    override fun save(obj: Cars): Cars {
        val stmt = connection.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS)
        stmt.setString(1, obj.mark)
        stmt.setString(2, obj.model)
        stmt.setLong(3, obj.userId)
        stmt.setDouble(4, obj.price)
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

    override fun update(obj: Cars): Cars {
        val stmt = connection.prepareStatement(UPDATE_BY_ID)
        stmt.setString(1, obj.mark)
        stmt.setString(2, obj.model)
        stmt.setLong(3, obj.userId)
        stmt.setDouble(4, obj.price)
        stmt.setLong(5, obj.id!!)
        stmt.executeUpdate()
        return obj
    }
}