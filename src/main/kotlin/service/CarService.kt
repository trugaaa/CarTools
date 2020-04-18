package service

import model.Cars


/**
 * @author trugaaa ( Andrey Kolesnyk )
 *
 * Interface that describes behavior of Cars service
 * */
interface CarService {
    /**
     * Saving object (row) to table
     * @param car - object to be saved
     * @return Cars - returned object, if saved
     */
    fun add(car: Cars): Cars

    /**
     * Deleting object (row) from table "cars" by id
     * @param id - id of object in table "cars" to be deleted
     */
    fun delete(id:Long)

    /**
     * Updating object (row) in table "Cars"
     * @param car - new instanse of object in the table by id of this object
     * @return Cars - new updated instanse from DB
     */
    fun update(car: Cars): Cars

    /**
     * Selection of all table elements
     * @return List<T> - returns list of all table "cars" items
     */
    fun selectAll():List<Cars>

    /**
     * Selection of an table object selected by id
     * @param id - id of element to be found
     * @return Cars - returned object, if not-found returns null
     */
    fun selectById(id:Long): Cars?
}