(ns hello-world.core
  (:require
   #_[om.core :as om :include-macros true]
   [sablono.core :as sab :include-macros true]
   [devcards.core]
   [cljs.test :as t :include-macros true :refer-macros [testing is]])
  (:require-macros
   [devcards.core :as dc :refer [defcard deftest]]))

(enable-console-print!)

(defcard first-card
  (sab/html [:div
             [:h1 "This is my first devcard!"]]))

(defn square-range [& args] (map #(* % %) (apply range args)))

(defcard square-range
  "Here's an output of `(square-range)`"
  (square-range 0 10 2))

(deftest square-range-test
  (testing "square version of clojure.core/range")
    (is (= (square-range 0 10 2)
           '(0 4 16 36 64))))

(defn main []
  ;; conditionally start the app based on whether the #main-app-area
  ;; node is on the page
  (if-let [node (.getElementById js/document "main-app-area")]
    (js/React.render (sab/html [:div "This is working"]) node)))

(main)

;; remember to run lein figwheel and then browse to
;; http://localhost:3449/cards.html

;; M-x cider-jack-in
;; (use 'figwheel-sidecar.repl-api)
;; (start-figwheel!)
;; (cljs-repl)
