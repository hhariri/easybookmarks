package com.hadihariri.easybookmarks.urlcapturers

sealed class UrlInformation {
    class Success(val url: String, val title: String) : UrlInformation()
    class Error(val message: String) : UrlInformation()
}