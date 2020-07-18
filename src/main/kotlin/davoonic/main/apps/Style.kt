import javafx.scene.paint.Color
import tornadofx.*

class Style: Stylesheet() {

    companion object {
        val tackyButton by cssclass()

        private val topColor = Color.RED
        private val rightColor = Color.DARKGREEN
        private val leftColor = Color.ORANGE
        private val bottomColor = Color.PURPLE
    }

    init {
        tackyButton {
            rotate = 10.deg
            borderColor += box(topColor,rightColor,bottomColor,leftColor)
            fontFamily = "Comic Sans MS"
            fontSize = 20.px
        }
    }
}