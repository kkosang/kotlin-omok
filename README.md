# kotlin-omok

# 기능 요구 사항

- 오목판이 있다.
    - [ ] 오목판은 각 칸의 위치를 가지고 있다.
    - [ ] 열은 알파벳으로 표시하고, 행은 숫자로 표시한다.
- 두명의 플레이어가 있다.
    - [ ] 흑돌을 가진 플레이어와 백돌을 가진 플레이어가 있다.
    - [ ] 흑돌을 가진 플레이어가 먼저 착수한다.
    - [ ] 돌을 바둑판 위에 원하는 위치로 착수한다.
- 돌이 있다.
    - [x] 흑돌과 백돌로 구분된다.
    - [x] 돌은 바둑판 위의 위치를 가지고 있다.
        - [x] 바둑판의 좌표를 가지고 있다.
        - [x] 좌표는 바둑판의 행 `1에서 15`과 열 `A에서 O`까지이다.
- 승리 조건
    - [ ] 가로나 세로, 대각선으로 다섯 개의 연속된 돌을 먼저 만들면 승리한다.
    - [ ] 6목 이상의 장목도 승리 조건으로 인정된다.

# 사용자 입력

- 돌의 착수 위치를 입력 받는다.
    - [ ] 착수 위치는 열(알파벳) + 행(숫자) 순서로 입력한다.
    - [ ] 착수 위치가 바둑판의 범위를 벗어날 수 없다.
    - [ ] 이미 착수된 위치에 돌을 놓을 수 없다.
    - [ ] 착수할 수 없는 위치를 입력하면 다시 입력 받는다.