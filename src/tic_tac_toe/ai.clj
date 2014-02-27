(ns tic-tac-toe.ai
  (:require [tic-tac-toe.board :refer :all]))

(defn- choose [turn a b] (if (= 'x turn) a b))

(defn minimax [{:keys [turn board] :as position}]
  (let [moves (possible-moves board)]
    (cond
      (= 'x (in-winning-state? board)) 100
      (= 'o (in-winning-state? board)) -100
      (empty? moves) 0
      :else ((choose turn + -)
             (apply (choose turn max min)
                    (map #(minimax (make-move position %)) moves))
             (count moves)))))
