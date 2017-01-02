package com.hadihariri.easybookmarks.urlcapturers

interface UrlCapturer {
    fun getUrl(): UrlInformation
    fun chrome(): UrlInformation
    fun opera(): UrlInformation
    fun omniweb(): UrlInformation
    fun safari(): UrlInformation
    fun webkit(): UrlInformation
    fun ie(): UrlInformation
    fun edge(): UrlInformation
    fun camino(): UrlInformation
}