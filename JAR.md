https://docs.oracle.com/javase/8/docs/technotes/guides/jar/jar.html
<<메인으로

&nbsp;  

# JAR
*Java Archive*
META-INF 디렉토리를 포함할 수 있는 zip 파일. 

&nbsp;  

JAR 파일은 널리 사용되는 ZIP 파일 형식을 기반으로 하는 파일 형식이며. 

### 생성
JAR 파일은 커맨드라인의 jar 도구 또는 Java 플랫폼의 java.util.jar API를 사용하여 만들 수 있습니다.
(커맨드라인에서 실습할 수 있을까?)

대부분의 경우 JAR 파일은 Java 클래스 파일 및/또는 리소스의 단순한 아카이브가 아닙니다.   
응용 프로그램 및 확장을 위한 빌딩 블록으로 사용됩니다.   
META-INF 디렉토리가 있는 경우 보안, 버전 관리, 확장 및 서비스를 포함한 패키지 및 확장 구성 데이터를 저장하는 데 사용됩니다.  

(빌드와 압축 해제의 차이는?)

## META-INF 디렉토리
META-INF 디렉토리의 다음 파일/디렉토리는 애플리케이션, 확장, 클래스 로더 및 서비스를 구성하기 위해 Java 2 플랫폼에서 인식 및 해석됩니다.  

```
MANIFEST.MF
```
확장 및 패키지 관련 데이터를 정의하는 데 사용되는 매니페스트 파일입니다.

```
INDEX.LIST
```
이 파일은 애플리케이션 또는 확장에 정의된 패키지에 대한 위치 정보를 포함하는 jar 도구 의 새 " -i" 옵션에 의해 생성됩니다.   
JarIndex 구현의 일부이며 클래스 로딩 프로세스를 가속화하기 위해 클래스 로더에서 사용됩니다.

```
x.SF
```
JAR 파일의 서명 파일입니다. 'x'는 기본 파일 이름을 나타냅니다.

```
x.DSA
```
기본 파일 이름이 동일한 서명 파일과 연결된 서명 블록 파일입니다. 이 파일은 해당 서명 파일의 디지털 서명을 저장합니다.
```
services/
```
이 디렉토리는 모든 서비스 공급자 구성 파일을 저장합니다.


### [*] 이름-값 쌍 및 섹션
각 구성 파일을 살펴보기 전에 관습적 형식을 먼저 짚고 가겠습니다.
매니페스트 파일 및 서명 파일에 포함된 정보는 대부분 헤더*header* 또는 속성*attributes*이라 불리는 "name: value" 쌍으로 표시됩니다. (RFC822 표준과 흡사)    
헤더(속성)을 묶은 그룹을 "섹션"이라고 하며, 빈 줄을 사용하여 각 섹션이 구분됩니다.

- 모든 형식의 이진 데이터(다이제스트, 서명 등)는 base64로 표시됩니다.   
줄 길이가 72바이트를 초과하는 이진 데이터에는 Continuation이 필요합니다.   

- 구현은 최대 65535바이트의 헤더 값을 지원해야 합니다.

이 문서의 모든 사양은 터미널 기호는 고정폭 글꼴로 표시되고 비터미널 기호는 이탤릭체로 표시되는 동일한 문법을 ​​사용합니다.
<!--
사양:
  섹션: *헤더 +줄바꿈
  비공백-섹션: +헤더 +줄 바꿈 줄
  바꿈:                      CR LF | LF | CR ( LF 가 뒤따르지 않음 ) 헤더: 이름 : 값   이름: 영숫자 *headerchar   값:                          SPACE * otherchar newline *continuation continuation:               SPACE *otherchar newline 영숫자 : { AZ } | { 아즈 } | { 0-9 } headerchar: 영숫자 | - |
 


 
 
  _
  otherchar: NUL, CR 및 LF 를 제외한 모든 UTF-8 문자
; 또한: 일반 이메일을 통해 전송된 파일의 맹글링을 방지하려면
; 헤더는 "From"이라는 네 글자로 시작합니다.

상기 명세서에서 정의된 비단말 기호는 이어지는 명세서에서 참조한다.
-->



## JAR 매니페스트
JAR 파일 매니페스트는 메인 섹션 + 개별 JAR 파일 엔트리에 대한 섹션 목록으로 구성되어 있으며, 각 섹션은 개행으로 구분됩니다.
A JAR file manifest consists of a main section followed by a list of sections for individual JAR file entries, each separated by a newline. 
기본 섹션과 개별 섹션은 모두 위에 지정된 섹션 구문을 따릅니다.     
각각 고유한 제한 사항과 규칙이 있습니다.  

### 기본 섹션
기본 섹션에는 [ JAR 파일 자체 / 해당 JAR 파일이 속한 애플리케이션 또는 확장에 대한 보안 및 구성 정보 ]가 포함되어 있습니다.   
또한 모든 개별 매니페스트 항목에 적용되는 기본 속성을 정의합니다.   
이 섹션의 어떤 속성도 " Name "과 같은 이름을 가질 수 없습니다. 이 섹션은 빈 줄로 끝납니다.

### 개별 섹션
개별 섹션은 이 JAR 파일에 포함된 패키지 또는 파일에 대한 다양한 속성을 정의합니다.   
JAR 파일의 모든 파일이 매니페스트에 항목으로 나열될 필요는 없지만 서명할 모든 파일이 나열되어야 합니다.   
매니페스트 파일 자체는 나열되지 않아야 합니다.   
각 섹션은 이름이 " Name "인 속성으로 시작해야 하며 값은 파일에 대한 상대 경로이거나 아카이브 외부의 데이터를 참조하는 절대 URL이어야 합니다.

동일한 파일 항목에 대한 개별 섹션이 여러 개인 경우 이러한 섹션의 속성이 병합됩니다. 특정 속성이 다른 섹션에서 다른 값을 갖는 경우 마지막 속성이 인식됩니다.

