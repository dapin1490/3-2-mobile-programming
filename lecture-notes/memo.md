* src-08 인텐트 기말고사에 꼭 한 문제 나옴
* 매니페스트 파일에서 `<category android:name="android.intent.category.LAUNCHER" />` : 이것은 혼자서 호출되고 실행될 수 있는 앱이다. 메인 액티비티에만 있고 서브 액티비티에는 이 속성이 없음.
* 한 액티비티에서 다른 액티비티를 실행시키려면 메니페스트 파일에 미리 선언해둬야 함
* 퍼미션 시험문제에 꼭 하나 나옴 : 매니페스트에 명시된 권한에 대해 요청 후 결과 확인

---

- 3주
  - lecture-notes/src-03_toast+view basic/`toast` : 토스트 예제
  - lecture-notes/src-03_toast+view basic/`view` : 뷰 예제
    - 버튼, 이미지뷰, 텍스트뷰
- 4주
  - lecture-notes/src-04_gravity+layout/`gravity` : `gravity`와 `layout_gravity`
  - lecture-notes/src-04_gravity+layout/`layout` : `base layout`, `horizontal layout`, `relative layout(namecard)`, `layout weight`
- 5주
  - lecture-notes/src-05_inflate+layout manage : `inflation`, `layout parameter`
- 6주
  - lecture-notes/src-06_event+longclick/`event` : 터치 이벤트, 터치 리스너, 핸들러 액세스
  - lecture-notes/src-06_event+longclick/`longclick` : 롱클릭 이벤트
  - test/week06quiz01 : 터치하여 디자인을 토글하는 버튼 만들기
- 7주
  - lecture-notes/src-07_adapters/baseadapter : 베이스어댑터. arraylist와 어댑터 클래스로 각 항목의 뷰 생성하여 화면에 보여줌. 주문 리스트 예시.
  - lecture-notes/src-07_adapters/listactivity1, 2, 3 : list 데이터 사용
  - lecture-notes/src-07_adapters/listview1, 2, 3 : listview로 list 데이터 사용
  - lecture-notes/src-07_adapters/simpleadapter : 맵을 이용하는 심플 어댑터
  - test/week07quiz : 라디오버튼이 달린 리스트 추가/삭제 구현
- 8주
  - lecture-notes/src-08_intent : 인텐트. 액티비티와 액티비티 사이를 오가는 정보를 포함한 신호
  - test/week08midtest/exam1 : 문제 조건에 맞게 레이아웃 빈칸 채우기
  - test/week08midtest/exam2 : 버튼 클릭 리스너 만들기
  - test/week08midtest/exam3 : 주어진 조건에 맞게 베이스어댑터 만들기
- 9주
  - lecture-notes/src-09_데이터관리1 : `SQLiteOpenHelper` 사용해 데이터베이스 다루기
- 10주
  - lecture-notes/src-10_퍼미션 : 권한 허용하기
- 11주
  - test/week11quiz : `SQLiteOpenHelper` 이용해 메모 추가/수정/삭제 구현
- 13주
  - lecture-notes/src-13_커스텀위젯/customwidget1 : 색깔 들어간 텍스트뷰
  - lecture-notes/src-13_커스텀위젯/customwidget2 : 리스트뷰에 사용한 레이블뷰
  - lecture-notes/src-13_커스텀위젯/output : 여러가지 기본 그림 그리기
  - test/week13quiz : 라디오버튼 선택할 때마다 각자 다른 원 그리기
- 14주
  - lecture-notes/src-14_데이터관리2/cp1, 2 : 퍼미션 요청 후 앱 외부 데이터 읽어오기
  - lecture-notes/src-14_데이터관리2/dialog : 다이얼로그 사용하기