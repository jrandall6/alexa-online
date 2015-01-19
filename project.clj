(defproject allgress/alexa-online "0.2.0-SNAPSHOT"
            :description "Allgress Alexa Online."
            :url "https://github.com/allgress/alexa-online"
            :scm {:url "https://github.com/allgress/alexa-online"}
            :license {:name "(c) 2015 Allgress Inc."
                      :url "http://www.allgress.com"}

            :plugins [[s3-wagon-private "1.1.2"]]

            :dependencies [[org.clojure/clojure "1.7.0-alpha5"]
                           [org.clojure/clojurescript "0.0-2629"]
                           [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                           [org.clojure/core.match "0.2.2"]
                           [com.cemerick/clojurescript.test "0.3.1"]
                           [prismatic/schema "0.3.3"]
                           [datascript "0.7.2"]
                           [instar "1.0.10"]
                           [clj-http "1.0.1"]
                           [allgress/web-components "0.9.4"]
                           [allgress/core-components "0.2.6"]
                           [allgress/aurora-schema "0.2.0"]
                           [allgress/util "0.1.1"]
                           [allgress/lunrscript "0.2.3"]
                           [allgress/transaction-manager "0.1.0"]]

            :repositories [["s3" {:url           "s3p://aurora-repository/releases/"
                                  :username      :env/aws_key
                                  :passphrase    :env/aws_secret
                                  :sign-releases false}]
                           ["my.datomic.com" {:url "https://my.datomic.com/repo"
                                              :username :env/datomic_username
                                              :password :env/datomic_password}]])
