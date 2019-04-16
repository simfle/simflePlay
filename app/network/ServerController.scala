package network

import javax.inject.{Inject, Singleton}
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}

import scala.concurrent.ExecutionContext


@Singleton
class ServerController @Inject()(cc: ControllerComponents)
                                (serverRepository: ServerRepository)
                                (serverResourceHandler: ServerResourceHandler)
                                (implicit exec: ExecutionContext)extends AbstractController(cc){

  def list = Action.async {
    serverResourceHandler.list.map(serverResource =>
      Ok(Json.toJson(serverResource))
    )
  }
}
