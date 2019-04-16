package network

import javax.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.H2Profile
import slick.jdbc.H2Profile.api._

import scala.concurrent.Future


@Singleton
class ServerRepository @Inject()(dbConfigProvider: DatabaseConfigProvider) {

  private val db = dbConfigProvider.get[H2Profile].db
  private val serverTableQuery = TableQuery[ServerTable]
  private val serverStatusTableQuery = TableQuery[ServerStatusTable]

  def all: Future[Seq[Server]] = {
    db.run(serverTableQuery.result)
  }

  def list: Future[Seq[(Server, ServerStatus)]] = {
    val query = for {
      (server, serverStatus) <- serverTableQuery
        .join(serverStatusTableQuery)
        .on(_.id === _.serverId)
    } yield (server, serverStatus)
    db.run(query.result)
  }


  def get(id: Long): Future[Option[Server]] = {
    db.run(serverTableQuery.filter(_.id === id).result.headOption)
  }


  def save(server: Server): Future[Int] = {
    db.run(serverTableQuery += server)
  }

  def delete(id: Long): Future[Int] = {
    db.run(serverTableQuery.filter(_.id === id).delete)
  }
}


