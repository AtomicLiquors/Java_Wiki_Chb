
    java.lang.ClassNotFoundException: com.mysql.cj.jdbc.Driver

    뜻 : 사용하고자 하는 클래스 "com.mysql.cj.jdbc.Driver"를 찾을 수 없다.
    이클립스는 있지만, cmd는 없다. 
    그래서 classpath를 환경설정해야 한다.
    
    내 PC > 속성 > 환경 변수 > 시스템 변수 > 새로 만들기  
    변수 이름 : classpath  
    변수 값 : .;C:\Program Files (x86)\MySQL\Connector J 8.0\mysql-connector-java-8.0.21.jar;  
    -> .;를 앞에 붙이고, 그 뒤에 해당하는 파일의 디렉토리.