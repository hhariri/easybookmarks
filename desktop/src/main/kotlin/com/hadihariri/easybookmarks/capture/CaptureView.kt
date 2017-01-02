package com.hadihariri.easybookmarks.capture

import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import tornadofx.*


class CaptureView: View("Capture Link") {
    val controller: CaptureController by inject()
    var url: TextField by singleAssign()
    var category: TextField by singleAssign()
    var notes: TextArea by singleAssign()

    override val root = form {
        fieldset {
            field("URL") {
                url = textfield(controller.capturedUrl)
            }
            field("Category") {
                category = textfield()
            }
            field("Notes") {
                notes = textarea()
            }
        }
    }

}

