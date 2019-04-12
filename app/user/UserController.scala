package user

import akka.actor.ActorSystem
import javax.inject.{Inject, Singleton}
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent._

@Singleton
class UserController @Inject()(cc: ControllerComponents, actorSystem: ActorSystem)
                              (userRepository: UserRepository)
                              (userResourceHandler: UserResourceHandler)
                              (implicit exec: ExecutionContext) extends AbstractController(cc) {

  def index = Action {
    Ok(views.html.user("Your new application is ready."))
  }

  def get(id: Long) = Action {
    Ok(views.html.user("Your new application is ready."))
  }

  def list = Action.async {
    userResourceHandler.list.map(userResource =>
      Ok(Json.toJson(userResource))
    )
  }
}
