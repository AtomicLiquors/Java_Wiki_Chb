왼쪽정렬(기본)
$로 수식의 앞 뒤를 감싸면 수식을 작성할 수 있습니다.
별다른 조치를 취하지 않고 수식을 작성하면 기본적으로 왼쪽 정렬이 됩니다.
일반 문장 사이에 수식을 넣는 것도 가능합니다.

$x+y=1$
$x$는 $y$와의 합이 $1$이다.
x+y=1
x는 y와의 합이 1이다.

중앙정렬
$$ 사이에 수식을 적으면 중앙 정렬이 됩니다.
원래는 $$가 어떻게 붙든 상관없지만, velog에서는 반드시 여는$$와 닫는 $$는 다른 줄에 있어야 합니다.
다음은 가능한 세 가지 형태입니다.

$$
x+y=1$$

$$x+y=1
$$

$$
x+y=1
$$
x+y=1
특정 문자를 기준으로 정렬
일반적으로 수식을 전개할 때 =기호를 기준으로 정렬합니다.
하지만 그냥 중앙정렬을 하면 다음과 같이 보입니다.

$$
f(x)=ax^2+bx+c\\
g(x)=Ax^4
$$
f(x)=ax 
2
 +bx+c
g(x)=Ax 
4
 
이때 aligned 심볼을 통하여 특정 문자를 기준으로 정렬할 수 있습니다.
정렬 기준은 &를 기준으로 정렬됩니다.

$$
\begin{aligned}
f(x)&=ax^2+bx+c\\
g(x)&=Ax^4
\end{aligned}$$
f(x)
g(x)
​
  
=ax 
2
 +bx+c
=Ax 
4
 
​
 
수식 내에서의 줄바꿈
수식에서 Enter key를 누른다고 해서 줄바꿈이 되지 않습니다. \\를 입력하면 줄바꿈을 할 수 있습니다.

$$x+y=3\\-x+3y=2$$
x+y=3
−x+3y=2
수식 내에서의 띄어쓰기
수식 안에서는 띄어쓰기를 해도 적용되지 않습니다. 다음과 같이 명시적으로 띄어쓰기를 입력하여야 합니다.

$local minimum$(띄어쓰기 적용 X)
$local\,minimum$(띄어쓰기 한 번)
$local\;minimum$(띄어쓰기 두 번)
$local\quad minimum$(띄어쓰기 네 번)
localminimum
localminimum
localminimum
localminimum

곱셈 기호
의외로 많이 쓰나 잘 알지 못하는 기호인 것 같습니다.

y = A \times x + B
y=a×x+b

첨자(제곱)
윗 첨자는 ^ 기호로, 아랫 첨자는 _ 기호로 적습니다.
오른쪽에 한 글자가 자동으로 첨자로 들어가게 되고 두 글자 이상을 적용하려면 { }(중괄호)로 감싸면 됩니다.

$a_1, a^2, a_1^2, 2^{n-1}$
$y_i=x_i^3+x_{i-1}^2+x_{i-2}$
a 
1
​
 ,a 
2
 ,a 
1
2
​
 
y 
i
​
 =x 
i
3
​
 +x 
i−1
2
​
 +x 
i−2
​
 
분수 표기법
분수 표기법에는 두 가지 방법이 있습니다.

\over를 사용하면 \over를 기준으로 왼쪽에 있는 수식은 모두 분자, 오른쪽에 있는 수식은 모두 분모로 들어가게 됩니다.
\frac을 사용하게 되면 첫 번째 문자는 분자, 두 번째 문자는 분모로 들어가게 됩니다. 두 문자 이상이라면 중괄호{ }를 통하여 묶어주면 됩니다.
$s^2+2s+s\over s+\sqrt s+1$
$\frac{1+s}{s(s+2)}$
s+ 
s
​
 +1
s 
2
 +2s+s
​
 

s(s+2)
1+s
​
 
절대값 표기법
일반적으로 절대값을 표기할 때는 키보드 위의 | 문자를 사용하게 됩니다.
하지만 이렇게 하면 분수와 같이 큰 객체에 맞게 resizable한 기호를 사용할 수 없습니다.
그럴 땐 \vert와 \left, \right를 통하여 좌우 기호를 명시해주면 됩니다.

$\vert x \vert$
$\left\lvert \frac{s^2+1}{s^3+2s^2+3s+1} \right\rvert$
∣x∣
∣
∣
∣
∣
∣
​
  
s 
3
 +2s 
2
 +3s+1
s 
2
 +1
​
  
∣
∣
∣
∣
∣
​
 
sin, log와 같은 기호를 세워서 표기
단어 앞에 \를 붙이게 되면 똑바로 글자를 쓸 수 있습니다.
Markdown에서 명시 되어 있지 않은 수학 단어라면 오류가 발생합니다.

$\log_{10}{(x+1)}$
$A\sin(bx+c)$
log 
10
​
 (x+1)
asin(bx+c)
극한/시그마 표기법
그냥 \sum과 \lim 심볼을 사용하게 되면 다음과 같이 linear하게 표기됩니다.

lim 
s→∞
​
 s 
2
 

∑ 
i=0
∞
​
 (y 
i
​
 −t 
i
​
 ) 
2
 

이럴 땐 \displaystyle을 앞에 명시하면 정상적으로 표시됩니다. 기본형인 linear 형태는 \textstyle 명시하면 됩니다.

$\displaystyle\lim_{s\rarr\infin}{s^2}$
$\displaystyle\sum_{i=0}^{\infin}{(y_i-t_i)^2}$
s→∞
lim
​
 s 
2
 

i=0
∑
∞
​
 (y 
i
​
 −t 
i
​
 ) 
2
 

벡터 표기법
현재 \vec 심볼을 벨로그에서 사용할 수 없는 것으로 보입니다.
\vec 대신 \overrightarrow 심볼을 사용하시면 화살표가 조금 더 크지만 올바로 출력됩니다.

$\vec{a}$
$\overrightarrow{a}$
a
 
a
 

행렬 표기법
matrix 심볼을 통하여
&로 열을 구분하고, \\로 행을 구분합니다.

$\begin{matrix}1&2\\3&4\\ \end{matrix}$
$\begin{pmatrix}1&2\\3&4\\ \end{pmatrix}$
$\begin{bmatrix}1&2\\3&4\\ \end{bmatrix}$
$\begin{Bmatrix}1&2\\3&4\\ \end{Bmatrix}$
$\begin{vmatrix}1&2\\3&4\\ \end{vmatrix}$
$\begin{Vmatrix}1&2\\3&4\\ \end{Vmatrix}$
1
3
​
  
2
4
​
 
( 
1
3
​
  
2
4
​
 )
[ 
1
3
​
  
2
4
​
 ]
{ 
1
3
​
  
2
4
​
 }
∣
∣
∣
∣
∣
​
  
1
3
​
  
2
4
​
  
∣
∣
∣
∣
∣
​
 
∥
∥
∥
∥
∥
​
  
1
3
​
  
2
4
​
  
∥
∥
∥
∥
∥
​
 
조각함수와 같은 case 표기법
cases 심볼을 통하여 작성할 수 있습니다.

$\vert x\vert=
\begin{cases}
-x,\;if\;x<0\\
+x,\;if\;x\geq0
\end{cases}$
∣x∣={ 
−x,ifx<0
+x,ifx≥0
​
 
