package davoonic.main.business

import org.opencv.core.Core.*
import org.opencv.core.Mat
import org.opencv.core.Scalar
import org.opencv.highgui.HighGui.imshow
import org.opencv.imgcodecs.Imgcodecs
import org.opencv.imgproc.Imgproc.COLOR_BGR2GRAY
import org.opencv.imgproc.Imgproc.cvtColor

class OCVLogic(private val imageAPath: String, private val imageBPath: String) {

    private lateinit var imageA: Mat
    private lateinit var imageB: Mat
    private lateinit var imageDiff: Mat
    private lateinit var imageMask: Mat
    private lateinit var imageRes: Mat
    private lateinit var compareRes: Mat

    fun loadImage() {
        imageA = Imgcodecs.imread(imageAPath)
        imageB = Imgcodecs.imread(imageBPath)
    }

    fun getDifference() {
        var diff = Mat()
        absdiff(imageA, imageB, diff)
        imageDiff = diff
    }

    fun changeColorSpace() {
        var mask = Mat()
        cvtColor(imageDiff, mask, COLOR_BGR2GRAY)
        imageMask = mask
    }

    fun finalize(threshold: Int): Mat {

        val scalar = Scalar(threshold.toDouble())

        val compRes = Mat()

        compare(imageMask, scalar, compRes, CMP_GE)

        compareRes = compRes

        var res = Mat()

        bitwise_and(imageA, imageB, res, imageMask)

        imageRes = res

        return imageRes

    }


}