package user

import slick.jdbc.H2Profile.api._
import slick.lifted.ProvenShape


case class User(id: Long, firstName: String, lastName: String, email: String)


//여기서 질의한 쿼리가 User 로 매핑
class UserTable(tag: Tag) extends Table[User](tag, "USER") {
  def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)

  def firstName = column[String]("FIRST_NAME")

  def lastName = column[String]("LAST_NAME")

  def email = column[String]("EMAIL")

  override def * : ProvenShape[User] = (id, firstName, lastName, email) <> (User.tupled, User.unapply)
}