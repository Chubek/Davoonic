package davoonic.main


import davoonic.main.apps.DavoonicMainApp
import nu.pattern.OpenCV
import tornadofx.launch

fun main(args: Array<String>) {
    OpenCV.loadShared()
    launch<DavoonicMainApp>(args)
}