package network

import slick.jdbc.H2Profile.api._

case class NetworkGroup(id: Long, name: String)

class NetworkGroupTable(tag: Tag) extends Table[NetworkGroup](tag, "NETWORKGROUP") {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  override def * = (id, name) <> (NetworkGroup.tupled, NetworkGroup.unapply)
}
