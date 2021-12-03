(ns shscrape.scrape
  (:require [org.httpkit.client :as http]
            [net.cgrand.enlive-html :as html]))



(def falcons-search-url "https://www.stubhub.com/atlanta-falcons-tickets/performer/6044/")
(def falcons-search-url-escaped "https://www.stubhub.com/bfx/api/search/suggest/v3?term%3Datlanta%20falcons%26sort%3Dpopularity%20desc%2C%20eventDateLocal%20asc%2C%26perfRows%3D5%26entityList%3Devent%2Cperformer%2Cvenue%26minAvailableTickets%3D0%26includeNoneventEntities%3Dtrue%26shstore%3D1%26point%3D33.9526%2C-84.54993%26radius%3D200%26lang%3Dtrue%26urgencyMessaging%3Dtrue%26geoExpansion%3Dtrue%26timeZoneOffsetInMinutes%3D300%26withEventCount%3Dtrue%26enablePopular%3Dfalse")


(def basic-opts {:user-agent "Mozilla /5.0 (Macintosh ; Intel Mac OS X 10.15; rv:94.0) Gecko/20100101 Firefox/94.0"
                 :headers    {"Host"            "www.stubhub.com"
                              "User-Agent"      "Mozilla /5.0 (Macintosh ; Intel Mac OS X 10.15; rv:94.0) Gecko/20100101 Firefox/94.0"
                              "Accept"          "*/*"
                              ;"Accept-Language"           "en-US, en  ;q=0.5"
                              "Accept-Encoding" "gzip, deflate, br"
                              ;"DNT"                       "1"
                              ;"Connection"                "keep-alive"
                              ;"Upgrade-Insecure-Requests" "1"
                              ;"Sec-Fetch-Dest"            "document"
                              ;"Sec-Fetch-Mode"            "navigate"
                              ;"Sec-Fetch-Site"            "none"
                              ;"Sec-Fetch-User"            "?1"
                              }})

(defn scrape-url-as-dom
  "Blocking call to get a URL as EDN. Not idempotent"
  [url]
  (-> @(http/get url basic-opts)
      :body
      (html/html-snippet)))

(defn dom->event-url-strs
  [dom]
  ["" ""]

  )


(comment

  (do (def stubhub-test-url "https://www.stubhub.com/atlanta-falcons-atlanta-tickets-12-5-2021/event/104828441/")

      (def stubhub-test-url "http://www.stubhub.com/")
      #_(def stubhub-test-url "http://localhost:9100/somehting/")


      (def cached-dom (scrape-url-as-dom falcons-search-url))

      (->> (html/select cached-dom [:a.EventItem__TitleLink])
           (map (fn [data] (get-in data [:attrs :href])))))


  (-> falcons-search-url
      scrape-url-as-dom
      dom->event-url-strs)


  (+ 1 2 3 (+ 2 3 4 5 + (1 2 (+ 1 3 4 1) 2 3) 4 1 2) 3 4)


  @(http/get "https://www.google.com" {})

  )