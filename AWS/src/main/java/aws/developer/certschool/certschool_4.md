**_1. What happens to my Amazon running EC2 instances if I delete my Auto Scaling Group?_**

- you have to terminate instance manually before delete auto scaling group
- the instances will be terminated and the Auto Scaling group will not be deleted.
- the instances won't get affected and the Auto Scaling group will be deleted.
- **the instances will be terminated and the Auto Scaling group will be deleted.**

"If you have an Auto Scaling group with running instances and you choose to delete the Auto Scaling group, the instances will be terminated and the Auto Scaling group will be deleted."

---

**_2. You have a web application running on six Amazon EC2 instances, consuming about 45% of resources on each instance. 
You are using auto-scaling to make sure that six instances are running at all times. 
The number of requests this application process is consistent and does not experience spikes. 
The application is critical to your business and you want high availability at all times. 
You want the load to be distributed evenly between all instances. You also want to use the same Amazon Machine Image (AMI) for all instances. 
Which of the following architectural choices should you make?_**

- **Deploy 3 EC2 instances in one availability zone and 3 in another availability zone and use Amazon Elastic Load Balancer**
- Deploy 2 EC2 instances in three regions and use Amazon Elastic Load Balancer
- Deploy 6 EC2 instances in one availability zone and use Amazon Elastic Load Balancer
- Deploy 3 EC2 instances in one region and 3 in another region and use Amazon Elastic Load Balancer

"A load balancer accepts incoming traffic from clients and routes requests to its registered EC2 instances in one or more Availability Zones."

---

**_3. What AWS products and features can be deployed by elastic beanstalk?(Select 3 answers)_**

- Route 53 hosted zones
- **Elastic Load Balancers**
- SQS Queues
- **RDS Instances**
- **Auto scaling groups**
- Elastic IP Addresses

"AWS Elastic Beanstalk uses proven AWS features and services, such as Amazon EC2, Amazon RDS, Elastic Load Balancing, Auto Scaling, Amazon S3, and Amazon SNS, to create an environment that runs your application. 
The current version of AWS Elastic Beanstalk uses the Amazon Linux AMI or the Windows Server 2012 R2 AMI"    
    
--- 

**_4. Which API call would you use to put or delete multiple items in one or more tables with Amazon DynamoDB?_**
   
- BatchGetItem
- **BatchWriteItem**
- BatchDeleteItem
- GetAllItem    

"The BatchWriteItem operation puts or deletes multiple items in one or more tables. A single call to BatchWriteItem can write up to 16 MB of data, which can comprise as many as 25 put or delete requests. Individual items to be written can be as large as 400 KB."
  
--- 

**_5. When an EC2 EBS-backed (EBS root) instance is stopped, what happens to the data on any ephemeral store volumes?_**

- **Data will be deleted and will no longer be accessible.**
- Data is automatically saved in an EBS volume.
- Data is unavailable until the instance is restarted.
- Data is automatically saved as an EBS snapshot.

"You can specify instance store volumes for an instance only when you launch it. The data in an instance store persists only during the lifetime of its associated instance. If an instance reboots (intentionally or unintentionally), data in the instance store persists. However, data in the instance store is lost under the following circumstances.
 
1. The underlying disk drive fails
2. The instance stops
3. The instance terminates"
  
--- 

**_6. A ------- is a logical entity that enables creating a cluster of instances by launching instances as part of a group, 
In addition it provides low latency, full bisection 10 Gigabit Ethernet bandwidth connectivity between instances in the group._**
  
- AWS Storage Gateway
- Multi AZ
- AWS Lambda
- AWS Direct Connect
- **Cluster Placement Group**

"A cluster placement group is a logical entity that enables creating a cluster of instances by launching instances as part of a group. 
The cluster of instances then provides low latency, full bisection 10 Gigabit Ethernet bandwidth connectivity between instances in the group. 
Cluster placement groups are created through the Amazon EC2 API or AWS Management Console."  

--- 

**_7. An instance is launched into a VPC subnet with the network ACL configured to allow all inbound traffic and deny all outbound traffic. 
The instance’s security group is configured to allow SSH from any IP address and deny all outbound traffic. 
What changes need to be made to allow SSH access to the instance?_**

