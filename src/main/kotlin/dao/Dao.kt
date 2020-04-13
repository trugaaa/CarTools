package dao

interface Dao<T>{

    fun findAll():List<T>
    fun findById(id:Long):T?
    fun save(obj:T):T
    fun delete(id:Long)
    fun update(obj:T):T
}