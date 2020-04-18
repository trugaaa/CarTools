package service.impl

import dao.impl.CarDaoImpl
import model.Cars
import service.CarService

/**
 * @author trugaaa ( Andrey Kolesnyk )
 *
 * Car service implementation
 * */
class CarServiceImpl : CarService {
    private val carDaoImpl = CarDaoImpl()

    override fun add(car: Cars): Cars {
        return carDaoImpl.save(car)
    }

    override fun delete(id: Long) {
        carDaoImpl.delete(id)
    }

    override fun update(car: Cars): Cars {
        return carDaoImpl.update(car)
    }

    override fun selectAll(): List<Cars> {
        return carDaoImpl.findAll()
    }

    override fun selectById(id: Long): Cars? {
        return carDaoImpl.findById(id)
    }
}