package user

import javax.inject.{Inject, Singleton}

import slick.jdbc.H2Profile
import slick.jdbc.H2Profile.api._
import play.api.db.slick.DatabaseConfigProvider

import scala.concurrent.Future

@Singleton
class UserRepository @Inject()(dbConfigProvider: DatabaseConfigProvider) {

  private val db = dbConfigProvider.get[H2Profile].db
  private val userTableQuery = TableQuery[UserTable]

  def all: Future[Iterable[User]] = {
    db.run(userTableQuery.result)
  }

  def get(id: Long) : Future[Option[User]] = {
    db.run(userTableQuery.filter(_.id === id).result.headOption)
  }

  def save(user: User) : Future[Int] = {
    db.run(userTableQuery += user)
  }

  def update(id: Long, firstName: String): Future[Int] = {
    val updateQuery = userTableQuery.filter(_.id === id)
      .map(user => user.firstName)
      .update(firstName)
    db.run(updateQuery)
  }

  def delete(id: Long): Future[Int] = {
    db.run(userTableQuery.filter(_.id === id).delete)
  }

  def insertUsers(users: Seq[User]): Future[Option[Int]] = {
    db.run(userTableQuery ++= users)
  }
}
