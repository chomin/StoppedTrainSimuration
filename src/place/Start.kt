package place

import agent.Bus
import agent.Person
import java.awt.Color
import java.awt.Graphics2D
import java.awt.Point

class Start(override var point: Point) : Node {

    override var name = "塚口（阪急）"
    override var ways = ArrayList<Way>()
    override val people = ArrayList<Person>()

    override fun generateVehicles() {
        val roads = ways.filter { it is Roadway }.map { it as Roadway }
        for (road in roads) {
            if (road.vehicles[0].size < road.cellMaxAgents){
                // 乗る人を決め、バスを出発させる
                road.vehicles[0].add(Bus())
            }
        }
    }

    override fun checkAllAgents() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun drawSelf(g: Graphics2D) {
        super.drawSelf(g)
        val radius = 20
        g.color = Color.BLUE
        g.fillOval(point.x-radius, point.y-radius, radius*2, radius*2)
    }

}