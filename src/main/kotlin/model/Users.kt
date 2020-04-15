package model

/**
 * @author trugaaa ( Andrey Kolesnyk )
 *
 * Dataclass that represents table "users" from DB
 * @param id - DB object(row) id
 * @param username - column "username" in DB table
 * @param email - column "email" in DB table
 * @param firstName - column "firstName" in DB table
 * @param secondName - column "secondName" in DB table
 * @param password - column "firstName" in DB table
 * @param phone - column "secondName" in DB table
 * */
class Users(var id: Long?, var username:String, var email:String, var firstName: String, var secondName:String, var password:String, var phone:Long)