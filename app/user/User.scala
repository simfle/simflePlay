package user

import slick.jdbc.H2Profile.api._
import slick.lifted.ProvenShape


case class User(id: Long, firstName: String, lastName: String, mobile: Long, email: String)

class UserTable(tag: Tag) extends Table[User](tag, "USER") {
  def id = column[Long]("id", O.PrimaryKey,O.AutoInc)
  def firstName = column[String]("first_name")
  def lastName = column[String]("last_name")
  def mobile = column[Long]("mobile")
  def email = column[String]("email")
  override def * : ProvenShape[User] = (id, firstName, lastName, mobile, email) <>(User.tupled, User.unapply)
}