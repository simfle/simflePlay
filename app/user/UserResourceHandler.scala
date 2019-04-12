package user

import javax.inject.{Inject, Singleton}
import play.api.libs.json.{JsValue, Json, Writes}

import scala.concurrent._
import ExecutionContext.Implicits.global

case class UserResource(id: Long, firstName: String, lastName: String, email: String)

object UserResource {
  implicit val implicitUsers = new Writes[UserResource] {
    override def writes(user: UserResource): JsValue = {
      Json.obj(
        "id" -> user.id,
        "firstName" -> user.firstName,
        "lastName" -> user.lastName,
        "email" -> user.email
      )
    }
  }
}


@Singleton
class UserResourceHandler @Inject()(userRepository: UserRepository) {
  def list = {
    userRepository.all.map(userList =>
      userList.map(user =>
        UserResource(user.id, user.firstName, user.lastName, user.email))
    )
  }
}


