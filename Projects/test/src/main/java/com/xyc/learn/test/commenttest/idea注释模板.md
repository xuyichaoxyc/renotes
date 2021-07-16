```html
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")
/**
  *@ClassName ${NAME}
  *@Description TODO
  *@Author ${USER}-xuyichao
  *@Date ${DATE} ${TIME}
  *@Version 1.0
  **/
public class ${NAME} {
}
```

```text
*
 * @Author xuyichao
 * @Description TODO $end$
 * @Date $date$ $time$
$param$
 * @return $return$
 **/


groovyScript("def result=''; def params=\"${_1}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split(',').toList(); for(i = 0; i < params.size(); i++) {result+=' * @param ' + params[i] + ((i < params.size() - 1) ? '\\n':'')}; return result", methodParameters())

date() time()
methodRturnType()
methodParameters()e
```

