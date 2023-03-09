# kotlin-blackjack

- 카드
    - 카드는 숫자와 모양을 갖는다.
- 카드덱
    - [x] 카드 52장을 만든다.
    - [x] 카드 한장을 뽑고 삭제한다.

- 사람
    - 공통
        - [x] 이름을 갖는다.
        - [x] 카드 모음을 갖는다.
        - [x] 게임 상태를 갖는다. (default : Hit)
        - [x] 상태가 Hit 이면 카드를 한장 더 받는다.
        - [x] 가지고 있는 카드의 총합을 구한다. (에이스 : 버스트면 1, 그렇지 않으면 11 )
    - Player
        - [x] 총합이 21 초과면 Bust 상태가 된다. (A를 1로 간주)
        - [x] 그만 받고 싶으면 stand 상태가 된다.
    - Dealer
        - [x] 총합이 16 이하면 한장 더 받는다.
        - [x] 카드 중에 하나만 보여준다.

- 게임 결과
    - [x] 사람 모두를 갖는다.
    - [x] 딜러와 플레이어의 숫자를 비교한다. (21에 가까운 사람이 이긴다)
        - [x] 플레이어가 Bust 이면 무조건 패배
        - [x] 숫자가 같으면 무승부이다.

- view
    - [x] OnBoardingView
        - [x] 플레이어 이름을 입력받는다.
        - [x] 처음 받은 카드를 공개한다.
    - [x] MainView
        - [x] 더 받을지 말지 선택한다.
        - [x] 카드를 더 받으면 카드 모음을 공개한다.
    - [x] ResultView
        - [x] 최종 카드 모음과 총합을 공개한다.
        - [x] 최종 승패를 출력한다.
