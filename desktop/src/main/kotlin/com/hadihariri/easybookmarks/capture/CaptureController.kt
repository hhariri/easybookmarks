package com.hadihariri.easybookmarks.capture

import com.hadihariri.easybookmarks.OSXUrl
import com.hadihariri.easybookmarks.showView
import tornadofx.Controller


class CaptureController: Controller() {
    val model: CaptureViewModel by inject()
    val captureView: CaptureView by inject()
    val osxUrl = OSXUrl()

    fun showCapture() {
        model.title.value = osxUrl.chrome().title
        model.url.value = osxUrl.chrome().url
        showView(captureView)
    }
}