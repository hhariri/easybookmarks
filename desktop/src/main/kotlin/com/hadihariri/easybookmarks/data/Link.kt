package com.hadihariri.easybookmarks.data

import tornadofx.getProperty
import tornadofx.property

class Link {
    var url: String by property<String>()
    fun urlProperty() = getProperty(Link::url)

    var title: String by property<String>()
    fun titleProperty() = getProperty(Link::title)

    var category by property<String>()
    fun categoryProperty() = getProperty(Link::category)

    var notes by property<String>()
    fun notesProperty() = getProperty(Link::notes)

}