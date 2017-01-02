package com.hadihariri.easybookmarks.capture

import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import tornadofx.*


class CaptureView: View("Capture Link") {
    val model : CaptureViewModel by inject()

    override val root = form {
        fieldset {
            field("URL") {
                textfield(model.url)
            }
            field("Category") {
                textfield(model.category)
                requestFocus()
            }
            field("Notes") {
                textarea(model.notes)
            }
        }
    }

}

