package night.kotlin.seminar.kotlin.entity.builder

class Order {
    var id: Long? = null
    var user: User? = null
    var items: List<OrderItem> = listOf()
    val amount: Long
        get() = items.asSequence().map { it.amount ?: 0 }.sum()
}

class User {
    var id: Long? = null
    var name: String? = null
    var email: String? = null
}

class OrderItem {
    var id: Long? = null
    var name: String? = null
    var amount: Long? = null
}