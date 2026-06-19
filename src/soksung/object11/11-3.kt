package soksung.object11

// val userMap: MutableMap<String, List<Pair<Product, Int>>> = mutableMapOf()
// fun setOnClickListener(listener: (View, MotionEvent) -> Boolean) { }

// 타입이 넘 길다
// typealias는 기존 타입에 이름을 부여함 컴파일러는 이 별칭을 실제 원래 타입으로 대체하여 처리
// typealias 별칭이름 = 원래타입

// typealias CartItem = Pair<Product, Int>
// typealias UserCart = MutableMap<String, List<CartItem>>
// val userCart: UserCart = mutableMapOf()
// 읽기 쉬워짐

// 함수 타입에 별칭
// typealias OnClickListener = (View, MotionEven) -> Boolean

// fun setOnClickListener(listener: OnClickListener) {}

// 람다를 변수에 담을때도 유용
// val myListener: OnClickListener = { view, event ->
//    true
// }
