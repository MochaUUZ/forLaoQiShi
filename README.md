# forLaoQiShi

给某L姓氏圣骑在wv群提问的解答
<br/>视频演示： https://www.youtube.com/watch?v=ZNkyF3sFyIQ 

![alt text](img/weChat_image.jpg "大致的问题")

根据这个图片，这是属于重新排列array类型的题目。
基本上，排列array的题目，只要搞懂排列规律还有知道border case会是什么样的离答案就不远了。

这个问题的排列规律有二：
```
1. 能被n除于整的数字，如果可以，要用一个数字隔开
2. 在不影响1的前提下，按照数字从小到大进行排列。
```
         
Border Case（边缘数据）:
```
1. n是负
2. n是零
3. n是1
4. n比array所有数字大
5. array是空的
6. n是空的
```
我care 到的case：1, 3, 4
<br/>我没care到的case：2, 5, 6 
p.s 不是我懒哦，是这3个如果要care到就要throw exceptions（报错），我觉得没必要。啊，但是面试的话要哦

Algorithm（算法）
```
1. 找到此array里最小的数字
2. 如果output是空的，跳到5
3. 跟output前个数字比除于状态*
   - 如果不一样：跳到5
   - 如果一样： 找到下一个最小的数字，重复3直到output最大的数字也比过了
4. 找到此array里最小的数字
5. 通过！把此数字放到output里
6. 把此数字从array删去
7. 回到1直到此array没数字了 

*除于状态：此数字能不能被n除于整，分能和不能
```
