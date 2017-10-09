 **_1. If an application is storing hourly log files from thousands of instances from a 
   high traffic web site, which naming scheme would give optimal performance on S3?_**
   
- instanceID_log-HH-DD-MM-YYYY
- **HH-DD-MM-YYYY-log_instanceID**
- instanceID_log-YYYY-MM-DD-HH
- Sequential
- YYYY-MM-DD-HH-log_instanceID

http://docs.aws.amazon.com/AmazonS3/latest/dev/request-rate-perf-considerations.html
 
---

**_2. Your application is trying to upload a 7 GB file to Simple Storage Service and receive a “Your proposed upload exceeds the maximum allowed object size.” error message. 
   What is a feasible solution for this?_**
   
  
- Use thirty party tool to split the objects into multiple pieces for easy upload
- Simple Storage Service objects are limited to 2 GB
- Use "resume on failure" feature.
- **Use the multi-part upload API for this object**

https://aws.amazon.com/s3/faqs/?nc1=h_ls

The total volume of data and number of objects you can store are unlimited. Individual Amazon S3 objects can range in size from a minimum of 0 bytes to a maximum of 5 terabytes. 
The largest object that can be uploaded in a single PUT is 5 gigabytes. For objects larger than 100 megabytes, customers should consider using the Multipart Upload capability.

---

**_3. What is the format of structured notification messages sent by Amazon SNS?_**

- An JSON object containing MessageId, DuplicateFlag, Message and other values
- **An JSON object containing MessageId, unsubscribeURL, Subject, Message and other values**
- An JSON object containing MessageId, DuplicateFlag, Message, Host, IP address and other values
- An XML object containing MessageId, DuplicateFlag, Message and other values

https://aws.amazon.com/sns/faqs/

The notification message sent by Amazon SNS for deliveries over HTTP, HTTPS, Email-JSON and SQS transport protocols will consist of a simple JSON object, which will include the following information:

- MessageId: A Universally Unique Identifier, unique for each notification published.
- Timestamp: The time (in GMT) at which the notification was published.
- TopicArn: The topic to which this message was published
- Type: The type of the delivery message, set to “Notification” for notification deliveries.
- UnsubscribeURL: A link to unsubscribe the end-point from this topic, and prevent receiving any further notifications.
- Message: The payload (body) of the message, as received from the publisher.
- Subject: The Subject field – if one was included as an optional parameter to the publish API call along with the message.
- Signature: Base64-encoded “SHA1withRSA” signature of the Message, MessageId, Subject (if present), Type, Timestamp, and Topic values.
- SignatureVersion: Version of the Amazon SNS signature used.

Notification messages sent over the “Email” transport only contain the payload (message body) as received from the publisher.

---

**_4. Which EC2 API call would you use to retrieve a list of Amazon Machine Images?_**

- GetAMls
- **DescribeImages**
- DescribeAMls
- DescribeInstances

http://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeImages.html

DescribeImages. Describes one or more of the images (AMIs, AKIs, and ARIs) available to you. 
Images available to you include public images, private images that you own, and private images owned by other AWS accounts but for which you have explicit launch permissions.

---

**_5. In Dynamo DB If you issue a DescribeTable request immediately after a CreateTable request, DynamoDB might return a ResourceNotFoundException. Why?_**

- **DescribeTable uses an eventually consistent query, and the metadata for your table might not be available at that moment.**
- CreateTable request might have failed so you would get ResourceNotFoundException obviously
- You need to use the API DescribeTableSync to get data immediately after CreateTable

http://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/com/amazonaws/services/dynamodbv2/AmazonDynamoDBClient.html

If you issue a DescribeTable request immediately after a CreateTable request, DynamoDB might return a ResourceNotFoundException. 
This is because DescribeTable uses an eventually consistent query, and the metadata for your table might not be available at that moment. 
Wait for a few seconds, and then try the DescribeTable request again.

---

**_6. Which API would you use to query Availability Zones that are available to you?_**

- ListAllAvailabilityZones
- GetAllAvailabilityZones
- **DescribeAvailabilityZones**
- QueryAvailabilityZones

http://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeAvailabilityZones.html

DescribeAvailabilityZones. Describes one or more of the Availability Zones that are available to you. The results include zones only for the region you're currently using. 
If there is an event impacting an Availability Zone, you can use this request to view the state and any provided message for that Availability Zone.

---

**_7. You are writing to a DynamoDB table and receive the following exception: ”ProvisionedThroughputExceededException”. 
though according to your Cloudwatch metrics for the table, you are not exceeding your provisioned throughput. 
What could be an explanation for this?_**

- You haven’t provisioned enough DynamoDB storage instances
- You haven’t configured DynamoDB Auto Scaling triggers
- You’re exceeding your capacity on a particular Sort Key
- You’re exceeding your capacity on a particular Range Key
- **You’re exceeding your capacity on a particular Hash Key**

http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Programming.Errors.html

ProvisionedThroughputExceededException
Message: You exceeded your maximum allowed provisioned throughput for a table or for one or more global secondary indexes. 
To view performance metrics for provisioned throughput vs. consumed throughput, open the Amazon CloudWatch console.

---

**_8. You are providing AWS consulting services for a company developing a new mobile application that will be leveraging Amazon SNS Mobile Push for push notifications. 
In order to send direct notification messages to individual devices each device registration identifier or token needs to be registered with SNS; 
however the developers are not sure of the best way to do this. You advise them to:_**

- Implement a token vending service to handle the registration.
- Bulk upload the device tokens contained in a CSV file via the AWS Management Console.
- **Call the CreatePlatformEndPoint API function to register multiple device tokens.**
- Let the push notification service (e.g. Amazon Device Messaging) handle the registration.