- Nothing, it can be accessed from any IP address using SSH.
- Both the outbound security group and outbound network ACL need to be modified to allow outbound traffic.
- The outbound security group needs to be modified to allow outbound traffic.
- **The outbound network ACL needs to be modified to allow outbound traffic.**

"Network ACLs are stateless; responses to allowed inbound traffic are subject to the rules for outbound traffic"

--- 

**_8. A customer wants to track access to their Amazon Simple Storage Service (S3) buckets and also use this information for their internal security and access audits.
Which of the following will meet the Customer requirement?_**  

- Enable AWS CloudTrail to audit all Amazon S3 bucket access.
- **Enable server access logging for all required Amazon S3 buckets.**
- Enable Amazon S3 event notifications for Put and Post.
- Enable the Requester Pays option to track access via AWS Billing


"In order to track requests for access to your bucket, you can enable access logging. Each access log record provides details about a single access request, such as the requester, bucket name, request time, request action, response status, and error code, if any. 
Access log information can be useful in security and access audits. 
It can also help you learn about your customer base and understand your Amazon S3 bill."

--- 
 
**_9. Which approach below provides the least impact to provisioned throughput on the “Product” table?_**

- Create a child table "Image" in DynamoDB to store the image with a foreign key constraint to the 'Product" table
- Create a BLOB column in product table itself and store image.
- **Store the images in Amazon S3 and add an S3 URL pointer to the "Product" table item for each image**
- Serialize the image and store it in multiple Dynamo DB tables


"Amazon DynamoDB stores structured data, indexed by primary key, and allows low latency read and write access to items ranging from 1 byte up to 400KB. 
Amazon S3 stores unstructured blobs and suited for storing large objects up to 5 TB. In order to optimize your costs across AWS services, 
large objects or infrequently accessed data sets should be stored in Amazon S3, while smaller data elements or file pointers (possibly to Amazon S3 objects) are best saved in Amazon DynamoDB."

---

**_10. How is provisioned throughput affected by the chosen consistency model when reading data from a DynamoDB table?_**

- **Strongly consistent reads use more throughput than eventually consistent reads.**
- Strongly consistent reads use less throughput than eventually consistent reads
- Strongly consistent reads use the same amount of throughput as eventually consistent reads
- Strongly consistent reads use variable throughput depending on read activity

"When reading data from Amazon DynamoDB, users can specify whether they want the read to be eventually consistent or strongly consistent:
 
Eventually Consistent Reads (Default) – the eventual consistency option maximizes your read throughput. 
However, an eventually consistent read might not reflect the results of a recently completed write. Consistency across all copies of data is usually reached within a second. 
Repeating a read after a short time should return the updated data.
 
Strongly Consistent Reads — in addition to eventual consistency, Amazon DynamoDB also gives you the flexibility and control to request a strongly consistent read if your application, or an element of your application, requires it. 
A strongly consistent read returns a result that reflects all writes that received a successful response prior to the read."

---

**_11. In AWS, which security aspects are the customer’s responsibilities? Choose 4 answers_**

- Decommissioning storage devices
- **Security Group and ACL (Access Control List) settings**
- **Encryption of EBS (Elastic Block Storage) volumes**
- **Life-cycle management of IAM credentials**
- Controlling physical access to compute resources
- **Patch management on the EC2 instance’s operating system**

1.AWS Infrastructure as a Service (IaaS) products for e.g. EC2, VPC, S3 are completely under your control and require you to perform all of the necessary security configuration and management tasks.
2.Management of the guest OS (including updates and security patches), any application software or utilities you install on the instances, and the configuration of the AWS-provided firewall (called a security group) on each instance
3.For most of these managed services, all you have to do is configure logical access controls for the resources and protect your account credentials. 
A few of them may require additional tasks, such as setting up database user accounts, but overall the security configuration work is performed by the service

--- 

**_12. An organization is generating digital policy files which are required by the admins for verification. 
Once the files are verified they may not be required in the future unless there is some compliance issue. 
If the organization wants to save them in a cost effective way, which is the best possible solution?_**

- Amazon S3
- **Amazon Glacier**
- Amazon RRS
- Amazon RDS

"Amazon Glacier is an extremely low-cost storage service that provides secure, durable, and flexible storage for data backup and archival. With Amazon Glacier, customers can reliably store their data for as little as $0.007 per gigabyte per month."

---

