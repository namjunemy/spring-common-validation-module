# Spring Common Validation, Global Error Handling

* 브라우저에서는 얼마든지 요청 데이터를 조작해서 클라이언트 사이드의 validation check를 의미없게 할 수 있다.
* 따라서, 백엔드에서 필수적으로 validation check를 해야 하는데, @Valid 어노테이션으로 처리하기에 한계가 있는 부분들을 커버하기 위해 공통 Validation 모듈로 처리할 수 있다.
* 추가로 Validate 실패시 Exception 핸들링을 글로벌하게 처리하는 방법을 알아 본다.

## Reference
* https://www.baeldung.com/exception-handling-for-rest-with-spring
* https://www.baeldung.com/spring-boot-bean-validation
* https://jojoldu.tistory.com/129