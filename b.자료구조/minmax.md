- 자바 배열에서 최대, 최소 구하기
    
    [https://wakestand.tistory.com/423](https://wakestand.tistory.com/423)
    
    1. for 문을 이용하는 방법 : 손이 많이 탄다.
    
    먼저 for 문을 이용하는 방법은
    
    for 문을 돌려가면서 가장 큰 값을 찾는 식인데
    
    최대값은 위의 코드를 그대로 가져다 사용하면 되고
    
    최소값은 if 문에서 방향만 반대로 바꿔주면 된다
    
    1. Array.sort(배열명) 을 이용하는 방법
    
    Arrays.sort(배열명); 을 해주면
    
    자동으로 정렬이 된다.
    
    최대값을 구하려면 배열 끝 값을,
    
    최소값을 가져오려면 배열 처음 값을 가져오면 된다.
    
    1. Stream을 이용하는 방법
    
    Arrays.stream(배열명)으로 스트림 형태로 만들어 준다.
    
    .max() .max()로 최대값, 최소값을 구하고
    
    .getAsInt();로 int 형태로 꺼내오면 바로 끝이 난다.
    
    스트림은 처음 보면 이해가 어렵긴 한데,
    
    최소값, 최대값의 경우에는
    
    스트림 형태로 만들고, max(), min()을 사용해준 뒤
    
    꺼내오기만 하면 끝이니 어려워할 필요가 없다
    
    마지막으로 예제에 사용한 코드는 아래와 같다
    
    [자바 스트림(Stream) 예제부터 사용법까지 정리
    wakestand.tistory.com](https://wakestand.tistory.com/419)
    
    ```java
    	public static void main(String[] args) {
    		int arr[] = {3,1,40,2,5,237,4};
    
    		// for를 이용한 방법 (최소값의 경우에는 if 괄호 방향을 바꿔준다)
    		int max = arr[0]; // 배열 길이가 1일 경우를 대비해..
    		for (int i = 1; i < arr.length; i++) {
    			 if (arr[i] > max) {
    				 max = arr[i];
    			 }
    		}
    		System.out.println("For 문을 이용한 방법");
    		System.out.println("최대값 : " + max);
    
    		// Arrays.sort를 이용한 방법
    		System.out.println("Arrays.sort를 이용한 방법");
    		Arrays.sort(arr); // 배열 정렬
    		System.out.println("최대값 : " + arr[arr.length-1]); // 최대값
    		System.out.println("최소값 : " + arr[0]); // 최소값
    
    		// Stream을 이용한 방법
    		System.out.println("Stream을 이용한 방법");
    		// Arrays.stream(배열명) 으로 배열 생성
    		System.out.println("최대값 : " + Arrays.stream(arr).max().getAsInt());
    		System.out.println("최소값 : " + Arrays.stream(arr).min().getAsInt());
    
    	}
    ```
