(ns shscrape.scrape
  (:require [org.httpkit.client :as http]))


(def perm-headers {"Host"                      "www.stubhub.com"
                   "User-Agent"                "Mozilla /5.0 (Macintosh ; Intel Mac OS X 10.15; rv:94.0) Gecko/20100101 Firefox/94.0"
                   "Accept"                    "text/html, application/xhtml+xml, application/xml ;q=0.9,image/avif,image/webp,*/*;q=0.8"
                   "Accept-Language"           "en-US, en  ;q=0.5"
                   "Accept-Encoding"           "gzip, deflate, br"
                   "DNT"                       "1"
                   "Connection"                "keep-alive"
                   "Upgrade-Insecure-Requests" "1"
                   "Sec-Fetch-Dest"            "document"
                   "Sec-Fetch-Mode"            "navigate"
                   "Sec-Fetch-Site"            "none"
                   "Sec-Fetch-User"            "?1"})





(comment

  (def stubhub-test-url "https://www.stubhub.com/atlanta-falcons-atlanta-tickets-12-5-2021/event/104828441/")

  @(http/get stubhub-test-url perm-headers)

  )