http://docs.aws.amazon.com/sns/latest/dg/mobile-push-send-devicetoken.html

To migrate existing tokens from a CSV file to AWS

You can migrate existing tokens contained in a CSV file. The CSV file cannot be larger than 2MB. When migrating several tokens, it is recommended to use the CreatePlatformEndpoint API. 
Each of the tokens in the CSV file must be followed by a newline.

---

**_9. You are inserting 1000 new items every second in a DynamoDB table. Once an hour these items are analyzed and then are no longer needed. 
You need to minimize provisioned throughput, storage, and API calls. Given these requirements, what is the most efficient way to manage these Items after the analysis?_**

- **Delete the table and create a new table per hour**
- Create a new table per hour
- Retain the items in a single table
- Delete items individually over a 24 hour period

According to the question, these items are no longer needed and need to minimize provisioned throughput, storage, and API calls. 

---

**_10. A corporate web application is deployed within an Amazon VPC, and is connected to the corporate data center via IPSec VPN. The application must authenticate against the on premise LDAP server. 
Once authenticated, logged-in users can only access an S3 key space specific to the user.  Which two approaches can satisfy the objectives? Choose 2 answers_**

- Develop an identity broker which authenticates against IAM Security Token Service to assume an IAM Role to get temporary AWS security credentials. 
The application calls the identity broker to get AWS temporary security credentials with access to the appropriate S3 bucket.
- The application authenticates against IAM Security Token Service using the LDAP credentials. 
The application uses those temporary AWS security credentials to access the appropriate S3 bucket.
- **Develop an identity broker which authenticates against LDAP, and then calls IAM Security Token Service to get IAM federated user credentials. 
The application calls the identity broker to get IAM federated user credentials with access to the appropriate S3 bucket.**
- The application authenticates against LDAP, and retrieves the name of an IAM role associated with the user. 
The application then calls the IAM Security Token Service to assume that IAM Role. The application can use the temporary credentials to access the appropriate S3 bucket.
- **The application authenticates against LDAP. The application then calls the IAM Security Service to login to IAM using the LDAP credentials. 
The application can use the IAM temporary credentials to access the appropriate S3 bucket.**

Just remember

---

**_11. When uploading an object, what request header can be explicitly specified in a request to Amazon S3 to encrypt object data when saved on the server side?

- Content-MD5
- x-amz-security-token
- x-amz-storage-class
- **x-amz-server-side-encryption**

http://docs.aws.amazon.com/AmazonS3/latest/dev/UsingServerSideEncryption.html
http://docs.aws.amazon.com/AmazonS3/latest/dev/SSEUsingRESTAPI.html

If you want the target object encrypted using server-side encryption with AWS-managed keys, you must provide the x-amz-server-side-encryption request header.

---

**_12. What does the following command do with respect to the Amazon EC2 security groups? ec2-revoke RevokeSecurityGroupIngress_**

- Removes one or more security groups from an Amazon EC2 instance.
- Removes one or more security groups from a rule.
- Removes a security group from our account.
- **Removes one or more rules from a security group.**

http://docs.aws.amazon.com/cli/latest/reference/ec2/revoke-security-group-ingress.html

revoke-security-group-ingress

Removes one or more ingress rules from a security group. To remove a rule, the values that you specify (for example, ports) must match the existing rule's values exactly.

---

**_13. Which of the following is chosen as the default region when making an API call with an AWS SDK?_**

- **us-east-1**
- ap-northeast-1
- us-west-2
- eu-west-1
- us-central-1

http://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/java-dg-region-selection.html

AWS clients created by using the client constructor will not automatically determine region from the environment and will, instead, use the default SDK region (USEast1).

---

**_14. When using a large Scan operation in DynamoDB, what technique can be used to minimize the impact of a scan on a table’s provisioned throughput?_**

- **Set a smaller page size for the scan**
- Define a range index on the table
- Prewarm the table by updating all items
- Use parallel scans

http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScanGuidelines.html

Reduce Page Size
Because a Scan operation reads an entire page (by default, 1 MB), you can reduce the impact of the scan operation by setting a smaller page size. 
The Scan operation provides a Limit parameter that you can use to set the page size for your request. Each Query or Scan request that has a smaller page size uses fewer read operations and creates a "pause" between each request. 
For example, if each item is 4 KB and you set the page size to 40 items, then a Query request would consume only 40 strongly consistent read operations or 20 eventually consistent read operations.
A larger number of smaller Query or Scan operations would allow your other critical requests to succeed without throttling.

---

**_15. Company XYZ provides an online image recognition service and utilizes SQS to decouple system components for scalability. The SQS consumers poll the imaging queue as often as possible to keep end-to-end throughput as high as possible. 
However, Company XYZ is realizing that polling in tight loops is burning CPU cycles and increasing costs with empty responses. How can Company XYZ reduce the number of empty responses?_**

- Set the DelaySeconds parameter of a message to 20 seconds
- **Set the Imaging queue ReceiveMessageWaitTimeSeconds attribute to 20 seconds**
- Set the imaging queue visibility Timeout attribute to 20 seconds
- Set the imaging queue MessageRetentionPeriod attribute to 20 seconds

http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/sqs-long-polling.html
http://docs.aws.amazon.com/AWSSimpleQueueService/latest/APIReference/API_SetQueueAttributes.html

ReceiveMessageWaitTimeSeconds - The length of time, in seconds, for which a ReceiveMessage action waits for a message to arrive. Valid values: an integer from 0 to 20 (seconds). The default is 0.

---
