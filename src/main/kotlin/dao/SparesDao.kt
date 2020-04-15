package dao

import model.Spares

/**
 * @author trugaaa ( Andrey Kolesnyk )
 *
 * Dao interface that describes behavior of Spares Dao
 * @param <Spares> - dataclass Spares that represents instanse of table "spares" of DB
 * @see Dao<T> to check basic behaviour documentation
 * */
interface SparesDao:Dao<Spares>
