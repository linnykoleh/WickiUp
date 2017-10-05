### Lambda

![EC2](../../images/EC2/EC2-42.png)

![EC2](../../images/EC2/what_is_lambda.png)

![EC2](../../images/EC2/EC2-43.png)

![EC2](../../images/EC2/EC2-44.png)

![EC2](../../images/EC2/EC2-45.png)

![EC2](../../images/EC2/EC2-46.png)

![EC2](../../images/EC2/EC2-47.png)

![EC2](../../images/EC2/EC2-48.png)

![EC2](../../images/EC2/EC2-49.png)

![EC2](../../images/EC2/EC2-50.png)

![EC2](../../images/EC2/EC2-51.png)

![EC2](../../images/EC2/EC2-52.png)

![EC2](../../images/EC2/EC2-53.png)

![EC2](../../images/EC2/EC2-54.png)

![EC2](../../images/EC2/EC2-55.png)

![EC2](../../images/EC2/EC2-56.png)

![EC2](../../images/EC2/EC2-57.png)

 
**_Lambda scales out automatically_**
 
#### On Exam 
- If we have two user that is sending two http requests that is going to 
 trigger two lambda functions and both going to respond back two responses
 Every time user sends a request to API Gateway, invoked a new lambda function
 Tree requests then three lambda functions
 
![EC2](../../images/EC2/languages.png)
 
![EC2](../../images/EC2/lambda_priced.png)
 
![EC2](../../images/EC2/EC2-45.png)
 

**_Lambda duration time maximum is 5 minutes_**

![EC2](../../images/EC2/lambda_exam_tips.png)

![EC2](../../images/EC2/EC2-61.png)

![EC2](../../images/EC2/EC2-62.png)

![EC2](../../images/EC2/EC2-63.png)

![EC2](../../images/EC2/EC2-64.png)

![EC2](../../images/EC2/EC2-65.png)


```java
@Component
@ComponentScan(value = "com.aws.boot.linnyk")
public class MyLambdaFunctionHandler implements RequestHandler<Map<String, Object>, String> {

	private MyServices myServices;

	public String handleRequest(final Map<String,Object> input, final Context context) {
		final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyLambdaFunctionHandler.class);
		this.myServices = applicationContext.getBean(MyServices.class);
		myServices.doBusiness("Message sent from Lambda");
		return "Hello AWS From Spring";
	}

}

@Component
class MyServices {

	public void doBusiness(final String s) {
		System.out.println(s);
	}
}
```

