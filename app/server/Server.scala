package server

import slick.jdbc.H2Profile.api._
import slick.lifted.ProvenShape


case class Server(id: Long, name: String, publicHost: String, privateHost: String, publicPort: Int, privatePort: Int)

class ServerTable(tag:Tag) extends Table[Server](tag, "SERVER") {
  def id = column[Long]("id", O.PrimaryKey,O.AutoInc)
  def name = column[String]("name")
  def publicHost = column[String]("public_host")
  def privateHost = column[String]("private_host")
  def publicPort = column[Int]("public_port")
  def privatePort = column[Int]("private_port")
  override def * : ProvenShape[Server] = (id, name, publicHost, privateHost, publicPort, privatePort) <> (Server.tupled, Server.unapply)
}
