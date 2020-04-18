package service

import model.Spares

/**
 * @author trugaaa ( Andrey Kolesnyk )
 *
 * Interface that describes behavior of Spares service
 * */
interface SpareService {

    /**
     * Saving object (row) to table "spares"
     * @param spare - object to be saved
     * @return Spares - returned object, if saved
     */
    fun add(spare: Spares): Spares

    /**
     * Deleting object (row) from table "spares" by id
     * @param id - id of object in table "spares" to be deleted
     */
    fun delete(id:Long)

    /**
     * Updating object (row) in table "spares"
     * @param spare - new instanse of object in the table by id of this object
     * @return Spares - new updated instanse from DB
     */
    fun update(spare: Spares): Spares

    /**
     * Selection of all table elements
     * @return List<T> - returns list of all table "spare" items
     */
    fun selectAll():List<Spares>

    /**
     * Selection of an table object selected by id
     * @param id - id of element to be found
     * @return Spares - returned object, if not-found returns null
     */
    fun selectById(id:Long): Spares?
}