### 1. 웹 프로그래밍을 위한 프로그램 언어들

저급언어 - 기계 중심의 언어
기계어 - 2진수로 이루어진 값으로 작성하는 프로그래밍 언어

- 숫자로만 되어있기 때문에 유지보수 어려움
- 숫자로 된 문장과 1:1 대응 기호 만듦 -> 프로그래밍
- 이 과정에서 사용되는 도구 -> 컴파일러
- 기호로 작성된 언어 => 어셈블리어

고급언어  - 사람 중심의 언어
- 작성된 소스코드 번역 -> 컴파일!(컴파일러)
- 컴퓨터 성능이 좋아지고, 컴파일러와 관련된 기술이 발전하면서 사람 중심의 언어로 프로그래밍 할 수 있다
- FORTRAN, COBOL, PROLOG, C, Erlang, Lisp, Swift, Kotlin, Clojure, Python, JAVA

웹 관련 인기언어
- Python, PHP, JavaScript, java, ruby

### 2. 웹의 동작

![image](https://user-images.githubusercontent.com/71435571/117992414-dfacf180-b379-11eb-9129-beea179d72b4.png)

- 서버와 클라이언트가 인터넷상에서 데이터를 주고받기 위한 프로토콜(protocol)
- HTTP는 서버/클라이언트 모델을 따릅니다.

장점

- 불특정 다수를 대상으로 하는 서비스에 적합
- 클라이언트와 서버가 계속 연결된 형태가 아니기 때문에 클라이언트와 서버 간의 최대 연결 수보다 훨씬 많은 요청과 응답을 처리할 수 있다.

단점

- 연결을 끊어버리기 때문에, 클라이언트의 이전 상황을 알 수가 없다. => 무상태(Stateless)라고 말한다.
- 이러한 특징 때문에 정보를 유지하기 위해서 Cookie와 같은 기술이 등장하게 되었다.

URL (Uniform Resource Locator)

- 인터넷 상의 자원의 위치
- 특정 웹 서버의 특정 파일에 접근하기 위한 경로 혹은 주소

### 3. 웹프론트엔드와 백엔드

웹프론트엔드 - 사용자에게 보여지는 것 제공

- 사용자에게 웹을 통해 다양한 콘텐츠(문서, 동영상, 사진 등)를 제공
- 사용자의 요청(요구사항)에 반응해서 동작

html - 웹콘텐츠를 잘 보여주기 위해 만드는 구조(신문,책)

- 원하는 문서의 구조 잘 표현

css - 적절한 배치와 일관된 디자인 등을 제공

- 각각의 html 태그를 꾸미기 위한 규칙 표현

Javascript - 사용자 요청을 잘 반영(소통하며)

- html, css 움직임, 변경 가능

백 엔드(Back-End) - 정보 처리, 저장
(쇼핑몰 - 상품 정보 가짐, 주문 받아서 저장, 사용자 관심 상품 추천)

백 엔드 개발자가 알아야 할 것들

- 프로그래밍 언어(JAVA, Python, PHP, Javascript 등)
- 웹의 동작 원리
- 알고리즘(algorithm), 자료구조 등 프로그래밍 기반 지식
- 운영체제, 네트워크 등에 대한 이해
- 프레임워크에 대한 이해(예: Spring)
- DBMS에 대한 이해와 사용방법(예: MySQL, Oracle 등)

### 4. browser의 동작

웹에서 오른쪽 마우스 → 소스보기

browser components 구성요소

- user interface(ui): 화면에서 보이는 모든 것
- browser engine: 소스 코드 실행해줌, 브라우저 소프트웨어를 동작하게 해주는 핵심 엔진
- rendering engine: 화면에 직접 위치 잡고, 색칠해줌
- networking
- javascript interpreter
- ui backend

parsing- general - 토큰단위로 잘라서 의미해석, 해석된 의미에 따라 실행해줌
2+3-1 하나하나 분리

<html parser(해석기)>
DOM tree

<CSS parsing>
객체화된 트리구조

![image](https://user-images.githubusercontent.com/71435571/117992956-44684c00-b37a-11eb-94be-21f61e194b1d.png)

### 5. browser에서 웹개발

크롬 브라우저 - ctrl+shif+l ⇒ 크롬 개발자 도구

html - html이라는 태그로 시작 -> html태그로 끝남
head: html문서에 대한 추가적인 설명
body: 화면에 표현할 것, div 사용
html -> 계층적, 태그를 사용해서 표현
<tag class = "titile"> 안녕하세요</tag>

[http://www.jsbin.com/](http://www.jsbin.com/)

meta : 문서에 대한 정보
브라우저는 한 라인씩 해석
자바스크립트 코드는 html아래쪽 위치하는게 좋다

```jsx
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>boostcourse</title>
  <style>
    div {
      color:blue;
    }
  </style>
</head>
<body>
  <div>웹프론트엔드</div>
</body>
<script>
  console.log("javascript codes..");
  </script>
</html>
```
### 6. 웹 서버

- 웹 서버 소프트웨어가 동작하는 컴퓨터
- 가장 중요한 기능은 클라이언트(Client)가 요청하는 HTML 문서나 각종 리소스(Resource)를 전달하는 것
클라이언트 - 웹브라우저
- 웹 브라우저나 웹 크롤러(검색사이트에서 다른 웹사이트 정보를 읽어갈 때 사용하는 소프트웨어)
가 요청하는 리소스는 컴퓨터에 저장된 정적(static)인 데이터이거나 동적인 결과가 될 수 있음
- 정적 데이터: 컴퓨터에 저장되어 있는 파일(이미지, html파일, css파일, javascript파일)
- 동적 데이터: 웹서버에 의해 실행되는 프로그램을 통해 만들어진 결과물

### 7. WAS(Web Application Server)

클라이언트/서버 구조

- 클라이언트(Client)는 서비스(Service)를 제공하는 서버(Server)에게 정보를 요청하여 응답 받은 결과를 사용
- 웹브라우저 <-> 웹서버

DBMS (DataBase Management System)

- 다수의 사용자가 데이터베이스 내의 데이터에 접근할 수 있도록 해주는 소프트웨어

미들웨어(MiddleWare)

- DBMS 문제 해결(클라이언트 쪽에 비즈니스 로직이 많을 경우, 클라이언트 관리(배포 등)로 인해 비용이 많이 발생하는 문제)
- 클라이언트와 DBMS 사이에 또 다른 서버를 둠
- 비즈니스 로직을 클라이언트와 DBMS사이의 미들웨어 서버에서 동작하도록 함으로써 클라이언트는 입력과 출력만 담당

WAS(Web Application Server)

![image](https://user-images.githubusercontent.com/71435571/117992771-239ff680-b37a-11eb-8996-9ec3d123523f.png)

- WAS는 일종의 미들웨어로 웹 클라이언트(보통 웹 브라우저)의 요청 중 웹 애플리케이션이 동작하도록 지원하는 목적을 가짐
- 자체적으로 웹 서버 기능 내장
- 자원 이용의 효율성 및 장애 극복, 배포 및 유지보수의 편의성을 위해 웹서버와 WAS를 대체로 분리
