package network

import javax.inject.Inject
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._

class NetworkRouter @Inject()(networkController: NetworkController) extends SimpleRouter {
  override def routes: Routes = {
    case GET(p"/") => networkController.list
  }
}
