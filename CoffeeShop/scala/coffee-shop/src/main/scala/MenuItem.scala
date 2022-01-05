case class MenuItem(name: String, item_type: Enums.ItemType, price: Double) {
	override def toString(): String = {
		return s"${this.name}, type: ${this.item_type}, price: ${this.price}"
	}
}