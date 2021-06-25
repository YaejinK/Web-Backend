## @RestController
- Spring 4 에서 Rest API 또는 Web API를 개발하기 위해 등장한 애노테이션
- 이전 버전의 @Controller와 @ResponseBody를 포함합니다.

## MessageConvertor
- 예) 외부에서 전달받은 json 메소드를 내부에서 사용할 수 있는 객체로 변환
- 예) Controller를 return한 객체가 클라이언트에게 json으로 변환하여 전달할 수 있도록 함
- 자바 객체와 HTTP 요청 / 응답 바디를 변환하는 역할
- @ResponseBody, @RequestBody
- @EnableWebMvc 로 인한 기본 설정
- WebMvcConfigurationSupport 를 사용하여 Spring MVC 구현
- Default MessageConvertor 를 제공

### MessageConvertor 종류
![image](https://user-images.githubusercontent.com/71435571/120740328-f89a6400-c52d-11eb-8d2c-4b098ed0c010.png)

## json 응답하기
- 컨트롤러의 메소드에서는 JSON으로 변환될 객체를 반환합니다.
- jackson라이브러리를 추가할 경우 객체를 JSON으로 변환하는 메시지 컨버터가 사용되도록 @EnableWebMvc에서 기본으로 설정되어 있습니다.
- jackson라이브러리를 추가하지 않으면 JSON메시지로 변환할 수 없어 500오류가 발생합니다.
- 사용자가 임의의 메시지 컨버터(MessageConverter)를 사용하도록 하려면 WebMvcConfigurerAdapter의 configureMessageConverters메소드를 오버라이딩 하도록 합니다.

# 3) Web API 테스트 코드 작성하기

Web API 많이 작성 시 Web API를 실행하는 시간보다 웹 어플리케이션을 실행하고 종료하는 시간이 더 오래걸림
문제점 - 개발자의 수동 테스트
       - 코드를 수정한 후에 서버를 재시작하고 테스트
해결책 - JUnit 사용
       - MockMVC 사용

## 1. MockMVC란?
- 요청을 받고 응답을 받는 WAS와 같은 역할을 수행, 웹 애플리케이션 실행시켜줌
- WAS 실행 시 상당히 많은 작업 요구
- MockMVC 웹 애플리케이션 실행하기 위한 최소한의 기능 -> 상당히 빠름
- 가능한 테스트 종류
![image](https://user-images.githubusercontent.com/71435571/123365792-f3bb5400-d5b1-11eb-94be-fe64ac2a40fd.png)

## 2. 예제를 통해 알아보는 MockMVC Test
![image](https://user-images.githubusercontent.com/71435571/123366122-9a9ff000-d5b2-11eb-87e9-e7b43a2c06d9.png)
- GuestbookApiController를 단위 테스트한다는 것은, GuestbookApiController가 사용하는 GuestbookService에 대한 부분은 함께 테스트하지 않는다는 것을 의미

``` @Mock
    GuestbookService guestbookService;
```    
@Mock어노테이션을 붙여서 선언된 guestbookService는 mockito에 목객체로 생성, 가짜 객체

```
@InjectMocks
    public GuestbookApiController guestbookApiController;
```
@InjectMocks어노테이션이 붙여서 선언된 guestbookApiController는 목객체인 GuestbookService를 사용
스프링에 위해 주입된 객체를 사용하는 것이 아닌 Mockito 프레임워크에 위해 생성된 목객체가 주입되어 객체가 생성
