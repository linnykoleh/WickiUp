

<h1>sdfsd</h1>
hjkhjkgh

<p>Horizontal rule</p>



<p>Bullet list:</p>

<ul>
<li color>apples</li>
<li>oranges</li>
<li>pears</li>
</ul

[google]: http://google.com/        "Google"


*single asterisks*

_single underscores_

**double asterisks**

__double underscores__

Use the `printf()` function.

Colons can be used to align columns.

| Tables        | Are           | Cool  |
| ------------- |:-------------:| -----:|
| col 3 is      | right-aligned | $1600 |
| col 2 is      | centered      |   $12 |
| zebra stripes | are neat      |    $1 |



```java
public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                    if(target == nums[i] + nums[j]){
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
            }
        }
        return result;
}
```

> Blockquotes are very handy in email to emulate reply text.

<dl>
  <dt>Definition list</dt>
  <dd>Is something people use sometimes.</dd>

  <dt>Markdown in HTML</dt>
  <dd>Does *not* work **very** well. Use HTML <em>tags</em>.</dd>
</dl>