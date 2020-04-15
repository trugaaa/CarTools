package dao

import model.Cars

/**
 * @author trugaaa ( Andrey Kolesnyk )
 *
 * Dao interface that describes behavior of Spares Dao
 * @param <Cars> - dataclass Spares that represents instanse of table "cars" of DB
 * @see Dao<T> to check basic behaviour documentation
 * */
interface CarDao:Dao<Cars>