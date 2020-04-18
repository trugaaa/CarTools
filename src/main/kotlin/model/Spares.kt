package model

/**
 * @author trugaaa ( Andrey Kolesnyk )
 *
 * Dataclass that represents table "spares" from DB
 * @param id - DB object(row) id
 * @param idCars - column "cars_id" in DB table
 * @param name - column "name" in DB table
 * @param price - column "price" in DB table
 * @param amount - column "amount" in DB table
 * */
data class Spares (var id:Long?, var idCars:Long,val name:String, val price:Double, var amount: Int)