package com.hadihariri.easybookmarks.capture

import com.hadihariri.easybookmarks.Link
import com.hadihariri.easybookmarks.OSXUrl
import com.hadihariri.easybookmarks.showView
import tornadofx.Controller
import tornadofx.singleAssign


class CaptureController: Controller() {

    val captureView: CaptureView by inject()
    var capturedUrl: String = ""
    val osxUrl = OSXUrl()

    fun showCapture() {
        capturedUrl = osxUrl.chromeUrl()
        showView(captureView)
        captureView.category.requestFocus()

    }
}