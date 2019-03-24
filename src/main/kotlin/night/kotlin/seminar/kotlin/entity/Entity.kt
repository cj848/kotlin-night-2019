package night.kotlin.seminar.kotlin.entity

data class Order(val id: Long, val user: User, val items: List<OrderItem>) {
    val amount: Long
            get() = items.asSequence().map { it.amount }.sum()
}

data class User(val id: Long, val name: String, val email: String)
data class OrderItem(val id: Long, val name: String, val amount: Long)

fun Order.names(): String {
    return "${user.name}: ${items.joinToString(",") { it.name }}"
}