import dao.impl.CarDaoImpl
import model.Cars
import java.sql.SQLException

fun main() {
    try {
        val cars = CarDaoImpl().save(Cars(null,"Audi","A6 C5",1,12000.0))
        CarDaoImpl().save(Cars(null,"Audi","A6 C7",1,12000.0))
        println(cars)
        var carsList = CarDaoImpl().findAll()
        println("List")
        carsList.forEach{
            println(it)
        }
        println("element found")
        println(CarDaoImpl().findById(7))
        CarDaoImpl().delete(carsList.first().id!!)
        CarDaoImpl().update(Cars(5,"Audi","BMW",1,12000.0))

        carsList = CarDaoImpl().findAll()
        println("List")
        carsList.forEach{
            println(it)
        }
    } catch (ex: SQLException) {
        // handle any errors
        ex.printStackTrace()
    }
}