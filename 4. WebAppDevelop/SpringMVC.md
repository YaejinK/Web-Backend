## 1) Spring MVC
### MVC
- MVC는 Model-View-Controller의 약자입니다.
- Model : 모델은 뷰가 렌더링하는데 필요한 데이터 (예: 사용자가 요청한 상품 목록이나, 주문 내역)
- View : 웹 애플리케이션에서 뷰(View)는 실제로 보이는 부분이며, 모델을 사용해 렌더링을 합니다. 뷰는 JSP, JSF, PDF, XML등으로 결과를 표현합니다.
- Controller : 컨트롤러는 사용자의 액션에 응답하는 컴포넌트입니다. 컨트롤러는 모델을 업데이트하고, 다른 액션을 수행합니다.

#### MVC Model 1
![image](https://user-images.githubusercontent.com/71435571/119926863-2e31d100-bfb3-11eb-8a57-cfe881ba270e.png)
- Java Bean - jdbc와 같은 클래스(RoleDao)
- JSP page에 여러 개 섞여있음

#### MVC Model 2
![image](https://user-images.githubusercontent.com/71435571/119926884-3853cf80-bfb3-11eb-95a5-02dedbca70c8.png)
- servelet - 요청, 데이터 처리 Controller
- jsp - 모델 결과 보여줌 View
- 로직과 뷰 분리 가능

#### MVC Model 2
![image](https://user-images.githubusercontent.com/71435571/119926894-3db11a00-bfb3-11eb-9b09-89265fdf4c30.png)
- 컨트롤러 클래스, 핸들러

#### Spring Web Module
![image](https://user-images.githubusercontent.com/71435571/119926904-43a6fb00-bfb3-11eb-9ba2-532609ccbd72.png)

## 2) Spring MVC구성요소
#### Spring MVC 기본 동작 흐름
![image](https://user-images.githubusercontent.com/71435571/119927066-a39da180-bfb3-11eb-8927-f90aab73510c.png)
- 파란색 spring mvc가 제공
- 보라색 개발자가 만들어야함
- 녹색 둘다 존재

### DispatcherServlet
- 프론트 컨트롤러 (Front Controller)
- 클라이언트의 모든 요청을 받은 후 이를 처리할 핸들러에게 넘기고 핸들러가 처리한 결과를 받아 사용자에게 응답 결과를 보여줌
- DispathcerServlet은 여러 컴포넌트를 이용해 작업을 처리

#### DispatcherServlet 내부 동작 흐름
![image](https://user-images.githubusercontent.com/71435571/119927367-43f3c600-bfb4-11eb-8cc5-76aa455a0d66.png)

-----
#### DispatcherServlet 내부 동작흐름 상세 - 요청 선처리 작업
![image](https://user-images.githubusercontent.com/71435571/119927491-7e5d6300-bfb4-11eb-8181-6c512cf38fad.png)
- Locale 지역화 설정(한국어, 일본어 ..) -> 브라우저 언어 세팅에 따라
- FlashMap 복원 - 현재 실행이 redirect되었을때만 실행됨

### 요청 선처리 작업시 사용된 컴포넌트
org.springframework.web.servlet.LocaleResolver
- 지역 정보를 결정해주는 전략 오브젝트
- 디폴트인 AcceptHeaderLocalResolver는 HTTP 헤더의 정보를 보고 지역정보를 설정

org.springframework.web.servlet.FlashMapManager
- FlashMap객체를 조회(retrieve) & 저장을 위한 인터페이스
- RedirectAttributes의 addFlashAttribute메소드를 이용해 저장
- 리다이렉트 후 조회를 하면 정보는 바로 삭제됨

org.springframework.web.context.request.RequestContextHolder
- 일반 빈에서 HttpServletRequest, HttpServletResponse, HttpSession 등을 사용할 수 있도록 함
- 해당 객체를 일반 빈에서 사용하게 되면, Web에 종속될 수 있음

org.springframework.web.multipart.MultipartResolver
- 멀티파트 파일 업로드를 처리하는 전략
-----
#### DispatcherServlet 내부 동작흐름 상세 - 요청 전달
![image](https://user-images.githubusercontent.com/71435571/119927853-40147380-bfb5-11eb-87c2-652b59eed5e2.png)

### 요청 전달시 사용된 컴포넌트
org.springframework.web.servlet.HandlerMapping
- HandlerMapping구현체는 어떤 핸들러가 요청을 처리할지에 대한 정보를 알고 있음
- 디폴트로 설정되는 있는 핸들러매핑은 BeanNameHandlerMapping과 DefaultAnnotationHandlerMapping 2가지 설정

org.springframework.web.servlet.HandlerExecutionChain
- HandlerExecutionChain구현체는 실제로 호출된 핸들러에 대한 참조를 가지고 있음
- 무엇이 실행되어야 될지 알고 있는 객체라고 말할 수 있으며, 핸들러 실행전과 실행후에 수행될 HandlerInterceptor도 참조

org.springframework.web.servlet.HandlerAdapter
- 실제 핸들러를 실행하는 역할을 담당
- 핸들러 어댑터는 선택된 핸들러를 실행하는 방법과 응답을 ModelAndView로 변화하는 방법에 대해 알고 있음
- 디폴트로 설정되어 있는 핸들러어댑터는 HttpRequestHandlerAdapter, SimpleControllerHandlerAdapter, AnnotationMethodHanlderAdapter 3가지
- @RequestMapping과 @Controller 애노테이션을 통해 정의되는 컨트롤러의 경우 DefaultAnnotationHandlerMapping에 의해 핸들러가 결정되고, 그에 대응되는 AnnotationMethodHandlerAdapter에 의해 호출이 일어남
-----
#### DispatcherServlet 내부 동작흐름 상세 - 요청 처리
![image](https://user-images.githubusercontent.com/71435571/119928054-c6c95080-bfb5-11eb-8f43-fa2a758beeed.png)

### 요청 처리시 사용된 컴포넌트
org.springframework.web.servlet.ModelAndView
- ModelAndView는 Controller의 처리 결과를 보여줄 view와 view에서 사용할 값을 전달하는 클래스
- request에 값을 넣어서 사용하는 것보다 바람직함

org.springframework.web.servlet.RequestToViewNameTranslator
- 컨트롤러에서 뷰 이름이나 뷰 오브젝트를 제공해주지 않았을 경우 URL과 같은 요청정보를 참고해서 자동으로 뷰 이름을 생성해주는 전략 오브젝트
- 디폴트는 DefaultRequestToViewNameTranslator
-----
#### DispatcherServlet 내부 동작흐름 상세 - 예외처리
![image](https://user-images.githubusercontent.com/71435571/119928202-13149080-bfb6-11eb-85a0-a973f2309b67.png)

### 예외 처리시 사용된 컴포넌트
org.springframework.web.servlet.handlerexceptionresolver
- 기본적으로 DispatcherServlet이 DefaultHandlerExceptionResolver를 등록
- HandlerExceptionResolver는 예외가 던져졌을 때 어떤 핸들러를 실행할 것인지에 대한 정보를 제공
-----
#### DispatcherServlet 내부 동작흐름 상세 - 뷰 렌더링 과정
![image](https://user-images.githubusercontent.com/71435571/119928285-3fc8a800-bfb6-11eb-8b9d-9d79d377c1d1.png)
### 뷰 렌더링 과정시 사용된 컴포넌트
org.springframework.web.servlet.ViewResolver
- 컨트롤러가 리턴한 뷰 이름을 참고해서 적절한 뷰 오브젝트를 찾아주는 로직을 가진 전략 오프젝트
- 뷰의 종류에 따라 적절한 ViewResolver를 추가로 설정해줄 수 있음
-----
#### DispatcherServlet 내부 동작흐름 상세 - 요청 처리 종료
![image](https://user-images.githubusercontent.com/71435571/119928463-98984080-bfb6-11eb-9221-bdede2f7d384.png)

## 3) Spring MVC를 이용한 웹 페이지 작성 실습


