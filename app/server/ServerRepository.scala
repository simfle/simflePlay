package server

import javax.inject.{Inject, Singleton}

import slick.jdbc.H2Profile
import slick.jdbc.H2Profile.api._
import user.{User, UserTable}
import play.api.db.slick.DatabaseConfigProvider

import scala.concurrent.Future


@Singleton
class ServerRepository @Inject()(dbConfigProvider: DatabaseConfigProvider) {

  private val db = dbConfigProvider.get[H2Profile].db
  private val serverTableQuery = TableQuery[ServerTable]

  def all: Future[Seq[Server]] = {
    db.run(serverTableQuery.result)
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


