## 1. Servlet
자바 웹 어플리케이션(Java Web Application)

- WAS(tomcat)에 설치되어 동작하는 어플리케이션
- HTML, CSS, 이미지, 자바로 작성된 클래스(Servlet도 포함됨, package, 인터페이스 등), 각종 설정 파일 등이 포함

### 서블릿(Servlet)

- WAS(tomcat)에 동작하는 JAVA 클래스
- 자바 웹 어플리케이션의 구성요소 중 동적인 처리를 하는 프로그램의 역할
- HttpServlet 클래스를 상속받아야 함
- 서블릿과 JSP로부터 최상의 결과를 얻으려면, 웹 페이지를 개발할 때 이 두 가지(JSP, 서블릿)를 조화롭게 사용
- 웹 페이지를 구성하는 화면(HTML): JSP / 복잡한 프로그래밍: 서블릿
- 동적으로 응답결과 만듦

## 2. Servlet 작성방법

Servlet 3.0 spec 이상에서 사용하는 방법  ==>Dynamic web module version 3.1

- web.xml파일 사용 안함, "자바 annontation 사용"

Servlet 3.0 spec 미만에서 사용하는 방법

- Servlet을 등록할 때 web.xml파일에 직접 추가(수정) 해줘야함

## 3. Servlet lifecycle

Servlet 실행 -> 생성자 생성 -> init 호출 -> service 호출 -> 페이지 열림 -> 새로고침 -> service 호출 -> ...
파일이 변경되고 다시 실행하면 destroy 호출 -> 다시 생성자 생성 -> init -> service

### WAS는 서블릿 요청을 받으면 해당 서블릿이 메모리에 있는지 확인.

- init() : if 해당 서블릿이 메모리에 없음 -> 메모리에 올린 후 실행
- service(request, response) : else 실행 => 요청이 들어왔을때 응답해야할 것 작성
- destroy() : WAS가 종료되거나, 웹 어플리케이션이 새롭게 갱신될 경우 실행

### service 메소드

- HttpServlet의 service(request, response) 메소드는 템플릿 메소드 패턴으로 구현
- 클라이언트의 요청이 GET일 경우 자신이 가지고 있는 doGet(request, response)메소드를 호출
    - url에서 직접 요청할 경우 메소드 값이 Get으로 넘어감
- 클라이언트의 요청이 Post일 경우 자신이 가지고 있는 doPost(request, response)메소드를 호출

## 4. Request, Response 객체 이해하기

### HttpServletRequest

- WAS는 웹 브라우저로부터 Servlet 요청을 받으면, 요청할 때 가지고 있는 정보를 HttpServletRequest객체를 생성하여 저장함
- http 프로토콜의 request 정보를 서블릿에게 전달하기 위한 목적으로 사용
- 헤더정보, 파라미터, 쿠키, URI, URL 등의 정보를 읽어들이는 메소드를 가지고 있음
- Body의 Stream을 읽어들이는 메소드를 가지고 있음

### HttpServletResponse

- WAS는 어떤 클라이언트가 요청을 보냈는지 알고 있고, 해당 클라이언트에게 응답을 보내기 위한 HttpServletResponse 객체를 생성하여 서블릿에게 전달함
- 서블릿은 해당 객체를 이용하여 content type, 응답코드, 응답 메시지등을 전송

### 헤더 정보 읽어들이기

<br> 줄바꿈
(2) HeaderServlet.java
(3) ParameterServlet.java
[http://localhost:8080/firstweb/param](http://localhost:8080/firstweb/param) // ?name=kim&age=23 뒤에 붙이면 값이 나옴!!(파라미터)
(4) InfoServlet.java
