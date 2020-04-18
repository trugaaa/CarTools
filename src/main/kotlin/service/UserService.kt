package service

import model.Users

/**
 * @author trugaaa ( Andrey Kolesnyk )
 *
 * Interface that describes behavior of User service
 * */
interface UserService {

    /**
     * Saving object (row) to table "users"
     * @param user - object to be saved
     * @return Users - returned object, if saved
     */
    fun add(user:Users):Users

    /**
     * Deleting object (row) from table "users" by id
     * @param id - id of object in table "users" to be deleted
     */
    fun delete(id:Long)

    /**
     * Updating object (row) in table "users"
     * @param user - new instanse of object in the table by id of this object
     * @return Users - new updated instanse from DB
    */
    fun update(user:Users):Users

    /**
     * Selection of all table elements
     * @return List<T> - returns list of all table "users" items
     */
    fun selectAll():List<Users>

    /**
     * Selection of an table object selected by id
     * @param id - id of element to be found
     * @return Users - returned object, if not-found returns null
     */
    fun selectById(id:Long):Users?
}