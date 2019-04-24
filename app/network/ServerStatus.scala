package network

import slick.jdbc.H2Profile.api._
import slick.lifted.ProvenShape


case class ServerStatus(id: Long, serverId:Long, amountUsed: Long, maxAmount: Long, intervalSecond: Long)

class ServerStatusTable(tag:Tag) extends Table[ServerStatus](tag, "SERVERSTATUS") {
  def id = column[Long]("ID", O.PrimaryKey,O.AutoInc)
  def amountUsed = column[Long]("AMOUNT_USED")
  def maxAmount = column[Long]("MAX_AMOUNT")
  def intervalSecond = column[Long]("INTERVAL_SECOND")
  def serverId = column[Long]("SERVER_ID")

  val serverTable = TableQuery[ServerTable]
  var serverFk = foreignKey("SERVERSTATUS_SERVER_FK",serverId, serverTable)(_.id)

  override def * : ProvenShape[ServerStatus] = (id, serverId, amountUsed, maxAmount, intervalSecond) <> (ServerStatus.tupled, ServerStatus.unapply)
}
