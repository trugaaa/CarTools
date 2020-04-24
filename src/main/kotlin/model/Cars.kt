package model

/**
 * @author trugaaa ( Andrey Kolesnyk )
 *
 * Dataclass that represents table "cars" from DB
 * @param id - DB object(row) id
 * @param mark - column "mark" in DB table
 * @param model - column "model" in DB table
 * @param userId - column "user_id" in DB table
 * @param price - column "price" in DB table
 * */
data class Cars(var id: Long?, val mark:String, val model:String, val userId:Long, val price:Double)