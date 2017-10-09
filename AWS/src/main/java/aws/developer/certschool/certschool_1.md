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

**_11. When uploading an object, what request header can be explicitly specified in a request to Amazon S3 to encrypt object data when saved on the server side?_**

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

ReceiveMessageWaitTimeSeconds - The length of time, in seconds, for which a ReceiveMessage action waits for a message to arrive. 
Valid values: an integer from 0 to 20 (seconds). The default is 0.

---

**_16. In DynamoDB, what type of HTTP response codes indicate that a problem was found with the client request sent to the service?_** 

- 700 HTTP response code
- 500 HTTP response code
- 200 HTTP response code
- **400 HTTP response code**

http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Programming.Errors.html

When your program sends a request, DynamoDB attempts to process it. If the request is successful, DynamoDB returns an HTTP success status code (200 OK), along with the results from the requested operation.

If the request is unsuccessful, DynamoDB returns an error. Each error has three components:
- An HTTP status code (such as 400).
- An exception name (such as ResourceNotFoundException).
- An error message (such as Requested resource not found: Table: tablename not found).

---

**_17. What happens if the application component fails before deleting the message in SQS? 
If your system doesn’t call DeleteMessage for that message before the visibility timeout expires?_** 

- the message again becomes visible in the queue, however it wont be available for ReceiveMessage calls
- the message will be moved to dead letter queue and no longer will be available for component access
- **the message again becomes visible to the ReceiveMessage calls placed by the components in your system and it will be received again**
- the message will be deleted automatically by AWS system APIs

http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/sqs-visibility-timeout.html

The visibility timeout clock starts ticking once Amazon SQS returns the message. During that time, the component processes and deletes the message. 
But what happens if the component fails before deleting the message? If your system doesn't call DeleteMessage for that message before the visibility timeout expires, 
the message again becomes visible to the ReceiveMessage calls placed by the components in your system and it will be received again. 
If a message should only be received once, your system should delete it within the duration of the visibility timeout.

---

**_18. When a Simple Queue Service message triggers a task that takes 5 minutes to complete, 
which process below will result in successful processing of the message and remove it from the queue while minimizing the chances of duplicate processing?_** 

- Retrieve the message with an increased visibility timeout, delete the message from the queue, process the message
- Retrieve the message with increased DelaySeconds, delete the message from the queue, process the message
- Retrieve the message with increased DelaySeconds, process the message, delete the message from the queue
- **Retrieve the message with an increased visibility timeout, process the message, delete the message from the queue**

http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/sqs-visibility-timeout.html

When you receive a message from a queue and begin to process it, the visibility timeout for the queue may be insufficient (for example, you might need to process and delete a message). You can shorten or extend a message's visibility by specifying a new timeout value using the ChangeMessageVisibility action.
For example, if the default timeout for a queue is 60 seconds, 15 seconds have elapsed since you received the message, and you send a ChangeMessageVisibility call with VisibilityTimeout set to 10 seconds, the 10 seconds begin to count from the time that you make the ChangeMessageVisibility call. 
Thus, any attempt to change the visibility timeout or to delete that message 10 seconds after you initially change the visibility timeout (a total of 25 seconds) might result in an error.

---

**_19. Which DynamoDB limits can be raised by contacting AWS support? Choose 2 answers_** 

- The maximum storage used per account
- The number of hash keys per account
- **The number of tables per account**
- The number of local secondary indexes per account
- **The number of provisioned throughput units per account**

http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Limits.html

1. Tables Per Account. For any AWS account, there is an initial limit of 256 tables per region.
2. Provisioned Throughput Minimums and Maximums: For any table or global secondary index, the minimum settings for provisioned throughput are 1 read capacity unit and 1 write capacity unit. 
The provisioned throughput limit includes the sum of the capacity of the table together with the capacity of all of its global secondary indexes.

---

**_20. Which EC2 API call would you use to requests a reboot of one or more instances?_** 

- RebootAllInstances
- StopInstances
- RestartInstances
- **RebootInstances**

http://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_RebootInstances.html

RebootInstances. Requests a reboot of one or more instances. This operation is asynchronous; it only queues a request to reboot the specified instances. 
The operation succeeds if the instances are valid and belong to you. Requests to reboot terminated instances are ignored.

---

**_21. Company XYZ is currently hosting their corporate site in an Amazon S3 bucket with Static Website Hosting enabled. 
Currently, when visitors go to thecertschool.com the index.html page is returned. Company XYZ now would like a new page welcome.html to be returned when a visitor enters thecertschool.com in the browser.
Which of the following steps will allow Company XYZ to meet this requirement? Choose 2 answers_** 

- Create a welcome subfolder in their S3 bucket
- **Upload an html page named welcome.html to their S3 bucket**
- **Set the Index Document property to welcome.html**
- Move the index.html page to a welcome subfolder
- Set the Error Document property to welcome.htm

http://docs.aws.amazon.com/AmazonS3/latest/dev/HostingWebsiteOnS3Setup.html

Step 3: Uploading an Index Document

1. Create a document. Give it the same name that you gave the index document earlier.
2. Using the console, upload the index document to your bucket.

---

**_22. What type of block cipher does Amazon S3 offer for server side encryption?_** 

- RC5
- Blowfish
- Triple DES
- **Advanced Encryption Standard**

http://docs.aws.amazon.com/AmazonS3/latest/dev/UsingServerSideEncryption.html

Server-side encryption is about protecting data at rest. Server-side encryption with Amazon S3-managed encryption keys (SSE-S3) employs strong multi-factor encryption. Amazon S3 encrypts each object with a unique key. 
As an additional safeguard, it encrypts the key itself with a master key that it regularly rotates. 
Amazon S3 server-side encryption uses one of the strongest block ciphers available, 256-bit Advanced Encryption Standard (AES-256), to encrypt your data.

