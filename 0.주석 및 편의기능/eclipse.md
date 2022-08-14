[<< 메인으로](https://github.com/AtomicLiquors/Java_Wiki_Chb)
# [0.주석 및 편의기능](https://github.com/AtomicLiquors/Java_Wiki_Chb/blob/main/0.%EC%A3%BC%EC%84%9D%20%EB%B0%8F%20%ED%8E%B8%EC%9D%98%EA%B8%B0%EB%8A%A5/README.md)

### 이클립스 편의기능

> 이클립스는 기본적으로 비영리 단체며, 점유율로 승부합니다.
<br>

### 블록 주석
    - // : ctrl + /, 다시 단축키로 주석해제 가능
    - /* : ctrl + shift + /, 단축키로 주석해제 불가능

- ~~클래스 다이어그램~~
    
    ~~플러그인 설치 후 new > other >
    java 파일을 끌어오면 어떤 클래스를 이용했는지 도식적으로 보여준다.
    이는 ppt에도 매우 유용하다.~~  
    지원이 끊겼다는데 대체재 확인바람. 
    
- 드롭다운 메뉴를 펼쳐서 실행된 파일이 어떤 파일인지 확인할 수 있다.
    
    만약에 main함수를 안 썼거나 해서 엉뚱한 파일이 실행된 경우,
    그 파일이 어떤 파일인지 확인할 수 있다.
    
### 자동 임포트
- 자동 임포트 : Ctrl Shift O  

### 자동 정렬
- 자동 정렬 : ctrl +  shift + f
(우클릭 > source > format에 해당하는 기능이다.)
- 파일명이 적힌 탭을 더블클릭하면 → 디렉토리 창 열기/닫기.
- Ctrl Alt 방향키 : 열려있는 파일 간 탭 이동.
- 자동 완성 : ctrl + space
    - 자주 쓰는 키워드 : sysout, main, ...
- 호출된 메소드에 대고 ctrl을 누르면 선언부로 올라간다.
- 코드가 너무 길다면 좌측 +, - 로 일부 코드를 숨길 수 있다.

- 변수명 동시에 변경 : alt shift R

- 더블클릭 > alt shitf T(Refactor) > Rename ‘변수명 동시에 바꾸기”
    
### 사용자 지정 자동완성 

Window > Preference > Java > Editor > Templates
<br>
##### 지정해두면 좋은 구문
- ss -> System.out.println();
- bfr -> BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
br.close();
- bfw -> BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
bw.write( );
bw.flush();
bw.close();

### 한글 세팅 : 

Window > Preference > workspace > Text file enconding → others(UTF-8)

Window > Preference > Spelling > Encoding → UTF-8