**_13. An application stores payroll information nightly in DynamoDB for a large number of employees across hundreds of offices. Item attributes consist of individual name, office identifier, and cumulative daily hours. 
Managers run reports for ranges of names working in their office. One query is. 
“Return all Items in this office for names starting with A through E”. Which table configuration will result in the lowest impact on provisioned throughput for this query?_**

- Configure a hash index on the name attribute and no range index
- **Configure the table to have a range index on the name attribute, and a hash index on the office identifier**
- Configure the table to have a hash index on the name attribute, and a range index on the office identifier
- Configure a hash index on the office Identifier attribute and no range index

"the hash/partition key is the part of the query that is going to be the same for all the items that are returned"

---

**_14. If you’re unable to connect via SSH to your EC2 instance, which of the following should you check and possibly correct to restore connectivity?_**

- Modify the instance security group to allow ingress of ICMP packets from your IP.
- Configure the IAM role to permit changes to security group settings.
- **Adjust the instance’s Security Group to permit ingress traffic over port 22 from your IP.**
- Adjust Security Group to allow egress traffic over TCP port 443 from your IP

"To enable network access to your instance, you must allow inbound traffic to your instance. To open a port for inbound traffic, add a rule to a security group that you associated with your instance when you launched it.
To connect to your instance, you must set up a rule to authorize SSH traffic from your computer’s public IPv4 address. To allow SSHtraffic from additional IP address ranges, add another rule for each range you need to authorize."

---

**_15. Company XYZ is launching a new game app for mobile devices. Users will log into the game using their existing social media account to streamline data capture. 
Company XYZ would like to directly save player data and scoring information from the mobile app to a DynamoDS table named Score Data When a user saves their game the progress data will be stored to the Game state S3 bucket. 
what is the best approach for storing data to DynamoDB and S3?_**

- Use an IAM user with access credentials assigned a role providing access to the Score Data DynamoDB table and the Game State S3 bucket for distribution with the mobile app.
- Use an EC2 Instance that is launched with an EC2 role providing access to the Score Data DynamoDB table and the GameState S3 bucket that communicates with the mobile app via web services.
- **Use temporary security credentials that assume a role providing access to the Score Data DynamoDB table and the Game State S3 bucket using web identity federation.**
- Use Login with Amazon allowing users to sign in with an Amazon account providing the mobile app with access to the Score Data DynamoDB table and the Game State S3 bucket.

"Identity federation: IAM allows users to access AWS resources, without requiring the user to have accounts with AWS, by providing temporary credentials"

---

**_16. A client application requires operating system privileges on a relational database server. What is an appropriate configuration for highly available database architecture?_**

- A standalone Amazon EC2 instance
- Amazon EC2 instances in a replication configuration utilizing a single Availability Zone
- **Amazon EC2 instances in a replication configuration utilizing two different Availability Zones**
- Amazon RDS in a Multi-AZ configuration

"AWS does not provide root privileges for managed services like RDS, DynamoDB, S3, Glacier etc. For RDS, if you need Admin privileges or want to use features not enabled by RDS, you can go with the Database on EC2 approach"

---

**_17. When using the following AWS services, which should be implemented in multiple Availability Zones for high availability solutions? Choose 2 answers_**

- Amazon Simple Storage Service (S3)
- Amazon DynamoDB
- Amazon Simple Notification Service (SNS)
- **Amazon Elastic Load Balancing**
- **Amazon Elastic Compute Cloud (EC2)**

"Amazon EC2 offers a highly reliable environment where replacement instances can be rapidly and predictably commissioned. The service runs within Amazon’s proven network infrastructure and data centers. 
The Amazon EC2 Service Level Agreement commitment is 99.95% availability for each Amazon EC2 Region.
Elastic Load Balancing automatically distributes incoming application traffic across multiple Amazon EC2 instances. 
It enables you to achieve fault tolerance in your applications, seamlessly providing the required amount of load balancing capacity needed to route application traffic"

---

**_18. In Amazon SQS, which of the below API action would get the visibility timeout for a queue_**

- SetQueueAttributes
- **GetQueueAttributes**
- Querytimeout
- ReceiveMessage

http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/sqs-visibility-timeout.html

---

**_19. You have an Auto Scaling group associated with an Elastic Load Balancer (ELB). 
You have noticed that instances launched via the Auto Scaling group are being marked unhealthy due to an ELB health check, but these unhealthy instances are not being terminated. 
What do you need to do to ensure trial instances marked unhealthy by the ELB will be terminated and replaced?_**

