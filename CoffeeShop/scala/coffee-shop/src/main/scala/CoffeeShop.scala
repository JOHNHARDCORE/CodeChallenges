import collection.mutable.Queue

class CoffeeShop(private var name: String, private var menu: List[MenuItem] = List[MenuItem](), private var orders: Queue[MenuItem] = Queue[MenuItem]()) {
	def addOrder(new_item: String): String = {
		val item = this.menu
			.find(item => item.name == new_item)
		
		return item match {
			case Some(res) => this.orders.enqueue(res); s"Added item ${res.name} to your order"
			case None => s"This item ${new_item} is unavailable!" 
		}
	}

	def fulfillOrder(): String = {
		return this.orders.removeHeadOption() match {
			case Some(res) => s"The ${res.name} is ready!"
			case None => s"All orders have been fulfilled!"
		}
	}

	def listOrders(): String = {
		this.orders.mkString("\n")
	}

	def dueAmount(): Double = {
		this.orders
			.map(item => item.price)
			.sum
	}


	def addItem(name: String, item_type: Enums.ItemType, price: Double) { this.menu = this.menu.appended(MenuItem(name, item_type, price))}
	def cheapestItem(): MenuItem = { this.menu.reduce((lowest, item) => if (item.price < lowest.price) item else lowest) }
	def foodOnly(): List[MenuItem] = { this.menu.filter(item => item.item_type == Enums.Food) }
	def drinksOnly(): List[MenuItem] = { this.menu.filter(item => item.item_type == Enums.Drink) }
}