package davoonic.main.views

import tornadofx.*



class DavoonicMainView: View() {

    override val root = borderpane {
        top<TopView>()
        bottom<BottomView>()
    }
}