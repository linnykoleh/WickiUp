### Lambda

![Bash](../../images/EC2/what_is_lambda.png)

AWS Lambda is a compute service where you can upload your code
and create a Lambda function. AWS Lambda takes care of provisioning
and managing the servers that you use to run the code.
You don't have to worry about operation systems, patching, scaling, etc.
Toy can use Lambda in the following ways:
 - As a event-driven compute service where AWS Lambda runs your code in response
 to event. These events could be changes to data in a Amazon S3 bucket or
 an Amazon DynamoDB table
 - As a compute service to run your code in response to HTTP requests using 
 Amazon API Gateway or AI calls made using AWS SDKs.
 
**_Lambda scales out automatically_**
 
#### On Exam 
- If we have two user that is sending two http requests that is going to 
 trigger two lambda functions and both going to respond back two responses
 Every time user sends a request to API Gateway, invoked a new lambda function
 Tree requests then three lambda functions
 
 ![Bash](../images/EC2/what_is_lambda_http_requests.png)
 
 ![Bash](../../images/EC2/languages.png)
 
 ![Bash](../../images/EC2/lambda_priced.png)
 

 _**Lambda duration time maximum is 5 minutes_**

 
![Bash](../../images/EC2/lambda_exam_tips.png)

