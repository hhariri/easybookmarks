package com.hadihariri.easybookmarks.about

import com.hadihariri.easybookmarks.AppSettings
import javafx.beans.property.SimpleIntegerProperty
import javafx.geometry.Pos
import javafx.scene.layout.BorderPane
import javafx.scene.text.TextAlignment
import tornadofx.*

class AboutView : View("About") {
    val controller: AboutController by inject()
    override val root = borderpane {
        setPrefSize(200.0, 100.0)
        style {
            padding = tornadofx.box(20.px)
        }
        top {
            label("Version: ${AppSettings.version}") {
                style {
                    textAlignment = javafx.scene.text.TextAlignment.CENTER
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
