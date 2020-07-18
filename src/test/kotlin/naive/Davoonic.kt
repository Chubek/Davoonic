package naive

import davoonic.main.business.OCVLogic
import nu.pattern.OpenCV
import org.opencv.imgcodecs.Imgcodecs

fun main() {
    OpenCV.loadShared()

    val imageAPath = "./src/test/resources/imageA.png"
    val imageBPath = "./src/test/resources/imageB.png"

    val ocvLogic = OCVLogic(imageAPath, imageBPath)

    ocvLogic.loadImage()
    ocvLogic.getDifference()
    ocvLogic.changeColorSpace()

    Imgcodecs.imwrite("./src/test/resources/imageRes.png", ocvLogic.finalize(1))
}