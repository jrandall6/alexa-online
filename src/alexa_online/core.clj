(ns alexa-online.core
  (:require [clj-http.client :as client])
  )

(def onlineroot "http://jon-office/AllgressOnline5/")
(def servicepath (str onlineroot "AlexaOnlineDataService.svc/session/") )
(def allgress_username "GWas")
(def allgress_password "Wash")


(let [my-cs (clj-http.cookies/cookie-store)]
  (client/post (str onlineroot "Login.aspx") {:form-params {:UserName allgress_username
                                                      :Password allgress_password}
                                        :cookie-store my-cs}
               (println my-cs))

  (defn get_menu_data []
    (client/post (str servicepath "GetMenuData") {:body ""
                                           :cookie-store my-cs})
    )

  (defn get_task_list [task_filter_args]
    (client/post (str servicepath "GetTaskData") {:body task_filter_args
                                                :cookie-store my-cs})
    )
 )


(println get_menu_data)
