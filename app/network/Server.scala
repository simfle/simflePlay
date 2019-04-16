package network

import slick.jdbc.H2Profile.api._
import slick.lifted.ProvenShape


case class Server(id: Long, name: String, publicHost: String, privateHost: String, publicPort: Int, privatePort: Int)

class ServerTable(tag:Tag) extends Table[Server](tag, "SERVER") {
  def id = column[Long]("ID", O.PrimaryKey,O.AutoInc)
  def name = column[String]("NAME")
  def publicHost = column[String]("PUBLIC_HOST")
  def privateHost = column[String]("PRIVATE_HOST")
  def publicPort = column[Int]("PUBLIC_PORT")
  def privatePort = column[Int]("PRIVATE_PORT")
  override def * : ProvenShape[Server] = (id, name, publicHost, privateHost, publicPort, privatePort) <> (Server.tupled, Server.unapply)
}
