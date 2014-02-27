(ns tic-tac-toe.board)

;; v0 - AI plays O and moves randomly; program detects when someone has won
;; v1 - AI plays O and chooses based on minimax
;; v2 - AI plays either side and chooses based on minimax
;; v2 - AI plays either side and uses alpha-beta pruning

(def initial-position {:board '[- - -, - - -, - - -] :turn 'x})

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

(defn possible-moves [board]
  (keep-indexed (fn [idx item] (if (= item '-) idx)) board))

(defn make-move [{:keys [board turn]} idx]
  { :board (assoc board idx turn) :turn (if (= turn 'x) 'o 'x) })