이해되지 않는 속성은 무시됩니다. 이러한 속성에는 응용 프로그램에서 사용하는 구현 관련 정보가 포함될 수 있습니다.
<!--
매니페스트 상세:
  매니페스트 파일: 메인 섹션 줄 바꿈 *개별 섹션
  메인 섹션: 버전 정보 줄 바꿈 *주 속성
  버전 정보:                      매니페스트 버전 : 버전 번호
  버전 번호 : 숫자+{ . digit+}*
  main-attribute: (합법적인 주요 속성) newline
  individual-section:             이름: value newline *perentry-attribute
  perentry-attribute: (합법적인 모든 perentry 속성) newline
  newline :                             CR LF | LF | CR ( 뒤에 LF 가 오지 않음 )
   숫자:                                 {0-9} 
위 명세에서 메인 섹션에 나타날 수 있는 속성을 메인 속성이라고 하고 개별 섹션에 나타날 수 있는 속성을 항목별 속성이라고 합니다. 특정 속성은 기본 섹션과 개별 섹션 모두에 나타날 수 있으며, 이 경우 항목별 속성 값이 지정된 항목의 기본 속성 값을 재정의합니다. 두 가지 유형의 속성은 다음과 같이 정의됩니다.
-->

### 주요 속성
기본 속성은 매니페스트의 기본 섹션에 있는 속성입니다. 그들은 다음과 같은 다른 그룹에 속합니다.
|속성|설명|
|:--|:--:|
|Manifest-Version|매니페스트 파일 버전을 정의합니다. <br>값은 위 사양에 설명된 대로 합법적인 버전 번호입니다.|
|Created-By|이 매니페스트 파일이 생성되는 Java 구현의 버전 및 공급업체를 정의합니다. <br>이 속성은 jar 도구에 의해 생성됩니다.|
|서명 버전|jar 파일의 서명 버전을 정의합니다.|
|Class-Path|이 애플리케이션 또는 확장에 필요한 확장 또는 라이브러리의 상대 URL을 지정합니다. <br>|
URL은 하나 이상의 공백으로 구분됩니다. 애플리케이션 또는 확장 클래스 로더는 이 속성의 값을 사용하여 내부 검색 경로를 구성합니다. 자세한 내용은 클래스 경로 속성 섹션을 참조하십시오.
|독립 실행형 애플리케이션에 대해 정의된 속성|이 속성은 " java -jar x.jar " 를 실행하여 Java 런타임에서 직접 호출할 수 있는 <br>실행 가능한 jar 파일에 번들된 독립 실행형 애플리케이션에서 사용됩니다 .|
(후략)
<!--
: 
Main-Class: 이 속성의 값은 실행 프로그램이 시작 시 로드할 기본 애플리케이션 클래스의 클래스 이름입니다. 값 에는 클래스 이름에 추가된 .class 확장자 가 없어야 합니다.
애플릿에 대해 정의된 속성: 더 이상 사용되지 않음: 이러한 속성과 이를 구현하는 메커니즘은 향후 릴리스에서 제거될 수 있습니다. 이러한 속성은 이 애플릿이 의존하는 확장에 대한 요구 사항, 버전 및 위치 정보를 정의하기 위해 JAR 파일에 번들로 제공되는 애플릿에서 사용됩니다. ( 확장 버전 관리 참조 ).
Extension-List: 이 속성은 애플릿에 필요한 확장자를 나타냅니다. 이 속성에 나열된 각 확장에는 애플릿이 필요한 확장의 버전과 공급업체를 지정하는 데 사용하는 추가 속성 세트가 있습니다.
<extension>-Extension-Name: 이 특성은 확장의 고유한 이름입니다. Java Plug-in은 이 속성의 값을 설치된 확장의 매니페스트에 있는 Extension-Name 속성과 비교하여 확장이 설치되었는지 확인합니다.
<extension>-Specification-Version: 이 속성은 애플릿에 필요한 최소 확장 사양 버전을 지정합니다. Java Plug-in은 이 속성의 값을 설치된 확장의 사양-버전 속성과 비교하여 확장이 최신인지 확인합니다.
<extension>-Implementation-Version: 이 속성은 애플릿에 필요한 최소 확장 구현 버전 번호를 지정합니다. Java Plug-in은 이 속성의 값을 설치된 확장의 구현 버전 속성과 비교하여 최신 구현을 다운로드해야 하는지 확인합니다.
<extension>-Implementation-Vendor-Id: 이 속성은 애플릿이 특정 공급업체의 구현을 요구하는 경우 확장 구현의 공급업체를 식별하는 데 사용할 수 있습니다. Java Plug-in은 이 속성의 값을 설치된 확장의 Implementation-Vendor-Id 속성과 비교합니다.
<extension>-Implementation-URL: 이 속성은 필요한 버전이 아직 설치되지 않은 경우 확장의 최신 버전을 얻는 데 사용할 수 있는 URL을 지정합니다.
확장 식별을 위해 정의된 속성: 이 속성은 확장에서 고유 ID를 정의하는 데 사용됩니다.
Extension-Name: 이 속성은 Jar 파일에 포함된 확장의 이름을 지정합니다. 이름은 확장을 구성하는 기본 패키지의 이름과 같은 고유한 식별자여야 합니다.
확장 및 패키지 버전 관리   및 봉인 정보에 대해 정의된 속성: 이러한 속성은 JAR 파일이 속한 확장의 기능을 정의합니다. 이러한 속성의 값은 JAR 파일의 모든 패키지에 적용되지만 항목별 속성으로 대체될 수 있습니다.
구현-제목: 값은 확장 구현의 제목을 정의하는 문자열입니다.
Implementation-Version: 값은 확장 구현의 버전을 정의하는 문자열입니다.
구현-공급업체: 값은 확장 구현을 유지 관리하는 조직을 정의하는 문자열입니다.
Implementation-Vendor-Id: Deprecated: 이 속성은 향후 릴리스에서 무시될 수 있습니다. 값은 확장 구현을 유지 관리하는 조직을 고유하게 정의하는 문자열 ID입니다.
구현 URL: 사용되지 않음: 이 속성은 향후 릴리스에서 무시될 수 있습니다. 이 속성은 확장 구현을 다운로드할 수 있는 URL을 정의합니다.
사양-제목: 값은 확장 사양의 제목을 정의하는 문자열입니다.
사양-버전: 값은 확장 사양의 버전을 정의하는 문자열입니다.
사양-공급업체: 값은 확장 사양을 유지 관리하는 조직을 정의하는 문자열입니다.
Sealed: 이 속성은 이 JAR 파일이 봉인되었는지 여부를 정의합니다. 값은 "true" 또는 "false"일 수 있으며 대소문자는 무시됩니다. "true"로 설정되면 JAR 파일의 모든 패키지는 별도로 정의되지 않는 한 기본적으로 봉인됩니다.
항목별 속성
항목별 속성은 매니페스트 항목이 연결된 개별 JAR 파일 항목에만 적용됩니다. 동일한 속성이 기본 섹션에도 나타나면 항목별 속성 값이 기본 속성 값을 덮어씁니다. 예를 들어 JAR 파일 a.jar에 다음 매니페스트 콘텐츠가 있는 경우:
매니페스트 버전: 1.0
작성자: 1.2(Sun Microsystems Inc.)
봉인: 사실
이름: 푸/바/
봉인: 거짓
이는 a.jar에 보관된 모든 패키지가 봉인되어 있음을 의미합니다. 단, 패키지 foo.bar는 봉인되어 있지 않습니다.

