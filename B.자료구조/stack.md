
스택 알고리즘은 for문을 쓰지 말 것!
```java
for(int i = 0; i < stack.size(); i++){
    } 
```
스택 사이즈는 유동적이기 때문에 중간에 반복문이 끊겨버린다.

&nbsp;  
다음과 같은 걸로 대체하자.
```java
while(stack.size()>0)
```