package user

import javax.inject.{Inject, Singleton}

import play.api.mvc.{AbstractController, ControllerComponents}

@Singleton
class UserController @Inject()(cc: ControllerComponents)
                              (userRepository: UserRepository) extends AbstractController(cc) {

  def index = Action {
    Ok(views.html.user("Your new application is ready."))
  }

  def get(id: Long) = Action {
    Ok(views.html.user("Your new application is ready."))
  }
}