항목별 속성은 다음 그룹으로 분류됩니다.

파일 내용에 대해 정의된 속성:
Content-Type: 이 속성은 JAR 파일의 특정 파일 항목에 대한 데이터의 MIME 유형 및 하위 유형을 지정하는 데 사용할 수 있습니다. 값은 유형/하위 유형 형식의 문자열이어야 합니다 . 예를 들어 "image/bmp"는 하위 유형이 bmp(비트맵을 나타냄)인 이미지 유형입니다. 이것은 비트맵으로 저장된 데이터가 있는 이미지로 파일 항목을 나타냅니다. RFC 1521 및 1522 는 MIME 유형 정의를 논의하고 정의합니다.
패키지 버전 및 봉인 정보에 대해 정의된 속성: 확장 패키지 버전 및 봉인 정보를 정의하는 기본 속성으로 위에서 정의된 동일한 속성 집합입니다. 항목별 속성으로 사용될 때 이러한 속성은 기본 속성을 덮어쓰지만 매니페스트 항목에서 지정한 개별 파일에만 적용됩니다.
빈 개체에 대해 정의된 속성:
Java-Bean: 특정 jar 파일 항목이 Java Beans 객체인지 여부를 정의합니다. 값은 "true" 또는 "false"여야 하며 대소문자는 무시됩니다.
서명을 위해 정의된 속성: 이러한 속성은 서명 및 확인 목적으로 사용됩니다. 자세한 내용은 여기를 참조하세요.
x-Digest-y: 이 속성의 이름은 해당 jar 파일 항목에 대한 다이제스트 값을 계산하는 데 사용되는 다이제스트 알고리즘의 이름을 지정합니다. 이 속성의 값은 실제 다이제스트 값을 저장합니다. 접두사 'x'는 알고리즘 이름을 지정하고 선택적 접미사 'y'는 다이제스트 값을 확인해야 하는 언어를 나타냅니다.
매직: 이는 검증자가 매니페스트 항목에 포함된 다이제스트 값을 계산하는 방법을 나타내기 위해 애플리케이션에서 사용할 수 있는 선택적 속성입니다. 이 속성의 값은 쉼표로 구분된 컨텍스트 특정 문자열 세트입니다. 자세한 설명은 여기에 있습니다.
서명된 JAR 파일
개요
JAR 파일은 명령줄 jarsignerjava.security 도구를 사용하거나 API 를 통해 직접 서명할 수 있습니다. 디렉토리 의 비서명 관련 파일을 포함한 모든 파일 항목 META-INF은 JAR 파일이 jarsigner 도구로 서명된 경우 서명됩니다. 서명 관련 파일은 다음과 같습니다.
META-INF/MANIFEST.MF
META-INF/*.SF
META-INF/*.DSA
META-INF/*.RSA
META-INF/SIG-*
이러한 파일이 META-INF 하위 디렉토리에 있는 경우 서명 관련 파일로 간주되지 않습니다. 이러한 파일 이름의 대소문자를 구분하지 않는 버전은 예약되어 있으며 서명되지 않습니다.
JAR 파일의 하위 집합은 java.securityAPI를 사용하여 서명할 수 있습니다. 서명된 JAR 파일은 해당 매니페스트가 업데이트되고 디렉터리에 두 개의 추가 파일 META-INF (서명 파일 및 서명 블록 파일)이 추가된다는 점을 제외하면 원본 JAR 파일과 정확히 동일합니다. jarsigner를 사용하지 않는 경우 서명 프로그램은 서명 파일과 서명 블록 파일을 모두 구성해야 합니다.

서명된 JAR 파일에 서명된 모든 파일 항목에 대해 매니페스트에 아직 존재하지 않는 한 개별 매니페스트 항목이 생성됩니다. 각 매니페스트 항목에는 하나 이상의 다이제스트 속성과 선택적 Magic 속성 이 나열 됩니다.

서명 파일
각 서명자는 확장자가 인 서명 파일로 표시됩니다 .SF. 파일의 주요 부분은 매니페스트 파일과 유사합니다. 서명자가 제공한 정보를 포함하지만 특정 jar 파일 항목에 특정하지 않은 기본 섹션으로 구성됩니다. Signature-Version및 Created-By 속성( 주요 속성 참조) 외에도 기본 섹션에는 다음과 같은 보안 속성이 포함될 수 있습니다.
x-Digest-Manifest-Main-Attributes(여기서 x는 java.security.MessageDigest알고리즘의 표준 이름임): 이 속성의 값은 매니페스트의 주요 속성에 대한 다이제스트 값입니다.
x-Digest-Manifest(여기서 x는 java.security.MessageDigest알고리즘의 표준 이름): 이 속성의 값은 전체 매니페스트의 다이제스트 값입니다.
기본 섹션 다음에는 이름이 매니페스트 파일에도 있어야 하는 개별 항목 목록이 옵니다. 각 개별 항목에는 적어도 매니페스트 파일에서 해당 항목의 다이제스트가 포함되어야 합니다.
매니페스트 파일에는 나타나지만 서명 파일에는 나타나지 않는 경로 또는 URL은 계산에 사용되지 않습니다.

서명 유효성 검사
성공적인 JAR 파일 확인은 서명이 유효하고 서명이 생성되었을 때 JAR 파일에 있던 파일이 그 이후로 변경되지 않은 경우 발생합니다. JAR 파일 확인에는 다음 단계가 포함됩니다.
매니페스트가 처음 구문 분석될 때 서명 파일을 통해 서명을 확인합니다. 효율성을 위해 이 확인을 기억할 수 있습니다. 이 확인은 실제 아카이브 파일이 아닌 서명 방향 자체의 유효성만 확인한다는 점에 유의하십시오.

서명 파일에 속성이 있는 경우 x-Digest-Manifest전체 매니페스트에 대해 계산된 다이제스트에 대해 값을 확인합니다. 서명 파일에 둘 이상의 x-Digest-Manifest속성이 있는 경우 그 중 하나 이상이 계산된 다이제스트 값과 일치하는지 확인하십시오.

서명 파일 에 x-Digest-Manifest속성이 없거나 이전 단계에서 계산된 다이제스트 값이 일치하지 않으면 덜 최적화된 확인이 수행됩니다.

서명 파일에 항목이 있는 경우 x-Digest-Manifest-Main-Attributes매니페스트 파일의 기본 특성에 대해 계산된 다이제스트에 대해 값을 확인합니다. 이 계산이 실패하면 JAR 파일 확인이 실패합니다. 이 결정은 효율성을 위해 기억할 수 있습니다. 서명 파일에 항목이 없으면 해당 x-Digest-Manifest-Main-Attributes항목이 없어도 JAR 파일 확인에 영향을 미치지 않으며 매니페스트 기본 속성이 확인되지 않습니다.

매니페스트 파일의 해당 항목에 대해 계산된 다이제스트 값에 대해 서명 파일의 각 소스 파일 정보 섹션의 다이제스트 값을 확인합니다. 다이제스트 값이 일치하지 않으면 JAR 파일 확인이 실패합니다.

속성 에 저장된 매니페스트 파일 x-Digest-Manifest의 다이제스트 값이 현재 매니페스트 파일의 다이제스트 값과 같지 않을 수 있는 한 가지 이유는 하나 이상의 파일이 서명 후(jar 도구 사용) JAR 파일에 추가되었기 때문입니다. 서명 파일)이 생성되었습니다. jar 도구를 사용하여 파일을 추가하면 매니페스트 파일이 변경되지만(새 파일에 대한 섹션이 추가됨) 서명 파일은 변경되지 않습니다. 서명이 생성되었을 때 JAR 파일에 있던 파일 중 그 이후로 변경된 파일이 없는 경우(즉, 서명 파일의 비헤더 섹션에 있는 다이제스트 값이 다이제스트 값과 동일한 경우) 확인은 여전히 ​​성공한 것으로 간주됩니다. 매니페스트 파일의 해당 섹션.

매니페스트의 각 항목에 대해 상대 파일 경로 또는 URL을 지정하는 "Name:" 속성에서 참조되는 실제 데이터에 대해 계산된 다이제스트에 대해 매니페스트 파일의 다이제스트 값을 확인합니다. 다이제스트 값이 일치하지 않으면 JAR 파일 확인이 실패합니다.

예제 매니페스트 파일:

매니페스트 버전: 1.0
작성자: 1.7.0(Sun Microsystems Inc.)

이름: common/class1.class
SHA-256-다이제스트: (SHA-256 다이제스트의 base64 표현)

이름: common/class2.class
SHA1-다이제스트: (SHA1 다이제스트의 base64 표현)
SHA-256-다이제스트: (SHA-256 다이제스트의 base64 표현)
해당 서명 파일은 다음과 같습니다.
서명 버전: 1.0
SHA-256-Digest-Manifest: (SHA-256 다이제스트의 base64 표현)
SHA-256-Digest-Manifest-Main-Attributes: (SHA-256 다이제스트의 base64 표현)

이름: common/class1.class
SHA-256-다이제스트: (SHA-256 다이제스트의 base64 표현)

이름: common/class2.class
SHA-256-다이제스트: (SHA-256 다이제스트의 base64 표현)
마법 속성
지정된 매니페스트 항목의 서명을 검증하기 위한 또 다른 요구 사항은 검증자가 해당 항목의 매니페스트 항목에 있는 Magic 키 쌍 값의 값을 이해하는 것입니다.
Magic 속성은 선택 사항이지만 해당 항목의 서명을 확인하는 경우 구문 분석기가 해당 항목의 Magic 키 값을 이해해야 합니다.

Magic 속성의 값은 쉼표로 구분된 컨텍스트별 문자열 세트입니다. 쉼표 앞뒤의 공백은 무시됩니다. 대소문자는 무시됩니다. 매직 속성의 정확한 의미는 애플리케이션에 따라 다릅니다. 이러한 값은 매니페스트 항목에 포함된 해시 값을 계산하는 방법을 나타내므로 서명의 적절한 확인에 중요합니다. 키워드는 동적 또는 포함된 콘텐츠, 다국어 문서의 다중 해시 등에 사용될 수 있습니다.

다음은 매니페스트 파일에서 Magic 속성을 잠재적으로 사용하는 두 가지 예입니다.

        이름: http://www.example-scripts.com/index#script1
        SHA-256-Digest: (SHA-256 해시의 base64 표현)
        매직: JavaScript, 동적

        이름: http://www.example-tourist.com/guide.html
        SHA-256-Digest: (SHA-256 해시의 base64 표현)
        SHA-256-Digest-French: (SHA-256 해시의 base64 표현)
        SHA-256-Digest-German: (SHA-256 해시의 base64 표현)
        매직: 다국어
첫 번째 예에서 이러한 Magic 값은 http 쿼리의 결과가 문서 자체가 아니라 문서에 포함된 스크립트이며 스크립트가 동적으로 생성됨을 나타낼 수 있습니다. 이 두 가지 정보는 매니페스트의 다이제스트 값을 비교할 해시 값을 계산하여 유효한 서명을 비교하는 방법을 나타냅니다.

두 번째 예에서 Magic 값은 검색된 문서가 특정 언어에 대해 콘텐츠 협상되었을 수 있으며 확인할 다이제스트가 검색된 문서가 작성된 언어에 따라 다르다는 것을 나타냅니다.

디지털 서명
디지털 서명은 .SF 서명 파일의 서명된 버전입니다. 이들은 사람이 해석하도록 의도되지 않은 이진 파일입니다.
디지털 서명 파일은 .SF 파일과 파일 이름이 같지만 확장자가 다릅니다. 확장자는 디지털 서명 유형에 따라 다릅니다.

.RSA(PKCS7 서명, SHA-256 + RSA)
.DSA(PKCS7 서명, DSA)
위에 나열되지 않은 서명 알고리즘에 대한 디지털 서명 파일은 META-INF디렉터리에 있어야 하며 접두사 " SIG-"가 있어야 합니다. 해당 서명 파일( .SFfile)도 동일한 접두사를 가져야 합니다.
외부 서명 데이터를 지원하지 않는 형식의 경우 파일은 서명된 .SF파일 사본으로 구성됩니다. 따라서 일부 데이터는 중복될 수 있으며 검증자는 두 파일을 비교해야 합니다.

외부 데이터를 지원하는 형식은 .SF파일을 참조하거나 암시적 참조로 계산을 수행합니다.

각 .SF파일에는 여러 디지털 서명이 있을 수 있지만 이러한 서명은 동일한 법인에서 생성해야 합니다.

파일 이름 확장자는 1~3 자의 영숫자 일 수 있습니다 . 인식되지 않는 확장자는 무시됩니다.

매니페스트 및 서명 파일에 대한 참고 사항
다음은 매니페스트 및 서명 파일에 적용되는 추가 제한 사항 및 규칙 목록입니다.
파싱하기 전에:
파일의 마지막 문자가 EOF 문자(코드 26)이면 EOF는 공백으로 처리됩니다. 두 개의 줄바꿈이 추가됩니다(하나는 마지막 줄 끝에 줄바꿈을 넣지 않는 편집자를 위한 것이고 다른 하나는 문법이 마지막 항목을 특수한 경우로 지정할 필요가 없기 때문에 그 뒤에 빈 줄이 없을 수 있습니다) ).
속성:
모든 섹션의 모든 경우에 이해되지 않는 속성은 무시됩니다.
속성 이름은 대소문자를 구분하지 않습니다. 그러나 매니페스트 및 서명 파일을 생성하는 프로그램은 이 사양에 표시된 사례를 사용해야 합니다.
속성 이름은 섹션 내에서 반복될 수 없습니다.
버전:
Manifest-Version 및 Signature-Version이 첫 번째에 있어야 하며, 정확히 이 경우에 해당해야 합니다(마법 문자열로 쉽게 인식될 수 있도록). 그 외에는 메인 섹션 내의 속성 순서는 중요하지 않습니다.
주문:
개별 매니페스트 항목의 순서는 중요하지 않습니다.
개별 서명 항목의 순서는 중요하지 않습니다. 단, 서명되는 다이제스트는 해당 순서로 되어 있습니다.
라인 길이:
어떤 라인도 UTF8 인코딩 형식에서 72바이트(문자 아님)보다 길 수 없습니다. 값이 초기 행을 이보다 길게 만들면 추가 행에서 계속되어야 합니다(각각 단일 SPACE로 시작).
오류:
이 사양에 따라 파일을 구문 분석할 수 없는 경우 경고가 출력되어야 하며 신뢰할 수 있는 서명이 없어야 합니다.
제한 사항:
헤더 이름은 연속될 수 없으므로 헤더 이름의 최대 길이는 70바이트입니다(이름 뒤에 콜론과 SPACE가 있어야 함).
NUL, CR 및 LF는 헤더 값에 포함할 수 없으며 NUL, CR, LF 및 ":"은 헤더 이름에 포함할 수 없습니다.
구현은 65535바이트(문자 아님) 헤더 값과 파일당 65535 헤더를 지원해야 합니다. 메모리가 부족할 수 있지만 이 값 아래에 하드 코딩된 제한이 없어야 합니다.
서명자:
서로 다른 엔터티가 서로 다른 서명 알고리즘을 사용하여 단일 서명 파일을 공유하는 것이 기술적으로 가능합니다. 이는 표준을 위반하며 추가 서명이 무시될 수 있습니다.
알고리즘:
다이제스트 또는 서명 알고리즘은 이 표준에 의해 의무화되거나 제한되지 않습니다.
적어도 하나의 다이제스트 알고리즘이 지원되어야 합니다.
다이제스트 알고리즘, 서명 알고리즘 또는 키 크기가 jdk.jar.disabledAlgorithms보안 속성에 의해 제한되는 경우 JAR은 서명되지 않은 것으로 처리됩니다. jdk.jar.disabledAlgorithms보안 속성은 현재 JDK 참조 구현에서 사용됩니다 . 다른 구현에서 검사 및 사용이 보장되지 않습니다.
JAR 색인
개요
1.3부터 ​​JarIndex는 네트워크 애플리케이션, 특히 애플릿에 대한 클래스 로더의 클래스 검색 프로세스를 최적화하기 위해 도입되었습니다. 원래 애플릿 클래스 로더는 간단한 선형 검색 알고리즘을 사용하여 "ARCHIVE" 태그 또는 "Class-Path" 기본 속성에서 구성되는 내부 검색 경로에서 각 요소를 검색합니다. 클래스 로더는 클래스 또는 리소스를 찾을 때까지 검색 경로의 각 요소를 다운로드하고 엽니다. 클래스 로더가 존재하지 않는 리소스를 찾으려고 하면 애플리케이션 또는 애플릿 내의 모든 jar 파일을 다운로드해야 합니다. 대규모 네트워크 응용 프로그램 및 애플릿의 경우 이로 인해 시작 속도가 느려지고 응답이 느려지고 네트워크 대역폭이 낭비될 수 있습니다. JarIndex 메커니즘은 애플릿에 정의된 모든 jar 파일의 내용을 수집하고 애플릿의 클래스 경로에 있는 첫 번째 jar 파일의 인덱스 파일에 정보를 저장합니다. 첫 번째 jar 파일이 다운로드된 후 애플릿 클래스 로더는 효율적인 jar 파일 다운로드를 위해 수집된 콘텐츠 정보를 사용합니다.
기존 jar 도구는 jar 파일 목록을 검사하고 어떤 클래스와 리소스가 어떤 jar 파일에 있는지에 대한 디렉토리 정보를 생성할 수 있도록 향상되었습니다. 이 디렉토리 정보는 루트 jar 파일의 META-INF 디렉토리에 있는 INDEX.LIST 라는 간단한 텍스트 파일에 저장 됩니다. 클래스 로더는 루트 jar 파일을 로드할 때 INDEX.LIST 파일을 읽고 파일 및 패키지 이름에서 jar 파일 이름 목록으로의 매핑 해시 테이블을 구성하는 데 사용합니다. 클래스 또는 리소스를 찾기 위해 클래스 로더는 해시 테이블을 쿼리하여 적절한 jar 파일을 찾은 다음 필요한 경우 다운로드합니다.

클래스 로더가 특정 jar 파일에서 INDEX.LIST 파일을 찾으면 항상 여기에 나열된 정보를 신뢰합니다. 특정 클래스에 대한 매핑이 발견되었지만 클래스 로더가 링크를 따라 매핑을 찾는 데 실패하면 InvalidJarIndexException이 발생합니다. 이 경우 애플리케이션 개발자는 확장에서 jar 도구를 다시 실행하여 색인 파일에 올바른 정보를 가져와야 합니다.

애플리케이션에 너무 많은 공간 오버헤드를 추가하는 것을 방지하고 메모리 내 해시 테이블 구성 속도를 높이기 위해 INDEX.LIST 파일은 가능한 한 작게 유지됩니다. null이 아닌 패키지 이름을 가진 클래스의 경우 패키지 수준에서 매핑이 기록됩니다. 일반적으로 하나의 패키지 이름은 하나의 jar 파일에 매핑되지만 특정 패키지가 둘 이상의 jar 파일에 걸쳐 있는 경우 이 패키지의 매핑된 값은 jar 파일 목록이 됩니다. 비어 있지 않은 디렉터리 접두사가 있는 리소스 파일의 경우 매핑도 디렉터리 수준에서 기록됩니다. 패키지 이름이 null인 클래스와 루트 디렉터리에 있는 리소스 파일에 대해서만 매핑이 개별 파일 수준에서 기록됩니다.

인덱스 파일 사양
INDEX.LIST 파일에는 하나의 빈 줄로 구분된 하나 이상의 섹션이 포함되어 있습니다 . 각 섹션은 특정 jar 파일의 내용을 정의합니다. 헤더는 jar 파일 경로 이름을 정의하고 패키지 또는 파일 이름 목록은 한 줄에 하나씩 있습니다. 모든 jar 파일 경로는 루트 jar 파일의 코드 기반에 상대적입니다. 이러한 경로 이름은 번들 확장에 대한 현재 확장 메커니즘과 동일한 방식으로 확인됩니다.
UTF-8 인코딩은 색인 파일의 파일 또는 패키지 이름에서 ASCII가 아닌 문자를 지원하는 데 사용됩니다.
 

사양
    색인 파일: 버전 정보 공백 섹션*
    버전 정보:               JarIndex-버전: 버전 번호
    버전 번호: 숫자+{.숫자+}*
    섹션: 본문 공백줄
    본문: 헤더 이름*
    헤더: char+ .jar 개행
    이름: char+ 개행
    문자 : NULL, CR 및 LF 를 제외한 모든 유효한 유니코드 문자
    blankline: newline newline
    newline :                       CR LF | LF | CR ( 뒤에 LF 가 오지 않음 )
    숫자:                           { 0-9 } INDEX.LIST 파일은 jar -i를 실행하여 생성
 
됩니다 . 자세한 내용은 jar 매뉴얼 페이지를 참조하십시오.
하위 호환성
새로운 클래스 로딩 체계는 현재 확장 메커니즘 위에 개발된 애플리케이션과 완전히 역호환됩니다. 클래스 로더가 첫 번째 jar 파일을 로드하고 META-INF 디렉토리에서 INDEX.LIST 파일을 찾으면 인덱스 해시 테이블을 구성하고 확장에 대한 새 로드 체계를 사용합니다. 그렇지 않으면 클래스 로더는 단순히 원래의 선형 검색 알고리즘을 사용합니다.
서비스 제공자
개요
META-INF/services 디렉토리에 있는 파일 은 서비스 공급자 구성 파일입니다. 서비스는 잘 알려진 인터페이스 및 (일반적으로 추상) 클래스 집합입니다. 서비스 공급자는 서비스의 특정 구현입니다. 공급자의 클래스는 일반적으로 인터페이스를 구현하고 서비스 자체에 정의된 클래스의 하위 클래스를 구현합니다. 서비스 공급자는 확장의 형태로 Java 플랫폼 구현에 설치할 수 있습니다. 즉, 일반적인 확장 디렉토리에 배치되는 jar 파일입니다. 공급자는 애플릿이나 응용 프로그램 클래스 경로에 추가하거나 다른 플랫폼별 방법을 통해 사용할 수도 있습니다.

서비스는 추상 클래스로 표현됩니다. 지정된 서비스의 제공자는 제공자 고유의 데이터 및 코드로 이 서비스 클래스를 확장하는 하나 이상의 구체적인 클래스를 포함합니다. 이 공급자 클래스는 일반적으로 전체 공급자 자체가 아니라 공급자가 요청 시 실제 공급자를 생성할 수 있는 코드와 함께 특정 요청을 충족할 수 있는지 여부를 결정하는 데 충분한 정보가 포함된 프록시입니다. 공급자 클래스의 세부 사항은 서비스별로 매우 특정한 경향이 있습니다. 어떤 단일 클래스나 인터페이스도 이들을 통합할 수 없으므로 그러한 클래스가 정의되지 않았습니다. 여기서 적용되는 유일한 요구 사항은 공급자 클래스가 조회 중에 인스턴스화될 수 있도록 인수가 없는 생성자를 가져야 한다는 것입니다.

공급자 구성 파일
서비스 제공자는 자원 디렉토리 META-INF/services 에 제공자 구성 파일을 배치하여 자신을 식별합니다 . 파일의 이름은 추상 서비스 클래스의 완전한 이름으로 구성되어야 합니다. 파일에는 줄바꿈으로 구분된 고유한 구체적인 공급자 클래스 이름 목록이 포함되어야 합니다. 공백 및 탭 문자와 빈 줄은 무시됩니다. 주석 문자는 '#'(0x23)입니다. 각 줄에서 첫 번째 주석 문자 다음의 모든 문자는 무시됩니다. 파일은 UTF-8로 인코딩되어야 합니다.

예시
java.io.spi.CharCodec이라는 서비스 클래스가 있다고 가정합니다. 여기에는 두 가지 추상 메서드가 있습니다.
public abstract CharEncoder getEncoder(String encodingName);
public abstract CharDecoder getDecoder(String encodingName);
각 메소드는 적절한 객체를 반환하거나 주어진 인코딩을 변환할 수 없는 경우 null을 반환합니다. 일반적인 CharCodec 공급자는 둘 이상의 인코딩을 지원합니다.

sun.io.StandardCodec이 CharCodec 서비스의 공급자인 경우 해당 jar 파일에는 META-INF/services/java.io.spi.CharCodec 파일이 포함 됩니다. 이 파일에는 다음 한 줄이 포함됩니다.

sun.io.StandardCodec # 플랫폼용 표준 코덱
주어진 인코딩 이름에 대한 인코더를 찾기 위해 내부 I/O 코드는 다음과 같은 작업을 수행합니다.

   CharEncoder getEncoder(문자열 인코딩 이름) {
       반복자 ps = Service.providers(CharCodec.class);
       동안 (ps.hasNext()) {
           CharCodec cc = (CharCodec)ps.next();
           CharEncoder ce = cc.getEncoder(encodingName);
           if (ce!= null)
               반환 CE;
       }
       null을 반환합니다.
   }
공급자 조회 메커니즘은 항상 호출자의 보안 컨텍스트에서 실행됩니다. 신뢰할 수 있는 시스템 코드는 일반적으로 권한 있는 보안 컨텍스트 내에서 이 클래스의 메서드를 호출해야 합니다.

클래스 경로 속성
애플리케이션의 매니페스트는 필요한 다른 라이브러리의 JAR 파일 및 디렉토리를 참조하는 하나 이상의 상대 URL을 지정할 수 있습니다. 이러한 상대 URL은 포함하는 애플리케이션이 로드된 코드 베이스에 상대적으로 처리됩니다.

애플리케이션(또는 보다 일반적으로 JAR 파일)은 매니페스트 속성에 필요한 라이브러리의 상대 URL을 지정합니다 Class-Path. 이 속성은 호스트 JVM(Java Virtual Machine)에서 찾을 수 없는 경우 다른 라이브러리의 구현을 검색하기 위한 URL을 나열합니다. 이러한 상대 URL에는 애플리케이션에 필요한 모든 라이브러리 또는 리소스에 대한 JAR 파일 및 디렉터리가 포함될 수 있습니다. 슬래시( )로 끝나지 않는 상대 URL /은 JAR 파일을 참조하는 것으로 간주됩니다. 예를 들어:

클래스 경로: servlet.jar infobus.jar acme/beans.jar 이미지/
Class-PathJAR 파일의 매니페스트 에는 최대 하나 의 헤더를 지정할 수 있습니다.

현재 URL은 보안상의 이유로 JAR 파일의 코드 베이스에 상대적 이어야 합니다 . 따라서 원격 선택적 패키지는 애플리케이션과 동일한 코드 베이스에서 시작됩니다.

각 상대 URL은 포함하는 애플리케이션 또는 라이브러리가 로드된 코드 베이스에 대해 확인됩니다. 결과 URL이 유효하지 않거나 찾을 수 없는 리소스를 참조하는 경우 무시됩니다.

결과 URL은 포함하는 JAR 파일의 URL 바로 뒤에 있는 클래스 경로에 URL을 삽입하여 애플리케이션, 애플릿 또는 서블릿에 대한 클래스 경로를 확장하는 데 사용됩니다. 중복 URL은 생략됩니다. 예를 들어, 다음 클래스 경로가 주어진 경우:

a.jar b.jar
b.jar다음 Class-Path매니페스트 속성 이 포함되어 있다고 가정 합니다.

클래스 경로: x.jar a.jar
결과적으로 결과 애플리케이션 클래스 경로는 다음과 같습니다.

a.jar b.jar x.jar
자체 종속성이 있는 경우 x.jar각 후속 URL에 대해 동일한 규칙에 따라 추가됩니다. 실제 구현에서 JAR 파일 종속성은 필요할 때까지 JAR 파일이 열리지 않도록 느리게 처리됩니다.
-->

## 패키지 밀봉
패키지 가 버전 내에서 일관성을 유지할 수 있도록 JAR 파일 및 패키지를 선택적으로 봉인 할 수 있습니다.

JAR 내에서 봉인된 패키지는 해당 패키지에 정의된 모든 클래스가 동일한 JAR에서 시작되어야 함을 지정합니다. 그렇지 않으면 a SecurityException가 발생합니다.

봉인된 JAR은 패키지에 대해 특별히 재정의되지 않는 한 해당 JAR에 의해 정의된 모든 패키지가 봉인되도록 지정합니다.

Sealed봉인된 패키지는 값이 true또는 false (대/소문자 상관 없음) 인 매니페스트 속성을 통해 지정됩니다 . 예를 들어:

이름: javax/servlet/internal/
봉인: 사실
이는 javax.servlet.internal패키지가 봉인되고 해당 패키지의 모든 클래스가 동일한 JAR 파일에서 로드되어야 함을 지정합니다.

이 속성이 누락된 경우 패키지 봉인 속성은 포함하는 JAR 파일의 속성입니다.

봉인된 JAR은 동일한 매니페스트 헤더를 통해 지정되며 Sealed값은 다시 true또는 false입니다. 예를 들어:

봉인: 사실
Sealed매니페스트 항목 의 속성을 사용하여 특정 패키지에 대해 명시적으로 재정의하지 않는 한 이 아카이브의 모든 패키지가 봉인되도록 지정합니다 .

이 속성이 없으면 이전 버전과의 호환성을 위해 JAR 파일이 봉인 되지 않은 것으로 간주됩니다. 그런 다음 시스템은 기본적으로 봉인 정보에 대한 패키지 헤더를 검사합니다.

패키지 봉인은 패키지 보호 멤버에 대한 액세스를 동일한 JAR 파일에서 생성된 패키지에 정의된 클래스로만 제한하기 때문에 보안에도 중요합니다.

명명되지 않은 패키지는 봉인할 수 없으므로 봉인할 클래스는 자체 패키지에 배치해야 합니다.

### API 세부정보
패키지 java.util.jar

### 참고
패키지 java.security

패키지 java.util.zip

  
## 블로그 자료
https://rimooworld.tistory.com/9
JAR, WAR, EAR는 모두 Java의 jar 툴을 이용하여 생성된 압축(아카이브)파일이다.
(JDK에서는 각 압축파일들에 접근하여 압축 해제없이 사용할 수 있음.)

압축 파일의 주 역할은 어플리케이션을 쉽게 배포하고 동작시킬 수 있도록 관련 파일(리소스, 속성파일 등)들을 패키징하는 것이다.
[*] Maven 을 이용하여 프로젝트 빌드를 관리했을 경우 다운로드된 라이브러리들은 class파일들이 묶인 jar파일로 구성되어 있는 것을 확인할 수 있다.  
[*] 서비스 배포시에는 프로젝트를 WAR 포맷으로 묶어서 /wepapps 등의 지정된 경로에 넣고 Tomcat 등의 웹 컨테이너(Web container)를 이용하여 deploy하는 식으로 서비스를 많이 올린다.  

### JAR(Java Archive)
.jar 확장자 파일에는 Class 와 같은 Java 리소스와 속성파일, 라이브러리 및 액세서리 파일이 포함되어 있다.
즉, Java 어플리케이션이 동장학 수 있도록 Java 프로젝트를 압축한 파일이 바로 .jar 파일이다.

JAR 파일의 구조는 windows zip 파일과 동일한 구조이지만 플랫폼에 귀속되는 점은 다르다.  
JAR파일은 원하는 구조로 구성할 수 있고, JDK(Java Development Kit)가 포함하고 있는 JRE(Java Runtime Environm,ent)만 가지고도 실행이 가능하다.

jar 형태로 구성이 되는 경우 ClassLoader에 의해 로드되는 객체들은 jar의 root에 위치하게 된다.  

META-INF의 MANIFEST.MF 파일에는 매니페스트 버전, 빌드한 사용자, 빌드 jdk 버전, 빌드 툴 등의 정보가 포함되어 있다. 즉, jar 파일에 대한 manual이나 spec을 기록하는 폴더이다.  

### WAR(Web Application Archive)
.war 확장자 파일은 servlet / jsp 컨테이너에 배치할 수 있는 웹 어플리케이션 압축파일 포맷이다.  

JSP, SERVLET, JAR, CLASS, XML, HTML, JAVASCRIPT 등 Servlet Context 관련 파일들로 패키징 되어 있다.  

WAR파일은 JAR파일의 JAR옵션을 이용해 생성되기 때문에 웹 어플리케이션 전체를 패키징하기 위한 JAR파일이라고 볼 수 있다.  

WAR로 패키징하는 경우 META-INF 폴더는 jar와 동일하게 만들어지고, WEB-INF가 하나 더 생긴다.  
WEB-INF는 외부 라이브러리와 개발된 어플리케이션의 컴파일된 클래스파일(객체_이 위치하는 classes 폴더를 포함한다.(jar는 ClassLoader에 의해 로드된 객체가 root에 위치하게 된다.)  

WAR 파일은 JAR포맷과 달리 **WEB-INF, META-INF** 디렉토리로 구조가 사전 정의되어 있고,   
웹 어플리케이션을 어떻게 설정할 지에 대한 정의가 있는 **web.xml** 파일이 있다.   
WEB-INF에 속한 web.xml파일은 web application 구성을 결정해준다.   
필터, 서블릿, DB source 등 web container가 구동하는데 이용되는 환경 설정 파일인 것이다.

그렇기 때문에 WAR파일을 실행하려면 Tomcat, Weblogic, Websphere 등의 **웹 서버(WEB) 또는 웹 컨테이너(WAS)가 필요하다.**  

서버가 처음 로딩될 때 web.xml을 읽어 환경설정에 대한 어플리케이션 배치를 한다. web.xml에 들어가는 환경설정에서 다음과 같은 설정을 줄 수 있다.

필터 정보(매핑 포함), 서블릿 정보(매핑 포함), 웹 어플리케이션 정보, 세션 정보, 세션 정보가 소멸, 생성, 수정되는 것을 알려주는 리스너 정보, MIME 매핑, welcomefile 정보, errorPage 정보, url 보호정보, Enterprise bean 홈 레퍼런스 정보(로컨 레퍼런스 정보 포함)  
WAR는 웹 응용 프로그램을 위한 포맷이기 때문에 웹 관련 자원만 포함한다. 이를 사용하면 웹 어플리케이션을 쉽게 배포하고 테스트할 수 있다.  

### EAR(Enterprise Archive File)
JAVA EE(Enterprise Edition) 에 쓰이는 JAR 파일 형식중 한 종류.

한 개 이상의 모듈을 단일 아카이브로 패키징 하여 어플리케이션 서버에 동시에 일관적으로 올리기 위하여 사용되는 포맷. 즉, 실제 서버에서 배포하기 위한 단위이다.

Enterprise application에 필요한 모든 파일을 포함한다.(jar, war 등등)

### 요약

JAR와 WAR, EAR는 모두 압축파일이고 어플리케이션을 쉽게 배포하고 동작시키기 위해 Java의 jar 툴을 이용해서 압축한 파일이라 구조적 차이가 없고, 확장자를 바꿔도 문제가 없다.  
JAR와 WAR의 사용목적이 다르다.  
JAR는 library나 일반 application을 배포할 때  
WAR는 web application을 배포할 때  
파일 규모 : EAR > WAR > JAR  
