package controller

import com.fasterxml.jackson.databind.ObjectMapper
import controller.ControllerOperations.Companion.returnStringBody
import model.Users
import service.impl.UserServiceImpl
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author trugaaa ( Andrey Kolesnyk )
 *
 * User controller implementation
 * */
@WebServlet("/users")
class UserController : HttpServlet() {
    private val userServiceImpl = UserServiceImpl()

    override fun doGet(
        req: HttpServletRequest?,
        resp: HttpServletResponse?
    ) {
        resp!!.contentType = "application/json"
        val userId = req?.getParameter("userId")

        if (userId.isNullOrBlank()) {
            val response = userServiceImpl.selectAll()
            resp.writer?.write(ObjectMapper().writeValueAsString(response))
            resp.status = response.httpCode
        } else {
            val response = userServiceImpl.selectById(userId.toLong())
            resp.writer?.write(ObjectMapper().writeValueAsString(response))
            resp.status = response.httpCode
        }
    }


    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        resp!!.contentType = "application/json"
        val stringBody = returnStringBody(req!!)
        val user = ObjectMapper().readValue(stringBody, Users::class.java)
        val response = userServiceImpl.add(user)
        resp.writer?.write(ObjectMapper().writeValueAsString(response))
        resp.status = response.httpCode
    }

    override fun doDelete(req: HttpServletRequest?, resp: HttpServletResponse?) {
        resp!!.contentType = "application/json"
        val id  =  req?.getParameter("userId")?.toLong()
        val response = userServiceImpl.delete(id!!)
        resp.writer?.write(ObjectMapper().writeValueAsString(response))
        resp.status = response.httpCode
    }
}