---

**_23. If I want an instance to have a public IP address, which IP address should I use?_** 

- Dynamic IP Address
- **Elastic IP Address**
- Domain IP Address
- Host IP Address

http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/elastic-ip-addresses-eip.html

An Elastic IP address is a public IP address, which is reachable from the Internet. If your instance does not have a public IP address, you can associate an Elastic IP address with your instance to enable communication with the Internet; 
for example, to connect to your instance from your local computer.

---

**_24. How can you secure data at rest on an EBS volume?_** 

- Attach the volume to an instance using EC2’s SSL interface.
- Create an IAM policy that restricts read and write access to the volume.
- **Use an encrypted file system on top of the EBS volume.**
- Encrypt the volume using the S3 server-side encryption service.

Page 5:
https://d0.awsstatic.com/whitepapers/aws-securing-data-at-rest-with-encryption.pdf

Another option would be to use file system-level encryption, which works by stacking an encrypted file system on top of an existing file system. 
This method is typically used to encrypt a specific directory.

---

**_25. EC2 instances are launched from Amazon Machine images (AMIS). A given public AMI can:_** 

- only be used to launch EC2 instances in the same country as the AMI is stored
- **only be used to launch EC2 instances in the same AWS region as the AMI is stored.**
- be used to launch EC2 Instances in any AWS region
- only be used to launch EC2 instances in the same AWS availability zone as the AMI is stored

http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/sharingamis-intro.html

AMIs are a regional resource. Therefore, sharing an AMI makes it available in that region. To make an AMI available in a different region, copy the AMI to the region and then share it. 

---

**_26. Which statements about DynamoDB are true? Choose 2 answers_** 

- **DynamoDB uses conditional writes for consistency**
- DynamoDB restricts item access during writes
- **DynamoDB uses optimistic concurrency control**
- DynamoDB uses a pessimistic locking model
- DynamoDB restricts item access during reads

http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/WorkingWithItems.html#WorkingWithItems.ConditionalUpdate

1. By default, the DynamoDB write operations (PutItem, UpdateItem, DeleteItem) are unconditional: each of these operations will overwrite an existing item that has the specified primary key.
DynamoDB optionally supports conditional writes for these operations. A conditional write will succeed only if the item attributes meet one or more expected conditions. Otherwise, it returns an error. 
Conditional writes are helpful in many situations. For example, you might want a PutItem operation to succeed only if there is not already an item with the same primary key. 
Or you could prevent an UpdateItem operation from modifying an item if one of its attributes has a certain value.

http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBMapper.OptimisticLocking.html

2. Optimistic locking is a strategy to ensure that the client-side item that you are updating (or deleting) is the same as the item in DynamoDB. 
If you use this strategy, then your database writes are protected from being overwritten by the writes of others — and vice-versa.

---

**_27. What happens, by default, when one of the resources in a CloudFormation stack cannot be created?_** 

- **Previously-created resources are deleted and the stack creation terminates.**
- The stack creation continues, and the final results indicate which steps failed.
- CloudFormation templates are parsed in advance so stack creation is guaranteed to succeed.
- Previously-created resources are kept but the stack creation terminates.

https://aws.amazon.com/cloudformation/faqs/

By default, the “automatic rollback on error” feature is enabled. This will cause all AWS resources that AWS CloudFormation created successfully for a stack up to the point where an error occurred to be deleted. 
This is useful when, for example, you accidentally exceed your default limit of Elastic IP addresses, or you don’t have access to an EC2 AMI you’re trying to run. 
This feature enables you to rely on the fact that stacks are either fully created, or not at all, which simplifies system administration and layered solutions built on top of AWS CloudFormation.

---

**_28. Which of the following statements about SQS is true?_** 

- Messages will be delivered exactly once and messages will be delivered in Last in, First out order
- Messages will be delivered exactly once and messages will be delivered in First in, First out order
- **Messages will be delivered one or more times and message delivery order is indeterminate**
- Messages will be delivered exactly once and message delivery order is indeterminate

http://docs.aws.amazon.com/AWSSimpleQueueService/2008-01-01/SQSDeveloperGuide/index.html?Overview.html

SQS ensures delivery of each message at least once, and supports multiple readers and writers interacting with the same queue. 
A single queue can be used simultaneously by many distributed application components, with no need for those components to coordinate with each other to share the queue.
Amazon SQS is engineered to always be available and deliver messages. One of the resulting tradeoffs is that SQS does not guarantee first in, first out delivery of messages. 
For many distributed applications, each message can stand on its own, and as long as all messages are delivered, the order is not important. 
If your system requires that order be preserved, you can place sequencing information in each message, so that you can reorder the messages when the queue returns them.

---

**_29. A user has setup an EBS backed instance and attached 2 EBS volumes to it. The user has setup a CloudWatch alarm on each volume for the disk data. 
The user has stopped the EC2 instance and detached the EBS volumes. What will be the status of the alarms on the EBS volume?_** 

- The EBS cannot be detached until all the alarms are removed
- **Insufficient Data**
- OK
- Alarm

http://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/AlarmThatSendsEmail.html

INSUFFICIENT_DATA—The alarm has just started, the metric is not available, or not enough data is available for the metric to determine the alarm state

---

**_30. In Dynamo DB, What item operation allows to edit an existing item’s attributes, or adds a new item to the table if it does not already exist?_** 

- GetItem
- DeleteItem
- **UpdateItem**
- UpdateTable
  
UpdateItem. Edits an existing item's attributes, or adds a new item to the table if it does not already exist. You can put, delete, or add attribute values. 
You can also perform a conditional update on an existing item (insert a new attribute name-value pair if it doesn't exist, or replace an existing name-value pair if it has certain expected attribute values).

---