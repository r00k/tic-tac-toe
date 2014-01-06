(ns tic-tac-toe.core)

;; v0 - AI plays O and moves randomly; program detects when someone has won
;; v1 - AI plays O and chooses based on minimax
;; v2 - AI plays either side and chooses based on minimax
;; v2 - AE plays either side and uses alpha-beta pruning

;; available-moves [board]
;; in-winning-state? [board]
;; make-move [player board position]
;; play-game (loops until winner)

(def empty-board [[" ", " ", " "]
                  [" ", " ", " "]
                  [" ", " ", " "]])

(clojure.string/join (flatten empty-board))

(flatten empty-board)

(defn make-printable-board [board]
  (clojure.string/join "\n-----\n"
                       (map (partial clojure.string/join "|") board)))

(defn- horizontal-winner? [board]
  (let [joined (map clojure.string/join board)]
    (some (partial re-find #"XXX|OOO") joined)))

(defn in-winning-state? [board]
  (or (horizontal-winner? board)))


