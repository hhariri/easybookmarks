package com.hadihariri.easybookmarks.capture

import com.hadihariri.easybookmarks.data.Link
import sun.awt.image.ImageWatched
import tornadofx.ItemViewModel


class CaptureViewModel : ItemViewModel<Link>() {
    val url = bind { item?.urlProperty() }
    val title = bind { item?.titleProperty() }
    val category = bind { item?.categoryProperty() }
    val notes = bind { item?.notesProperty() }
}