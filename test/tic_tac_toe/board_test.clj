(ns tic-tac-toe.board-test
  (:use clojure.test
        tic-tac-toe.board))

(def in-progress-board '[x x o, o o x, - - -])

(deftest test-unplayed?
  (testing "returns true when the index identifies an unplayed spot"
    (is (unplayed? in-progress-board 6))
    (is (not (unplayed? in-progress-board 0)))))

(deftest test-in-winning-state?
  (def board-with-x-as-horizontal-winner '[x x x, - - -, - - -])
  (def board-with-o-as-horizontal-winner '[o o o, - - -, - - -])
  (def board-with-x-as-vertical-winner   '[o o x, - - x, o - x])
  (def board-with-o-as-vertical-winner   '[o o x, o x -, o - x])
  (def board-with-x-as-diagonal-winner   '[x o -, o x -, o - x])
  (def board-with-x-as-diagonal-winner-2 '[- o x, o x -, x - o])
  (def board-with-o-as-diagonal-winner   '[o x -, x o -, x - o])
  (def board-with-o-as-diagonal-winner-2 '[- x o, x o -, o - x])

  (def winning-boards
    [board-with-x-as-horizontal-winner
     board-with-o-as-horizontal-winner
     board-with-x-as-vertical-winner
     board-with-o-as-vertical-winner
     board-with-x-as-diagonal-winner
     board-with-x-as-diagonal-winner-2
     board-with-o-as-diagonal-winner
     board-with-o-as-diagonal-winner-2])

  (testing "When no one has won"
    (is (not (in-winning-state? in-progress-board))))
  (testing "All winning boards are detected"
    (is (= 'x (in-winning-state? board-with-x-as-horizontal-winner)))
    (is (= 'o (in-winning-state? board-with-o-as-horizontal-winner)))
    (is (= 'x (in-winning-state? board-with-x-as-vertical-winner)))
    (is (= 'o (in-winning-state? board-with-o-as-vertical-winner)))
    (is (= 'x (in-winning-state? board-with-x-as-diagonal-winner)))
    (is (= 'x (in-winning-state? board-with-x-as-diagonal-winner-2)))
    (is (= 'o (in-winning-state? board-with-o-as-diagonal-winner)))
    (is (= 'o (in-winning-state? board-with-o-as-diagonal-winner-2)))))

(deftest test-possible-moves
  (testing "Returns locations that have not been played in"
    (is (= [0 1 2] (possible-moves '[- - -, x o x, o x o])))))

(deftest test-move
  (testing "Makes a move"
    (is (= {:board '[x - -, - - -, - - -] :turn 'o}
           (make-move initial-position 0)))))
