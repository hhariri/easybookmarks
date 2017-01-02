package com.hadihariri.easybookmarks

import tornadofx.getProperty
import tornadofx.property

class Link() {
    var url: String by property<String>()
    fun urlProperty() = getProperty(Link::url)

    var category by property<String>()
    fun categoryProperty() = getProperty(Link::category)

    var notes by property<String>()
    fun notesProperty() = getProperty(Link::notes)

}