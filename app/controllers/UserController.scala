package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents}

@Singleton
class UserController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  //User Controller 시작.
  def index = Action {
    Ok(views.html.user("Your new application is ready."))
  }

  def user(id : Long) = Action {
    Ok(views.html.user("Your new application is ready."))
  }
}
