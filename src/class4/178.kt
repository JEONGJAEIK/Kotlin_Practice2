package class4

// 이 클래스는 열려있다.
open class RichButton : Clickable {
    fun disable() { /* ... */ } // 이 함수는 파이널이다. 하위 클래스가 오버라이드 못 함
    open fun animate() { /* ... */ } // 이 함수는 열려있다. 하위 클래스에서 오버라이드 가능
    override fun click() { { /* ... */ } } // 이 함수는 열려있는 메서드를 오버라이드하며 열려있다.
    // click은 final 붙이면 닫힌다. 중복은 아니다 파이널이 없는 오버라이드 메서드나 프로퍼티는 기본적으로 열려있다.
}

class ThemedButton : RichButton() { // disable이 파이널이기 때문에 오버라이드가 불가능
    override fun animate() {} // 명시적으로 열려있기 때문에 오버라이드 가능
    override fun click() {} // RichButton이 click을 명시적으로 파이널로 지정하지 않았기 때문에 click 오버라이드 가능
    override fun showOff() {} // RichButton이 showOff을 오버라이드하지 않았지만 여기서는 가능
}

abstract class Animated { // 추상 클래스는 인스턴스를 만들 수 없다. 추상 멤버는 항상 열려있어서 open을 명시하지 않아도 된다.
    abstract val animationSpeed: Double // 추상 프로퍼티는 프로퍼티에 갑이 없고 하위 클래스는 반드시 값이나 접근자를 제공해야 함
    val keyframes: Int = 20 // 추상이 아닌 프로퍼티는 기본적으로 열려있지 않다
    open val frames: Int = 60 // open으로 지정도 가능하다

    abstract fun animate() // 추상 함수다 구현이 없고 하위 클래스는 반드시 오버라이드 해야 함
    open fun stopAnimating() {} // 추상이 아닌 함수는 기본적으로 닫혀있다. 그런데 open으로 지정도 가능하다
    fun animateTwice() {}
}