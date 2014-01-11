(ns tic-tac-toe.board)

;; v0 - AI plays O and moves randomly; program detects when someone has won
;; v1 - AI plays O and chooses based on minimax
;; v2 - AI plays either side and chooses based on minimax
;; v2 - AI plays either side and uses alpha-beta pruning

;; available-moves [board]
;; in-winning-state? [board]
;; make-move [player board position]
;; play-game (loops until winner)

(defn- same-player? [line]
  (when (and (apply = line)
             (not= '- (first line)))
    (first line)))

(defn- horizontal-winner? [board]
  (some same-player? (partition 3 board)))

(defn- vertical-winner? [board]
  (let [columns (apply map vector (partition 3 board))]
    (some same-player? columns)))

(defn- diagonal-winner? [board]
  (or
    (same-player? (map (partial nth board) '(0 4 8)))
    (same-player? (map (partial nth board) '(2 4 6)))))

(defn in-winning-state? [board]
  (or (horizontal-winner? board)
      (vertical-winner? board)
      (diagonal-winner? board)))

(defn unplayed? [location board]
  (= '- (nth board location)))
