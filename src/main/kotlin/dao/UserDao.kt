package dao

import model.Users
/**
 * @author trugaaa ( Andrey Kolesnyk )
 *
 * Dao interface that describes behavior of Spares Dao
 * @param <Users> - dataclass Spares that represents instanse of table "users" of DB
 * @see Dao<T> to check basic behaviour documentation
 * */
interface UserDao:Dao<Users>