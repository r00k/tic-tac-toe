(ns tic-tac-toe.core)

;; v0 - AI plays O and moves randomly; program detects when someone has won
;; v1 - AI plays O and chooses based on minimax
;; v2 - AI plays either side and chooses based on minimax
;; v2 - AI plays either side and uses alpha-beta pruning

;; available-moves [board]
;; in-winning-state? [board]
;; make-move [player board position]
;; play-game (loops until winner)

(defn make-board [string-rep]
  "Accepts a string representation of a board and returns a board"
  (partition 3 (into [] string-rep)))

(defn make-printable-board [board]
  (clojure.string/join "\n-----\n"
                       (map
                         (partial clojure.string/join "|")
                         board)))

(defn- horizontal-winner? [board]
  (let [joined (map clojure.string/join board)]
    (some (partial re-find #"XXX|OOO") joined)))

(defn- vertical-winner? [board]
  (let [columns (apply mapv vector board)
        joined-columns (map clojure.string/join columns)]
    (some (partial re-find #"XXX|OOO") joined-columns)))

(defn- diagonal1 [board]
  (for [x (range 3)]
    (nth (nth board x) x)))

(defn diagonal2 [board]
  (list (nth (nth board 0) 2)
        (nth (nth board 1) 1)
        (nth (nth board 2) 0)))

(defn- diagonal-winner? [board]
  (or (= '("X" "X" "X") (diagonal1 board))
      (= '("X" "X" "X") (diagonal2 board))
      (= '("O" "O" "O") (diagonal1 board))
      (= '("O" "O" "O") (diagonal2 board))))

(defn in-winning-state? [board]
  (or (horizontal-winner? board)
      (vertical-winner? board)
      (diagonal-winner? board)))


