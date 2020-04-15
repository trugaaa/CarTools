package dao
/**
 * @author trugaaa ( Andrey Kolesnyk )
 *
 * Dao interface that describes basic behavior of Dao implementations
 * @param <T> - dataclass with what we
 * */
interface Dao<T>{

    /**
     * Selection of all table elements
     * @return List<T> - returns list of all table items
     */
    fun findAll():List<T>

    /**
     * Selection of an table object selected by id
     * @param id - id of element to be found
     * @return T? - returned object, if not-found returns null
     */
    fun findById(id:Long):T?

    /**
     * Saving object (row) to table
     * @param obj - object to be saved
     * @return T - returned object, if saved
     */
    fun save(obj:T):T

    /**
     * Deleting object (row) from table by id
     * @param id - id of object in row to be deleted
     */
    fun delete(id:Long)

    /**
     * Updating object (row) in table
     * @param obj - new instanse of object in the table by id of this object
    */
    fun update(obj:T):T
}