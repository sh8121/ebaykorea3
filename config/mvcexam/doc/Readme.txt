Tomcat
  +
  ---- bin : startup.sh , shutdown.sh
  +
  ---- conf : Tocmat설정파일 (port설정 : 8080)
  +
  ---- lib : tomcat 라이브러리 (serlvet, jsp, el 라이브러리 등)
  +
  ---- webapps : 웹 어플리케이션들
         |
         +------ ROOT
         |
         +------ manager
         .....

http://localhost:8080/{context root}/path?{파라미터들}

context root는 웹 어플리케이션마다 유일한 값을 가져야 한다.
WAS마다 설정방법이 다르다. (Tomcat, Weblogic 등에 따라 다르다.)
tocmat은 ROOT 라는 이름의 웹어플리케이션은 / 로 인식을 한다.
나머지는 보통 폴더이름이 context root가 된다.

http://localhost:8080/hello.jsp (ROOT 웹어플리케이션의 hello.jsp)
http://localhost:8080/manager/hello.jsp (manaber 웹 어플리케이션의 hello.jsp)

웹어플리케이션(board) - 예를 들어 게시판 웹 어플리케이션
    |
    +---- WEB-INF -- web.xml
    |            +
    |            ---- classes : 사용자가 만든 package와 class들
    |            |
    |            ---- lib : *.jar
    |            |
    |            ---- 각종폴더와 파일들
    |
    +---- 폴더, 각종 파일들

board폴더 안의 내용을 jar로 묶어서 하나의 파일로 만든다. board.war 로 만든다.

tocmcat에 배포하려면 어떻게 하는가?

webapps폴더에 복사를 하고 tomcat을 실행한다. tocmat이 실해되면서 board.war의 압축을 해제한다.
webapps ---- board ---- war파일의 내용이 묶인것이 풀린다.

http://localhost:8080/board/list.jsp 이런식으로 호출을 할 수 있다.

maven 프로젝트?

src - main --- java - 패키지및 자바 소스
           |
           --- webapp ---- WEB-INF ---- web.xml
intelliJ가 관리하는 tomcat에 intelliJ가 war파일을 만들어서 배포한다.(deploy)


-----------------------

			<!-- maven에서 tomcat을 실행한다. -->
			<plugin>
				<groupId>org.apache.tomcat.maven</groupId>
				<artifactId>tomcat7-maven-plugin</artifactId>
				<version>2.1</version>
				<configuration>
					<charset>UTF-8</charset>
					<uriEncoding>UTF-8</uriEncoding>
					<port>8080</port>
				</configuration>
			</plugin>

콘솔

mvn tomcat7:run
위와 같을경우 <finalName>mvcexam</finalName> 이름이 context path(application path, Context root)가 된다.
http://localhost:8080/mvcexam/


			<!-- maven에서 tomcat을 실행한다. -->
			<plugin>
				<groupId>org.apache.tomcat.maven</groupId>
				<artifactId>tomcat7-maven-plugin</artifactId>
				<version>2.1</version>
				<configuration>
					<charset>UTF-8</charset>
					<uriEncoding>UTF-8</uriEncoding>
					<port>8080</port>
					<path>/</path>
				</configuration>
			</plugin>

mvn tomcat7:run

http://localhost:8080/
