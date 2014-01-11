(ns tic-tac-toe.io
  (:require [clojure.string :refer [join]]
            [tic-tac-toe.board :refer [unplayed?]]))

(defn- format-index [idx] (format " %x " idx))
(defn- format-move [move] (format " %s " move))

(defn render [board]
  (str (->> board
            (map-indexed (fn [idx location] (if (unplayed? idx board)
                                              (format-index idx)
                                              (format-move location))))
            (partition 3)
            (map (partial join "|"))
            (interpose "-----------")
            (join "\n"))
       "\n"))
