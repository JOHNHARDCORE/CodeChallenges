object Main {
  def main(args: Array[String]) {
    val c = new CoffeeShop(
      "Roffee Coasters",
      List[MenuItem](
        MenuItem("coffee", Enums.Drink, 20.0),
        MenuItem("mountain dew \"Dew S A\" limited edition", Enums.Drink, 5.0),
        MenuItem("donut", Enums.Food, 1.75),
        MenuItem("bagel", Enums.Food, .5),
        MenuItem("cronut", Enums.Food, 275.5)
      )
    )

    println(c.addOrder("coffee"))
    println(c.addOrder("donut"))
    println(c.addOrder("donut"))
    println(c.addOrder("cronut"))
    println(c.addOrder("coffee"))

    println(s"Cheapest item: ${c.cheapestItem()}")
    println("Food Only: ")
    c.foodOnly().foreach(println)
    println("Drinks Only: ")
    c.drinksOnly().foreach(println)

    println(s"Orders:\n${c.listOrders()}")
    println(s"Due Amount: ${c.dueAmount()}")

    println(s"${c.fulfillOrder()}")

    println(s"Orders:\n${c.listOrders()}")
    println(s"Due Amount: ${c.dueAmount()}")

  }
}