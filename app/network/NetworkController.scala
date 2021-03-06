package network

import javax.inject.{Inject, Singleton}
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}

import scala.concurrent.ExecutionContext


@Singleton
class NetworkController @Inject()(cc: ControllerComponents)
                                 (serverResourceHandler: ServerResourceHandler)
                                 (implicit exec: ExecutionContext)extends AbstractController(cc){

  def list = Action.async {
    serverResourceHandler.list.map(serverResource =>
      Ok(Json.toJson(serverResource))
    )
  }
}
