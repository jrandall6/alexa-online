(set-env!
  :source-paths #{"src" "test"}
  :resource-paths #{"src" "test"}
  :wagons '[[s3-wagon-private "1.1.2"]]
  :repositories [["clojars" "http://clojars.org/repo/"]
                 ["maven-central" "http://repo1.maven.org/maven2/"]
                 ["s3" {:url "s3p://aurora-repository/releases/" :username (System/getenv "AWS_KEY") :passphrase (System/getenv "AWS_SECRET")}]
                 ["my.datomic.com" {:url "https://my.datomic.com/repo"
                                    :username (System/getenv "DATOMIC_USERNAME")
                                    :password (System/getenv "DATOMIC_PASSWORD")}]]
  :dependencies '[[adzerk/boot-cljs "0.0-2629-4" :scope "test"]
                  [adzerk/boot-cljs-repl "0.1.7" :scope "test"]
                  [adzerk/boot-reload "0.2.3" :scope "test"]
                  [pandeiro/boot-http "0.4.2" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.0"]
                  [boot-deps "0.1.3"]
                  [jeluard/boot-notify "0.1.1" :scope "test"]
                  [prismatic/schema "0.3.3"]
                  [allgress/boot-tasks "0.1.8" :scope "test"]
                  [clj-http "1.0.1"]])

(require
  '[adzerk.boot-cljs :refer :all]
  '[adzerk.boot-cljs-repl :refer :all]
  '[adzerk.boot-reload :refer :all]
  '[allgress.boot-tasks :refer :all]
  '[pandeiro.boot-http :refer :all]
  '[cljsjs.boot-cljsjs :refer :all]
  '[jeluard.boot-notify :refer :all])

(set-project-deps!)

(default-task-options!)

(deftask web-dev
         "Developer workflow for web-component UX."
         []
         (comp
           (asset-paths :asset-paths #{"html" "bower_components"})
           (serve :dir "target/")
           (from-cljsjs)
           (watch)
           #_(notify)
           (speak)
           (reload)
           (cljs-repl)
           (cljs)))

