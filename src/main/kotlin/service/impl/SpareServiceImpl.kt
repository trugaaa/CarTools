package service.impl

import dao.impl.SparesDaoImpl
import model.Spares
import service.SpareService

/**
 * @author trugaaa ( Andrey Kolesnyk )
 *
 * Spare service implementation
 * */
class SpareServiceImpl : SpareService {
    private val sparesDaoImpl = SparesDaoImpl()
    override fun add(spare: Spares): Spares {
        return sparesDaoImpl.save(spare)
    }

    override fun delete(id: Long) {
        return sparesDaoImpl.delete(id)
    }

    override fun update(spare: Spares): Spares {
        return sparesDaoImpl.update(spare)
    }

    override fun selectAll(): List<Spares> {
        return sparesDaoImpl.findAll()
    }

    override fun selectById(id: Long): Spares? {
        return sparesDaoImpl.findById(id)
    }
}