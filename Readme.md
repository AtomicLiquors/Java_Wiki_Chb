## JAVA 노션 학습내용을 깃허브로 포팅하기 시작합니다. 
### 모델 :
- [김남윤(Cheese10Yun)님의 TIL 저장소](https://github.com/cheese10yun/TIL)
- [주석 및 편의기능](https://github.com/AtomicLiquors/Java_Wiki_Chb/blob/main/0.%EC%A3%BC%EC%84%9D_%EB%B0%8F_%ED%8E%B8%EC%9D%98%EA%B8%B0%EB%8A%A5/eclipse.md)
- 메인으로(https://github.com/AtomicLiquors/Java_Wiki_Chb/blob/main/Readme.md)

- 더블클릭 > alt shitf T(Refactor) > Rename ‘변수명 동시에 바꾸기”
    
    트러블슈팅 : 
    java.lang.ClassNotFoundException: com.mysql.cj.jdbc.Driver

    뜻 : 사용하고자 하는 클래스 "com.mysql.cj.jdbc.Driver"를 찾을 수 없다.
    이클립스는 있지만, cmd는 없다. 
    그래서 classpath를 환경설정해야 한다.
    
    내 PC > 속성 > 환경 변수 > 시스템 변수 > 새로 만들기  
    변수 이름 : classpath  
    변수 값 : .;C:\Program Files (x86)\MySQL\Connector J 8.0\mysql-connector-java-8.0.21.jar;  
    -> .;를 앞에 붙이고, 그 뒤에 해당하는 파일의 디렉토리.
    
## - Potential Objective :

- 지금까지 배운 파이썬 기술을 브런치 글이나 발표자료로 정리해 보세요.
- 지금까지 배운 C언어 기술을 브런치 글이나 발표자료로 정리해 보세요.

___

### TIL 관련

리드미파일에 카테고리를 나눈다.
자바 백엔드 개발자가 되실 분들은 이 저장소를 다 보시기 바랍니다.

1. 
2. [HomoEfficio님의 문제해결 저장소](https://github.com/HomoEfficio/dev-tips)
3. [김남준(namjunemy)님의 TIL 저장소](https://github.com/namjunemy/TIL)
4. [진유림(milooy)님의 TIL 저장소](http://milooy.github.io/TIL/)


    
자바 문제풀이와 사고과정.
**실제로 문제풀이를 시작하는 시점에서!**  
릿코드 몇번을 푸는지만 확인한 뒤 직접 풀어보고,
그다음 강의를 보자.

1. [승지니어 기술면접 라이브코딩 기본편](https://www.youtube.com/watch?v=Bt11jaoqt_Y&list=PL2mzT_U4XxDm7p6g1o3KeQMsyRLfzSaVW)
2. [승지니어 기술면접 라이브코딩 실전편](https://www.youtube.com/watch?v=go8y4-vVg3Y&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ)

___
자바는 v10부터 JS처럼 var가 존재하는데...  
”실무에서 쓰는 건 거의 못 봤어요.(강사)”

이전 버전과 호환성.

— **시장에서 검증된 버전**을 쓰는 게 관례다.  
— 공부는 최신 버전으로 하면 이전 버전을 다 포괄한다.
