package network

import javax.inject.Inject
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._

class NetworkRouter @Inject()(serverController: ServerController) extends SimpleRouter {
  val prefix = "/network"
  override def routes: Routes = {
    case GET(p"/") => serverController.list
    //case GET(p"/${long(id)}") => userController.get(id)
  }
}
