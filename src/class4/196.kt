package class4

import java.net.URI

open class Downloader2 {
    constructor(url: String?) {
        // something
    }

    constructor(uri: URI?) {
        // something
    }
}

class MyDownloader : Downloader2 {
    constructor(url: String?) : this(URI(url))
    constructor(uri: URI?) : super(uri)
}