
- 상속

자바는 재귀보다는 상속이 많이 나옵니다.
    
    ```jsx
    /*
    class A3{}
    class B3{}
    class C3 extends A3, B3{} 
    -> 자바는 다중 상속을 허용하지 않는다. 그래서, 여러 개의 클래스로부터 상속받을 수는 없다.
    */
    
    class A3{}
    class B3 extends A3{}
    class C3 extends B3{} 
    //이처럼 부모는 하나뿐이다.  
    //이는 상속 구조를 명확히 하기 위함이다.
    ```
    

- 상속
    
    ```jsx
    package ch04;
    
    class SuperClass5{
    	SuperClass5(int i){}
    }
    
    class SubClass5 extends SuperClass5{
    
    }
    
    public class ConstructorEx5{
    	
    }
    
    코드를 이렇게만 쓰면 오류가 난다. 왜?
    Superclass5(int i){} ->여기서 int와 관련이 있다.
    디폴트 생성자의 첫번째 라인에 오는 super()형태의 생성자는
    정의가 되어 있지 않다.
    
    ...
    class SubClass5 extends SuperClass5{
    	SubClass5(){
    		super();
    	}
    }
    반드시 생성자 첫번째 라인에 와야 한다.
    부모 객체가 먼저 생성이 되어야 하니까.
    그런데 super();랑 같은 형태가 아니라, 매개변수 int가 들어갔잖아.
    부모 클래스에다가 SuperClass5(){} 를 넣든지,
    형식에 맞게끔 super 안에 정수를 넣어 주든지 해야 한다.
    
    ```
    
    ```jsx
    class SuperClass5{
    	SuperClass5(int i){}
    }
    
    class SubClass 
    ```
    
    ```jsx
    package ch04;
    
    class Constructor6 extends Object {
    	
    	Constructor6(){
    		//매개변수가 String인 생성자 호출
    		this("msg");//반드시 생성자의 첫 번째 라인에 온다.
    		
    	}
    	
    	Constructor6(int i){
    		this("msg");
    	}
    	
    	Constructor6(String s){
    		super();
    	}
    
    }
    ```
    
      
      
상속 시 생성자  


```
package ch04;

class SuperClass5{
	SuperClass5(int i){}
}

class SubClass5 extends SuperClass5{

	SubClass5(int i) {
		super(i);
	}
	
}

public class ConstructorEx5{
	
}
```
