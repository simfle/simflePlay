package network

import slick.jdbc.H2Profile.api._

case class NetworkGroupServer(id: Long, name: String, networkGroupId: Long)

class NetworkGroupServerTable(tag: Tag) extends Table[NetworkGroupServer](tag, "NETWORKGROUPSERVER") {
  def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)

  def name = column[String]("NAME")

  def priority = column[String]("PRIORITY")

  def networkGroupId = column[Long]("NETWORK_GROUP_ID")

  val networkGroupTable = TableQuery[NetworkGroupTable]
  val networkGroupFk = foreignKey("NETWORK_GROUP_FK", networkGroupId, networkGroupTable)(_.id)

  override def * = (id, name, networkGroupId) <> (NetworkGroupServer.tupled, NetworkGroupServer.unapply)
}
