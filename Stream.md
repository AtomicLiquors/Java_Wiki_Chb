[<< 메인으로](https://github.com/AtomicLiquors/Java_Wiki_Chb/blob/main/Readme.md)

&nbsp;
  
&nbsp;

# 스트림
[*] 입출력의 스트림과 다른 개념이다.
지금까지 우리는 많은 수의 데이터를 다룰 때,  
컬렉션이나 배열에 데이터를 담은 뒤  
for문과 Iterator를 이용해 코드를 작성해 왔다.  
- 그러나 이런 코드는 가독성이 낮고, 재사용성도 떨어진다.
- 또한 데이터 소스마다 다른 방식으로 다뤄야 한다는 단점이 있다.  
각 컬렉션 클래스에는 같은 기능의 메서드들이 중복 정의되어 있다.  
(List를 정렬할때는 Collections.sort()를 쓰고, 배열을 정렬할 때는 Arrays.sort()를 쓰는 등)

이런 문제점을 해결하기 위해 만든 것이 스트림*Stream*이다. 
- 데이터 소스를 추상화하고, 데이터를 다루는 메서드를 정의하였다.
데이터 소스가 무엇이든 같은 방식으로 다룰 수 있고,  
코드의 재사용성을 높였다는 의미다.

 
&nbsp;

- 스트림은 데이터 소스를 읽기만 하며, 소스를 변경하지 않는다.
- 스트림은 Iterator처럼 일회용이다.   
Iterator로 컬렉션 요소를 전부 읽고 나면 다시 사용할 수 없듯이,  
스트림도 한번 사용하면 다시 사용할 수 없으며,  
또 필요하다면 다시 생성해야 한다.
- 스트림은 작업을 내부반복으로 처리한다.  
스트림을 통해 간결한 작업이 가능한 이유.

 
&nbsp;
 

### 예시) 
```java
//배열 strArr, 그리고 똑같은 내용을 가진 리스트 strList가 있을 떼
String[] strArr = {"aaa","ddd","ccc"};
List<String> strList = Arrays.asList(strArr);

//두 데이터 소스를 기반으로 다음과 같이 스트림을 생성할 수 있다.
Stream<String> strStream1 = strList.stream();
Stream<String> strStream2 = strList.stream(strArr);
```

```java
/*Before*/
//배열과 리스트의 데이터 정렬
Arrays.sort(strArr);
Collections.sort(StrList);

//for문을 이용한 출력
for(String str : strArr)
    System.out.println(str);

for(String str : strList)
    System.out.println(str);


/*After*/
//Stream을 이용한 데이터 정렬 + 출력(단, 실제 데이터가 정렬되는 것은 아니다.)
strStream1.sorted().forEach(System.out::println);
strStream2.sorted().forEach(System.out::println);

//가독성도 좋고,  자료형에 구애받지 않아 재사용성도 높다!
```

 
&nbsp;
 


## Stream 연산
스트림이 제공하는 다양한 연산을 이용해 복잡한 작업을 간단히 처리할 수 있다.

- 중간 연산 : 연산 결과를 스트림으로 반환한다. 따라서 중간 연산을 연속해서 연결하는 것이 가능하다.
- 최종 연산 : 연산 결과가 스트림이 아니며, 스트림의 요소를 소모하므로 단 한 번만 연산이 가능하다.
```java
stream.distinct().limit(5).sorted().forEach(System.out::println)
//중간 연산 distinct, limit, sorted를 거쳐 최종 연산 forEach로 이어진다.
```

### 지연된 연산
사실 최종 연산이 수행되기 전까지는 중간 연산은 수행되지 않는다.  
중간 연산이 호출된다고 즉시 연산이 수행되는 게 아니라,   
단지 어떤 작업을 수행할 것인지 지정하는 것뿐이다.  
최종 연산이 수행되어야 비로소 스트림의 요소들이 중간 연산을 거쳐 최종 연산에서 소모된다.

### 병렬 스트림
13장 fork&join 공부하고 818p로 돌아오자.