- Change the thresholds set on the Auto Scaling group health check
- Change the health check set on the Elastic Load Balancer to use TCP rather than HTTP checks
- **Add an Elastic Load Balancing health check to your Auto Scaling group**
- Increase the value for the Health check interval set on the Elastic Load Balancer

"By default, an Auto Scaling group periodically reviews the results of EC2 instance status to determine the health state of each instance. However, if you have associated your Auto Scaling group with an Elastic Load Balancing load balancer, 
you can choose to use the Elastic Load Balancing health check. 
In this case, Auto Scaling determines the health status of your instances by checking the results of both the EC2 instance status check and the Elastic Load Balancing instance health check"

---

**_20. Which code snippet below returns the URL of a load balanced web site created in CloudFormation with an AWS::ElasticLoadBalancing::LoadBalancer resource name “ElasticLoad Balancer”?_**

- “Fn::Join” : [“.”, [ “http://”, {“Ref” : “ElasticLoadBalancerDNSName”}]]
- **“Fn::Join” : [“”. [ “http://”, {“Fn::GetAtt” : [ “ElasticLoadBalancer”,”DNSName”]}]]**
- “Fn::Join” : [“”. [ “http://”, {“Ref” : “ElasticLoadBalancerUrl”}]]
- “Fn::Join” : [“”. [ “http://”, {“Fn::GetAtt” : [ “ElasticLoadBalancer”,”Url”]}]]

http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/example-templates-autoscaling.html

--- 

**_21. Which of the following items are required to allow an application deployed on an EC2 instance to write data to DynamoDB table? Assume that no security keys are allowed to be stored on the EC2 instance. (Choose 2 answers)_**

- **Create an IAM Role that allows write access to the DynamoDB table.**
- Add an IAM Role to a running EC2 instance.
- Controlling physical access to compute resources
- Add an IAM User to a running EC2 instance.
- Create an IAM User that allows write access to the DynamoDB table
- **Launch an EC2 Instance with the IAM Role included in the launch configuration**.
- Launch an EC2 Instance with the IAM User included in the launch configuration.

--- 

**_22. Amazon EBS snapshots have which of the following two characteristics?  Choose 2 answers_**

- **EBS snapshots only save incremental changes from snapshot to snapshot**
- EBS snapshots can only be restored to an EBS volume of the same size or smaller
- EBS snapshots can only be restored and mounted to an instance in the same Availability Zone as the original EBS volume
- **EBS snapshots can be created in real-time without stopping an EC2 instance**

"You can back up the data on your EBS volumes to Amazon S3 by taking point-in-time snapshots. Snapshots are incremental backups, which means that only the blocks on the device that have changed after your most recent snapshot are saved
 
Snapshots occur asynchronously; the point-in-time snapshot is created immediately, but the status of the snapshot is pending until the snapshot is complete (when all of the modified blocks have been transferred to Amazon S3), 
which can take several hours for large initial snapshots or subsequent snapshots where many blocks have changed. 
While it is completing, an in-progress snapshot is not affected by ongoing reads and writes to the volume."

--- 

**_23. What is a placement group?_**

- **A feature that enables EC2 instances to interact with each other via high bandwidth, low latency connections**
- A collection of authorized CloudFront edge locations for a distribution
- A collection of Elastic Load Balancers in the same Region or Availability Zone
- A collection of Auto Scaling groups in the same region

"A placement group is a logical grouping of instances within a single Availability Zone. Using placement groups enables applications to participate in a low-latency, 10 Gigabits per second(Gbps) network. 
Placement groups are recommended for applications that benefit from low network latency, high network throughput, or both."

--- 

**_24. When you put objects in Amazon S3, what is the indication that an object was successfully stored?_**

- **A HTTP 200 result code and MD5 checksum, taken together, indicate that the operation was successful.**
- A success code is inserted into the S3 object metadata.
- Each S3 account has a special bucket named _s3_logs. Success codes are written to this bucket with a timestamp and checksum.
- Amazon S3 is engineered for 99.999999999% durability. Therefore there is no need to confirm that data was inserted.

"Amazon S3 is a distributed system. If Amazon S3 receives multiple write requests for the same object simultaneously, all but the last object written will be overwritten. 
To ensure that data is not corrupted traversing the network, use the Content-MD5 form field. When you use this form field, Amazon S3 checks the object against the provided MD5 value. 
To configure your application to send the Request Headers prior to sending the request body, use the 100-continue HTTP status code"

--- 

**_25. Which technique can be used to integrate AWS IAM (Identity and Access Management) with an on premise LDAP (Lightweight Directory Access Protocol) directory service?_**

- Use the LDAP credentials to restrict a group of users from launching specific EC2 instance types.
- Use IAM roles to automatically rotate the IAM credentials when LDAP credentials are updated.
- **Use SAML (Security Assertion Markup Language) to enable single sign-on between AWS and LDAP.**
- Use AWS Security Token Service from an identity broker to issue short-lived AWS credentials.
- Use an IAM policy that references the LDAP account identifiers and the AWS credentials.

"Outside the AWS cloud, administrators of corporate systems rely on the Lightweight Directory Access Protocol (LDAP) to manage identities. 
By using role-based access control (RBAC) and Security Assertion Markup Language (SAML) 2.0,corporate IT systems administrators can bridge the IAM and LDAP systems and simplify identity and permissions management across on-premises and cloud based infrastructures."

--- 

**_26. Select the correct Dynamo DB APIs? (Choose 3 Answers)_**

- **Scan**
- BatchDeleteItem
- GetScanItem
- **BatchWriteItem**
- UpdateAllItem
- **BatchGetItem**

"Scan – Gets all items and attributes by performing a full scan across the table or a secondary index. You can limit the return set by specifying filters against one or more attributes.
 
BatchGetItem – The BatchGetItem operation returns the attributes for multiple items from multiple tables using their primary keys. 
A single response has a size limit of 16 MB and returns a maximum of 100 items. Supports both strong and eventual consistency.

BatchWriteItem – Inserts, replaces, and deletes multiple items across multiple tables in a single request, but not as a single transaction. 
Supports batches of up to 25 items to Put or Delete, with a maximum total request size of 16 MB."

--- 

**_27. You have decided to change the instance type for instances running in your application tier that is using Auto Scaling. 
In which area below would you change the instance type definition?_**

- Auto Scaling group
- **Auto Scaling launch configuration**
- Auto Scaling tags
- Auto Scaling policy

"A launch configuration is a template that an Auto Scaling group uses to launch EC2 instances. When you create a launch configuration, you specify information for the instances such as the ID of the Amazon Machine Image (AMI), the instance type, a key pair, one or more security groups, and a block device mapping."

--- 

**_28. You attempt to store an object in the US-STANDARD region in Amazon S3, and receive a confirmation that it has been successfully stored. 
You then immediately make another API call and attempt to read this object. 
S3 tells you that the object does not exist What could explain this behaviour?_**

- US-STANDARD imposes a 1 second delay before new objects are readable.
- You exceeded the bucket object limit, and once this limit is raised the object will be visible.
- Objects in Amazon S3 do not become visible until they are replicated to a second region.
- **US-STANDARD uses eventual consistency and it can take time for an object to be readable in a bucket**

"Amazon S3 Data Consistency Model
 
 Amazon S3 provides read-after-write consistency for PUTS of new objects in your S3 bucket in all regions with one caveat. 
 The caveat is that if you make a HEAD or GET request to the key name (to find if the object exists) before creating the object, 
 Amazon S3 provides eventual consistency for read-after-write. Amazon S3 offers eventual consistency for overwrite PUTS and DELETES in all regions.
 
 Updates to a single key are atomic. For example, if you PUT to an existing key, a subsequent read might return the old data or the updated data, 
 but it will never write corrupted or partial data"
 
--- 
 
**_29. Which of the following programming languages are officially supported by AWS SDK?_**
 
- **Java**
- Pascal
- **PHP**
- Perl
- SQL

https://aws.amazon.com/tools/

 --- 
 
**_30. In DynamoDB, what type of HTTP response codes indicate that a problem was found and must be resolved by Amazon Web Services?_**
 
- 4xx HTTP response code
- 2xx HTTP response code
- 3xx HTTP response code
- **5xx HTTP response code**

"An HTTP 5xx status code indicates a problem that must be resolved by Amazon Web Services. 
This might be a transient error in which case you can retry your request until it succeeds. 
Otherwise, go to the AWS Service Health Dashboard to see if there are any operational issues with the service."

---