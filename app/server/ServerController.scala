package server

import javax.inject.{Inject, Singleton}

import play.api.mvc.{AbstractController, ControllerComponents}

@Singleton
class ServerController @Inject()(cc: ControllerComponents)
                                (serverRepository: ServerRepository) extends AbstractController(cc){



  //id 조회
  def get(id : String) = Action {
    Ok(views.html.user("Your new application is ready."))
  }

  //전체 목록 조회
  def get = Action {
    Ok(views.html.user("Your new application is ready."))
  }
}
