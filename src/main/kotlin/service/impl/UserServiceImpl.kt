package service.impl

import dao.impl.UserDaoImpl
import data.BaseResponse
import data.Message
import data.MessageStatuses
import data.ResponseMessages.Companion.ELEMENTS_LIST_RECEIVED
import data.ResponseMessages.Companion.ELEMENT_ADDED
import data.ResponseMessages.Companion.ELEMENT_DELETED
import data.ResponseMessages.Companion.ELEMENT_RECEIVED
import data.ResponseWithList
import data.ResponseMessages.Companion.NO_ELEMENT
import model.Users
import service.UserService
import java.sql.SQLException
import java.time.LocalDateTime

/**
 * @author trugaaa ( Andrey Kolesnyk )
 *
 * User service implementation
 * */
class UserServiceImpl : UserService {
    private val userDaoImpl = UserDaoImpl()

    override fun add(user: Users): BaseResponse<Users> {
        return try {
            BaseResponse(
                userDaoImpl.update(user),
                Message(ELEMENT_ADDED, MessageStatuses.SUCCESS),
                200,
                LocalDateTime.now()
            )
        } catch (ex: SQLException) {
            BaseResponse(
                null,
                Message(ex.localizedMessage,  MessageStatuses.ERROR),
                404,
                LocalDateTime.now()
            )
        }
    }

    override fun delete(id: Long) : BaseResponse<Users>{
        try {
            val user = userDaoImpl.findById(id)
        }
        catch (ex: Exception)
        {
            return BaseResponse(
                null,
                Message(NO_ELEMENT, MessageStatuses.ERROR),
                404,
                LocalDateTime.now()
            )
        }

        userDaoImpl.delete(id)
        return  BaseResponse(null,
                Message(ELEMENT_DELETED, MessageStatuses.SUCCESS),
                200,
                LocalDateTime.now())

    }

    override fun update(user: Users): BaseResponse<Users> {
        return try {
            BaseResponse(
                userDaoImpl.update(user),
                null,
                200,
                LocalDateTime.now()
            )
        } catch (ex: SQLException) {
            BaseResponse(
                null,
                Message(NO_ELEMENT, MessageStatuses.ERROR),
                404,
                LocalDateTime.now()
            )
        }
    }

    override fun selectAll(): BaseResponse<ResponseWithList<Users>> {
        return BaseResponse(
            ResponseWithList(userDaoImpl.findAll()),
            Message(ELEMENTS_LIST_RECEIVED, MessageStatuses.SUCCESS),
            200,
            LocalDateTime.now()
        )
    }

    override fun selectById(id: Long): BaseResponse<Users> {
        return try {
            BaseResponse(
                userDaoImpl.findById(id),
                Message(ELEMENT_RECEIVED, MessageStatuses.SUCCESS),
                200,
                LocalDateTime.now()
            )
        } catch (ex: SQLException) {
            BaseResponse(
                null,
                Message(NO_ELEMENT, MessageStatuses.ERROR),
                404,
                LocalDateTime.now()
            )
        }
    }
}