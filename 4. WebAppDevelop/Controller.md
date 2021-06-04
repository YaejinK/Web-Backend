## @RestController
- Spring 4 에서 Rest API 또는 Web API를 개발하기 위해 등장한 애노테이션
- 이전 버전의 @Controller와 @ResponseBody를 포함합니다.

## MessageConvertor
- 자바 객체와 HTTP 요청 / 응답 바디를 변환하는 역할
- @ResponseBody, @RequestBody
- @EnableWebMvc 로 인한 기본 설정
- WebMvcConfigurationSupport 를 사용하여 Spring MVC 구현
- Default MessageConvertor 를 제공

### MessageConvertor 종류
![image](https://user-images.githubusercontent.com/71435571/120740328-f89a6400-c52d-11eb-8d2c-4b098ed0c010.png)

## JSON 응답하기
- 컨트롤러의 메소드에서는 JSON으로 변환될 객체를 반환합니다.
- jackson라이브러리를 추가할 경우 객체를 JSON으로 변환하는 메시지 컨버터가 사용되도록 @EnableWebMvc에서 기본으로 설정되어 있습니다.
- jackson라이브러리를 추가하지 않으면 JSON메시지로 변환할 수 없어 500오류가 발생합니다.
- 사용자가 임의의 메시지 컨버터(MessageConverter)를 사용하도록 하려면 WebMvcConfigurerAdapter의 configureMessageConverters메소드를 오버라이딩 하도록 합니다.

