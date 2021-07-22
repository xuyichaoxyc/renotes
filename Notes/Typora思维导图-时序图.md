mermaid，一种类似于markdown的脚本语言，通过 javascript 将文字转化成图片，

支持绘制非常多种类的图，常见的有时序图、流程图、类图、甘特图等

# 1. 流程图（Flow Chart）-graph

## 1.1 横向思维导图（横向流程图）

```mermaid
graph LR
A[节点A]-->B[节点B]
A --> C[节点C]
```

## 1.2. 竖向思维导图（竖向流程图）

```mermaid
graph TD
A[节点A]-->C[节点C]
A-->B[节点B]
B-->D[节点D]
```

# 2. 时序图（Sequence Diagram）- sequenceDiagram

->> ：实线箭头

-->>：虚线

```mermaid
sequenceDiagram
Alice->>John: Hello John, how are you?
John-->Alice: Great!

Alice->>+John: Hello John, how are you?
Alice->>+John: John, can you hear me?
John-->>-Alice: Hi Alice, I can hear you!
John-->>-Alice: I feel great!
```

# 3. 状态图（State Diagram）- stateDiagram

[*] —— 表示开始或者结束，如在箭头右边则表示结束

```mermaid
stateDiagram-v2
[*] --> s1
s1 --> [*]

s1 --> move
move --> s1
move --> crash
crash --> [*]
```

# 4. 类图（class Diagram）- classDiagram

<|-- 表示继承

\+ 表示 public

\- 表示 private

```mermaid
classDiagram
Animal <|-- Duck
Animal <|-- Fish
Animal <|-- Zebra

Animal : + int age
Animal : + String gender
Animal : + isAnimal()
Animal : + mate()
class Duck{
	+ String beakColor
	+ swim()
	+ quack()
}
class Fish{
	- int sizeInFeet
	- canEate()
}
class Zebra{
	+bool is_wild
	+run()
}
```



# 5. 甘特图

项目的计划排期

```tex
gantt
	title 工作计划
	dateFormat YYYY-MM-DD
	section Section
	A task	:a1, 2020-01-01, 30d
	Another task	:after a1 , 20d
	section Another
	Task in sec	:2020-01-12	, 12d
	another task	:24d
```

```mermaid
gantt
	title 工作计划
	dateFormat YYYY-MM-DD
	section Section
	A task	:a1, 2020-01-01, 30d
	Another task	:after a1 , 20d
	section Another
	Task in sec	:2020-01-12	, 12d
	another task	:24d
```

# 6. 饼图（pie）

```mermaid
pie
	title Key elements in product X
	"Calcium" : 42.96
	"Potassium" : 50.05
	"Magnesium" : 10.01
	"Iron" :
```



