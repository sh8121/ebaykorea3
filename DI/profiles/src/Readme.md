스프링은 프로파일이 활성 상태인지 결정하기 위해 2가지 프로퍼티를 가진다.

-  spring.profiles.active
- spring.profiles.default

spring.profiles.active가 설정되어 있지 않을 경우 spring.profiles.default가 사용된다.
2개 모두 설정되어 있지 않을 경우 프로파일이 없고, 프로파일이 정의도지 않은 빈만 만들어진다.

프로퍼티를 설정하기 위한 방법

- DispatcherServlet에서 초기화된 파라미터
- 웹 애플리케이션의 컨텍스트 파라미터
- JNDI 엔트리
- 환경변수
- JVM 시스템 프로퍼티
- 통합 테스트 클래스에서 @ActiveProfile 애노테이션 사용

ContextLoaderListener 설정

<context-param>
    <param-name>spring.profile.default</param-name>
    <param-value>dev</param-value>
</context-param>


DispatcherServlet 설정
<init-param>
    <param-name>spring.profile.default</param-name>
    <param-value>dev</param-value>
</init-param>

