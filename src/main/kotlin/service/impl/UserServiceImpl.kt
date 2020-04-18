package service.impl

import dao.impl.UserDaoImpl
import model.Users
import service.UserService

/**
 * @author trugaaa ( Andrey Kolesnyk )
 *
 * User service implementation
 * */
class UserServiceImpl : UserService {
    private val userDaoImpl = UserDaoImpl()

    override fun add(user: Users): Users {
        return userDaoImpl.save(user)
    }

    override fun delete(id: Long) {
        userDaoImpl.delete(id)
    }

    override fun update(user: Users): Users {
       return userDaoImpl.update(user)
    }

    override fun selectAll(): List<Users> {
        return userDaoImpl.findAll()
    }

    override fun selectById(id: Long): Users? {
        return userDaoImpl.findById(id)
    }
}