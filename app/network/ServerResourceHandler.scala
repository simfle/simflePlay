package network

import javax.inject.{Inject, Singleton}
import play.api.libs.json.{JsValue, Json, Writes}

import scala.concurrent._
import ExecutionContext.Implicits.global

case class ServerStatusResource(id: Long, serverId: Long, amountUsed: Long, maxAmount: Long, intervalSecond: Long)

case class ServerResource(id: Long, name: String, publicHost: String, privateHost: String, publicPort: Int,
                          privatePort: Int, serverStatusResource: ServerStatusResource)


object ServerResource {
  implicit val implicitServers = new Writes[ServerResource] {
    override def writes(server: ServerResource): JsValue = {
      Json.obj(
        "id" -> server.id,
        "name" -> server.name,
        "publicHost" -> server.publicHost,
        "privateHost" -> server.privateHost,
        "publicPort" -> server.publicPort,
        "privatePort" -> server.privatePort,
        "serverStatus" -> Json.obj(
          "id" -> server.serverStatusResource.id,
          "serverId" -> server.serverStatusResource.serverId,
          "amountUsed" -> server.serverStatusResource.amountUsed,
          "maxAmount" -> server.serverStatusResource.maxAmount,
          "intervalSecond" -> server.serverStatusResource.intervalSecond
        )
      )
    }
  }
}

@Singleton
class ServerResourceHandler @Inject()(serverRepository: ServerRepository) {

  def list:Future[Seq[ServerResource]] = {
    serverRepository.list.map(serverList =>
      serverList.map(server =>
        ServerResource(server._1.id, server._1.name,
        server._1.publicHost, server._1.privateHost, server._1.publicPort,
        server._1.privatePort,
        ServerStatusResource(server._2.id, server._2.serverId, server._2.amountUsed,
          server._2.maxAmount, server._2.intervalSecond))
      )
    )
  }
}


