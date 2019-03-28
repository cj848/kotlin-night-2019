package night.kotlin.seminar.kotlin.lazy

interface ItemReader<T> {
    fun read(): T?
}

class ListItemReader<T>(private val list: List<T>) : ItemReader<T> {
    val iterator: Iterator<T> by lazy {
        println("list 의 iterator가 호출 싯점에 1회만 초기화 됩니다.")
        // 마지막 값이 리턴값으로 자동 추론되며 ^lazy 는 lazy 메소드의 리턴되는 값이라는 표현
        // 물론 return@lazy list.iterator() 로도 대체 가능 inline 메소드라
        // return을 명시적으로 하려면 저런 표현을 해야됨
        list.iterator()
    }

    override fun read(): T? = when {
        iterator.hasNext() -> iterator.next()
        else -> null
    }
}

fun main() {
    val reader = ListItemReader(listOf("아이템1", "아이템2", "아이템3"))

    var item: String?
    do {
        item = reader.read()
        item?.let { println("읽어진 item: $it, ?.let은 값이 null이면 아무 동작 하지 않고 null이 아닌 값을 it으로 표현할 수 있다") }
    } while(item != null)
}