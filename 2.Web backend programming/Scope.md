# <5. Scope>

- Application
- Session
- Request
- Page
(밑으로 갈수록 범위 작아짐)

### Page scope

- PageConext 추상 클래스 사용
- JSP 페이지에서 pageContext라는 내장 객체로 사용 가능
- foward가 될 경우 해당 Page scope에 지정된 변수는 사용할 수 없다.
- 지역변수처럼 사용된다는 것이 다른 Scope와 다름
- jsp에서 pageScope에 값을 저장한 후 해당 값을 EL표기법 등에서 사용할 때 사용됨
- 지역변수처럼 해당 jsp나 서블릿이 실행되는 동안에만 정보를 유지하고자 할 때 사용
(페이지가 실행될 때만 사용 가능)

### Request scope

- http요청을 WAS가 받아 웹 브라우저에게 응답할 때까지 변수 값을 유지하고자 할 경우 사용
- HttpServletRequest 객체 사용
- JSP에서는 request 내장 변수 사용
- 서블릿에서는 HttpServletRequest 객체를 사용
- 값을 저장할 때는 request 객체의 setAttribute()메소드를 사용
- 값을 읽어 들일 때는 request 객체의 getAttribute()메소드를 사용
- forward 시 값을 유지하고자 사용

### Session scope

- 웹 브라우저별로 변수를 관리하고자 할 경우 사용
- 웹 브라우저간의 탭 간에는 세션정보가 공유되기 때문에, 각각의 탭에서는 같은 세션정보를 사용할 수 있음
- HttpSession 인터페이스를 구현한 객체를 사용
- JSP에서는 session 내장 변수를 사용
- 서블릿에서는 HttpServletRequest의 getSession()메소드를 이용하여 session 객체 얻음
- 값을 저장할 때는 session 객체의 setAttribute()메소드를 사용
- 값을 읽어 들일 때는 session 객체의 getAttribute()메소드를 사용
- 장바구니처럼 사용자별로 유지가 되어야 할 정보가 있을 때 사용
- 클라이언트(웹 브라우저) 마다 가지고 있으므로 정보 유지 가능

### Application scope

- 웹 어플리케이션이 시작되고 종료될 때까지 변수를 사용 가능
- ServletContext 인터페이스를 구현한 객체 사용
- jsp에서는 application 내장 객체 이용
- 서블릿의 경우는 getServletContext()메소드를 이용하여 application객체 이용
- 웹 어플리케이션 하나당 하나의 application객체가 사용
- 값을 저장할 때는 application객체의 setAttribute()메소드를 사용
- 값을 읽어 들일 때는 application객체의 getAttribute()메소드를 사용
- 모든 클라이언트가 공통으로 사용해야 할 값들이 있을 때 사용!!!
