# <6. JSTL & EL>

## 1. EL `${expr }`

- 표현언어(값을 표현하는데 사용되는 스크립트 언어, JSP의 기본 문법 보완)
- JSP scope에 맞는 속성 사용
- 집합 객체에 대한 접근 방법, 표현 언어만의 기본 객체 제공
- 수치 연산, 관계 연산, 논리 연산자 제공
- 자바 클래스 메소드 호출 기능 제공
- JSP의 스크립트 요소(스크립트릿, 표현식, 선언부)를 제외한 나머지 부분에서 사용

### 표현 언어의 기본 객체

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5827095a-3674-43ed-9e91-3b4f12d3dcd7/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5827095a-3674-43ed-9e91-3b4f12d3dcd7/Untitled.png)

### 사용 예

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/cad5bbb6-6e6d-435b-ac58-ab16e48640fb/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/cad5bbb6-6e6d-435b-ac58-ab16e48640fb/Untitled.png)

### 데이터 타입

- 불리언
- 정수
- 실수
- 문자열
- 널(null)

### `${<표현1>.<표현2>}`

### 객체 접근 규칙

- 표현 1이나 표현 2가 null이면 null을 반환한다.
- 표현1이 Map일 경우 표현2를 key로한 값을 반환한다.
- 표현1이 List나 배열이면 표현2가 정수일 경우 해당 정수 번째 index에 해당하는 값을 반환한다.
- 만약 정수가 아닐 경우에는 오류가 발생한다.
- 표현1이 객체일 경우는 표현2에 해당하는 getter메소드에 해당하는 메소드를 호출한 결과를 반환한다.

### 표현 언어의 수치 연산자

- +, -, *, /(div), %(mod)

### 비교 연산자

- ==(eq), ≠(ne), <(lt), >(gt), ≤(le), ≥(ge)
- 문자열 비교: ${str == '값'} str.compareTo("값") == 0 과 동일

### 논리연산자

- &&(and), ||(or), !(not)

### empty 연산자/비교선택 연산자

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b9119512-3534-48a2-8a65-5fe93be97958/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b9119512-3534-48a2-8a65-5fe93be97958/Untitled.png)

```java
<%
    pageContext.setAttribute("p1", "page scope value");
    request.setAttribute("r1", "request scope value");
    session.setAttribute("s1", "session scope value");
    application.setAttribute("a1", "application scope value");
%>
```

```java
pageContext.getAttribute("p1") : ${pageScope.p1 }<br>
request.getAttribute("r1") : ${requestScope.r1 }<br>
session.getAttribute("s1") : ${sessionScope.s1 }<br>
application.getAttribute("a1") : ${applicationScope.a1 }<br>
<br><br>
pageContext.getAttribute("p1") : ${p1 }<br>
request.getAttribute("r1") : ${r1 }<br>
session.getAttribute("s1") : ${s1 }<br>
application.getAttribute("a1") : ${a1 }<br>
```

## 2. JSTL

- JSTL(JSP Standard Tag Library)
- JSP 페이지에서 조건문 처리, 반복문 처리 등을 html tag 형태로 작성할 수 있게 도와줌
- 태그 형태로 사용 가능
- JSP 결과 출력 목적

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8a0fb96a-0a9d-48cc-8694-c35b5f337e09/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8a0fb96a-0a9d-48cc-8694-c35b5f337e09/Untitled.png)

### JSTL이 제공하는 태그의 종류

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4660cf19-0c9f-41b3-82fb-9207da5ee705/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4660cf19-0c9f-41b3-82fb-9207da5ee705/Untitled.png)

### 코어 태그

- 논리적인 흐름을 태그로 처리 할 수 있도록 도움

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/171c3981-4582-4a97-a597-f357a2a35fa4/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/171c3981-4582-4a97-a597-f357a2a35fa4/Untitled.png)

### 변수 지원 태그 - set, remove

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/745ea480-f3cd-431a-ab73-5642efe7a888/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/745ea480-f3cd-431a-ab73-5642efe7a888/Untitled.png)

- var: 변수명, value 안에 들어갈 값, scope: scope지정

### 변수 지원 태그 - property, 맵의 처리

- 이 객체의 값을 변경, 읽어들임
- set 을 이용해 특정한 객체의 메소드에 값을 전달

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6c81d9f1-bd11-4a96-ad70-d2e0e76da88b/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6c81d9f1-bd11-4a96-ad70-d2e0e76da88b/Untitled.png)

- setter 구현 규칙 지켜야함

### 흐름제어 태그 - if

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/2abf829b-e1e5-416f-9b24-dbec109b98cc/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/2abf829b-e1e5-416f-9b24-dbec109b98cc/Untitled.png)

- else 처리 없음

### 흐름제어 태그 - forEach

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6358d06e-fb6f-4125-8b26-fcd16eb9c018/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6358d06e-fb6f-4125-8b26-fcd16eb9c018/Untitled.png)

- 배열, list 와 같은 자료구조에서 정보 빼올 수 있음
- for문처럼 특정 조건만큼 반복하게 가능
- 아이템을 담을 변수 = var
- 대괄호 생략 가능

### 흐름제어 태그 - import

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/698c733c-bb47-4fe8-8946-0b00b67cdc06/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/698c733c-bb47-4fe8-8946-0b00b67cdc06/Untitled.png)

- 특정한 url 페이지의 결과 읽어들여서 그 결과를 변수에 저장 후 사용

### 흐름제어 태그 - redirect

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/111d1dab-5732-43b7-863c-85b5283922be/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/111d1dab-5732-43b7-863c-85b5283922be/Untitled.png)

### 기타태그 - out

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d99a9505-3f98-48a9-a765-04b157d161d2/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d99a9505-3f98-48a9-a765-04b157d161d2/Untitled.png)

- 특정한 문자열 출력 가능
