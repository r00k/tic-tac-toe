(ns tic-tac-toe.board-test
  (:use clojure.test
        tic-tac-toe.board))

(def in-progress-board [["X" "X" "O"] ["O" "O" "X"] [" " " " " "]])

(deftest test-printable-board
  (def empty-board [[" ", " ", " " ] [" ", " ", " "] [" ", " ", " "]])

  (testing "Printing an empty board"
    (is (= " | | \n-----\n | | \n-----\n | | "
           (make-printable-board empty-board))))
  (testing "Printing a board with moves"
    (is (= "X|X|O\n-----\nO|O|X\n-----\n | | ")
        (make-printable-board in-progress-board))))

(deftest test-in-winning-state?
  (def board-with-x-as-horizontal-winner [["X" "X" "X"] ["" "" ""] ["" "" ""]])
  (def board-with-o-as-horizontal-winner [["O" "O" "O"] ["" "" ""] ["" "" ""]])
  (def board-with-x-as-vertical-winner [["O" "O" "X"] ["" "" "X"] ["O" "" "X"]])
  (def board-with-o-as-vertical-winner [["O" "O" "X"] ["O" "X" ""] ["O" "" "X"]])
  (def board-with-x-as-diagonal-winner [["X" "O" " "] ["O" "X" ""] ["O" "" "X"]])
  (def board-with-x-as-diagonal-winner-2 [[" " "O" "X"] ["O" "X" ""] ["X" " " "O"]])
  (def board-with-o-as-diagonal-winner [["O" "X" " "] ["X" "O" ""] ["X" "" "O"]])
  (def board-with-o-as-diagonal-winner-2 [[" " "X" "O"] ["X" "O" ""] ["O" " " "X"]])

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
    (is (every? in-winning-state? winning-boards))))