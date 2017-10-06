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
