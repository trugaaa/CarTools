package dao.impl

import dao.SparesDao
import manager.ConnectionManager
import model.Spares
import java.sql.ResultSet
import java.sql.Statement

class SparesDaoImpl : SparesDao {
    companion object {
        const val SAVE: String = "INSERT INTO spares (car_id,name,price,amount) VALUES(?,?,?,?)"
        const val DELETE_BY_ID: String = "DELETE FROM spares WHERE id = ?"
        const val SELECT_ALL: String = "SELECT id,car_id,name,price,amount FROM spares"
        const val SELECT_BY_ID: String = "SELECT id,car_id,name,price,amount FROM spares WHERE id = ?"
        const val UPDATE_BY_ID: String = "UPDATE spares SET  car_id = ?, name = ?, price = ?, amount = ? WHERE id = ?"
    }

    private val connection = ConnectionManager.getConnection()

    override fun findAll(): List<Spares> {
        val stmt = connection.prepareStatement(SELECT_ALL)
        val resultSet: ResultSet = stmt.executeQuery()
        val spares = mutableListOf<Spares>()
        while (resultSet.next()) {
            spares.add(
                Spares(
                    resultSet.getLong("id"),
                    resultSet.getLong("car_id"),
                    resultSet.getString("name"),
                    resultSet.getDouble("price"),
                    resultSet.getInt("amount")
                )
            )
        }
        return spares
    }

    override fun findById(id: Long): Spares? {
        val stmt = connection.prepareStatement(SELECT_BY_ID)
        stmt.setLong(1,id)
        val resultSet: ResultSet = stmt.executeQuery()
        return if (resultSet.next()) {
             Spares(
                    resultSet.getLong("id"),
                    resultSet.getLong("car_id"),
                    resultSet.getString("name"),
                    resultSet.getDouble("price"),
                    resultSet.getInt("amount")
                )
        }
        else null
    }

    override fun save(obj: Spares): Spares {
        val stmt = connection.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS)
        stmt.setLong(1, obj.idCars)
        stmt.setString(2, obj.name)
        stmt.setDouble(3, obj.price)
        stmt.setInt(4, obj.amount)
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

    override fun update(obj: Spares): Spares {
        val stmt = connection.prepareStatement(UPDATE_BY_ID)
        stmt.setLong(1, obj.idCars)
        stmt.setString(2, obj.name)
        stmt.setDouble(3, obj.price)
        stmt.setInt(4, obj.amount)
        stmt.setLong(5, obj.id!!)
        stmt.executeUpdate()
        return obj
    }

}
