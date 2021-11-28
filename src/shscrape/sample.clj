(ns shscrape.sample
  (:require [net.cgrand.enlive-html :as html]))




(defn site-as-edn
  [url-str]
  (html/html-resource (java.net.URL. url-str)))

(defn abs-links-from-site
  [site-m]
  (->> (html/select site-m [:td.title :a])
       (map (fn [m] (get-in m [:attrs :href])))
       (filter (fn [s] (.startsWith s "https")))))



(comment

  (def hacker-news-url "https://news.ycombinator.com/")

  (do (def sample-urls (take 10
                             (-> hacker-news-url
                                 site-as-edn
                                 abs-links-from-site)))
      sample-urls)
  #_=> '("https://www.trtworld.com/magazine/indian-academics-throw-weight-behind-sci-hub-and-libgen-in-landmark-case-51780"
          "https://yanmaani.github.io/proof-of-stake-is-a-scam-and-the-people-promoting-it-are-scammers/"
          "https://www.npr.org/2021/11/26/1059413217/crypto-enthusiasts-want-to-buy-an-nba-team-after-failing-to-purchase-us-constitu"
          "https://www.youtube.com/watch?v=IH0GXWQDk0Q"
          "https://julianogtz.github.io/my-personal-blog/posts/five-books-that-changed-my-career-as-a-software-engineer/"
          "https://www.collabora.com/news-and-blog/blog/2021/11/26/venus-on-qemu-enabling-new-virtual-vulkan-driver/"
          "https://blog.michaeldresser.io/posts/2021-11-27_how-to-parse-eve-chat-log.html"
          "https://godotengine.org/article/multiplayer-changes-godot-4-0-report-4"
          "https://alexsaveau.dev/blog/performance/files/kernel/the-fastest-way-to-copy-a-file"
          "https://www.ycombinator.com/companies/terra/jobs/EWMMj0v-full-stack-developer-graduate")

