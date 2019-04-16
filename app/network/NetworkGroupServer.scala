package network

import slick.jdbc.H2Profile.api._

case class NetworkGroupServer(id: Long, name: String)

class NetworkGroupServerTable(tag: Tag) extends Table[NetworkGroupServer](tag, "NETWORKGROUPSERVER") {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  override def * = (id, name) <> (NetworkGroupServer.tupled, NetworkGroupServer.unapply)
}
