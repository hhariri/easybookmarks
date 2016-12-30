package com.hadihariri.easybookmarks.about

import com.hadihariri.easybookmarks.AppSettings
import javafx.beans.property.SimpleIntegerProperty
import javafx.geometry.Pos
import javafx.scene.layout.BorderPane
import javafx.scene.text.TextAlignment
import tornadofx.*

class AboutView : View() {
    val controller: AboutController by inject()
    override val root = BorderPane()

    init {
        title = "About"
        with(root) {
            title = "About"
            setPrefSize(200.0, 100.0)
            style {
                padding = box(20.px)
            }
            top {
                label("Version: ${AppSettings.version}") {
                    style {
                        textAlignment = TextAlignment.CENTER
                        fontSize = 12.px
                    }
                }
            }
            center {
                button("Close").setOnAction {
                    controller.close()
                }
            }
        }
    }
}