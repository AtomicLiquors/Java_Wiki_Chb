
DB연동, AWT예제, IO, 네트워크 소켓



- 데이터베이스
    
    heidisql 커맨드 화면 가독성. 맞어?
    
    MYSQL 포트번호 3306
     → Troubleshooting: 포트 번호를 누가 쓰고 있다고 뜨면?
    명령 프롬프트 > 
    netstat -a 
    netstat -na
    작업 관리자 > 서비스 
    ...등을 찾아보다가 결국 못 찾아서 번호를 바꿨다.
    포트 번호는 나중에 바꿀 수 있다고 함.
    
    계정 비번 : 1234
    
    계정 : root/1234
    (계정은 대소문자 구분 안한다.)
    
    “여러 사람이 공유하여 사용할 목적으로 체계화된 대용량 데이터 집합.”
    댓글을 달고, 게시판에 글 쓰고, 회원가입하고...
    DB 서버에 저장이 되는 것.
    
    MySQL 잘하면 Oracle 따라옵니다. Microsoft SQL 서버도요.
    Oracle이 먹고 변질된 MYSQL 보고 만든게 MariaDB., 개발자 입장에서 두 개가 흡사해.
    
    auto increment : 1씩 증가한다.
    
    레코드 : 각 행에 입력된 일련의 정보라고 이해했다.
    
    쿼리 실행 드래그 → 선택 실행
    
    - 쿼리문
        
        
        select * from
        
        INSERT tblName (attr1, attr2, attr3, attr4)
        VALUES ('연호주', '010-4***-2***', '벽산아파트','도서부');
        
        Update
        
        delete from
        
        CREATE 예시
        
        ```sql
        CREATE TABLE tblMember(
         	id int AUTO_INCREMENT PRIMARY KEY,
         	name char(20) NOT NULL,
         	phone char(20) NOT NULL,
           address char(50) NOT NULL,
         	team char(20) NOT NULL   
        )COLLATE='utf8_general_ci'
        ENGINE=InnoDB;
        ```
        
    
    - 자바와 연결
        
        자바에서는 MySQL, 오라클 등이 각각 제공하는 드라이버 클래스가 필요하다.
        .Java Build Path  → Add (...) JARS → 
        
    
