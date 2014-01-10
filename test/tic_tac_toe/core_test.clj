(ns tic-tac-toe.core-test
  (:use clojure.test
        tic-tac-toe.core))

(deftest test-printable-board
  (def empty-board [[" ", " ", " " ] [" ", " ", " "] [" ", " ", " "]])
  (def in-progress-board [["X" "X" "O"] ["O" "O" "X"] [" " " " " "]])

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

  (testing "When no one has won"
    (is (not (in-winning-state? in-progress-board))))
  (testing "When someone has won"
    (is (in-winning-state? board-with-x-as-horizontal-winner))
    (is (in-winning-state? board-with-o-as-horizontal-winner))
    (is (in-winning-state? board-with-x-as-vertical-winner))
    (is (in-winning-state? board-with-o-as-vertical-winner))
    (is (in-winning-state? board-with-x-as-diagonal-winner))
    (is (in-winning-state? board-with-x-as-diagonal-winner-2))
    (is (in-winning-state? board-with-o-as-diagonal-winner))
    (is (in-winning-state? board-with-o-as-diagonal-winner-2))))

(= 0 (:fail (run-tests)) (:error (run-tests)))