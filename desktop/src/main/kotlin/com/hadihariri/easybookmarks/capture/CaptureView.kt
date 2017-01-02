package com.hadihariri.easybookmarks.capture

import tornadofx.*


class CaptureView : View("Capture Link") {
    val model: CaptureViewModel by inject()

    override val root = form {
        fieldset {
            field("Title") {
                textfield(model.title)
            }
            field("URL") {
                textfield(model.url)
            }
            field("Category") {
                textfield(model.category) {
                    whenDocked {
                        requestFocus()

                    }
                }
            }
            field("Notes") {
                textarea(model.notes)
            }
        }
    }

}

