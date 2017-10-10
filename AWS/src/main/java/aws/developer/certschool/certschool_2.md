 **_1. Per the AWS Acceptable Use Policy, penetration testing of EC2 instances:_**
   
- May be performed by AWS, and is periodically performed by AWS.
- May be performed by AWS, and will be performed by AWS upon customer request.
- May be performed by the customer on their own instances, only if performed from EC2 instances
- Are expressly prohibited under all circumstances.
- **May be performed by the customer on their own instances with prior authorization from AWS.**

https://aws.amazon.com/security/penetration-testing/

1. Permission is required for all penetration tests.
2. To request permission, you must be logged into the AWS portal using the root credentials associated with the instances you wish to test, otherwise the form will not pre-populate correctly. 
If you have hired a third party to conduct your testing, you must complete the form and then notify your third party when we grant approval. 
AWS will not grant approval to a third party testing company.

---

**_2. After creating a new IAM user which of the following must be done before they can successfully make API calls?_**
   
- Enable Multi-Factor Authentication for the user.
- Add a password to the user
- Assign a Password Policy to the user.
- **Create a set of Access Keys for the user.**   

http://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html

"Give the user programmatic access. This requires access keys"

---

**_3. Which features can be used to restrict access to data in S3? Choose 2 answers_**

- **Set an S3 ACL on the bucket or the object.**
- Create a CloudFront distribution for the bucket.
- **Set an S3 bucket policy.**
- Use S3 Virtual Hosting
- Enable IAM Identity Federation
   
https://aws.amazon.com/blogs/security/how-to-restrict-amazon-s3-bucket-access-to-a-specific-iam-role/

1. The IAM user’s policy and the role’s user policy grant access to “s3:*”.
2. The S3 bucket policy restricts access to only the role.

---

**_4. An Auto-Scaling group spans 3 AZs and currently has 4 running EC2 instances. 
When Auto Scaling needs to terminate an EC2 instance by default, Auto Scaling will: Choose 2 answers_**
   
- Terminate the instance with the least active network connections. If multiple instances meet this criterion, one will be randomly selected.
- **Send an SNS notification, if configured to do so.**
- **Terminate an instance in the AZ which currently has 2 running EC2 instances.**
- Allow at least five minutes for Windows/Linux shutdown scripts to complete, before terminating the instance.
- Randomly select one of the 3 AZs, and then terminate an instance in that AZ.  
   
"Auto Scaling determines whether there are instances in multiple Availability Zones. 
If so, it selects the Availability Zone with the most instances and at least one instance that is not protected from scale in. 
If there is more than one Availability Zone with this number of instances, Auto Scaling selects the Availability Zone with the instances that use the oldest launch configuration.

When you use Auto Scaling to scale your applications automatically, it is useful to know when Auto Scaling is launching or terminating the EC2 instances in your Auto Scaling group. 
Amazon SNS coordinates and manages the delivery or sending of notifications to subscribing clients or endpoints."

---

**_5. In order to optimize performance for a compute cluster that requires low inter-node latency, which of the following feature should you use?_**

- Multiple Availability Zones
- VPC private subnets
- **Placement Groups**
- AWS Direct Connect
- EC2 Dedicated Instances
   
http://jayendrapatil.com/aws-ec2-placement-groups/
http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/placement-groups.html

"A placement group is a logical grouping of instances within a single Availability Zone. Placement groups are recommended for applications that benefit from low network latency, high network throughput, or both. 
To provide the lowest latency, and the highest packet-per-second network performance for your placement group, choose an instance type that supports enhanced networking"

---

**_6. If you want to launch Amazon Elastic Compute Cloud (EC2) instances and assign each instance a predetermined private IP address you should:_**

- Launch the instance from a private Amazon Machine Image (AMI).
- **Launch the instances in the Amazon Virtual Private Cloud (VPC).**
- Assign a group of sequential Elastic IP address to the instances.
- Launch the instances in a Placement Group.
- Use standard EC2 instances since each instance gets a private Domain Name Service (DNS) already.

http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/vpc-ip-addressing.html

"You can assign additional private IP addresses, known as secondary private IP addresses, to instances that are running in a VPC. 
Unlike a primary private IP address, you can reassign a secondary private IP address from one network interface to another. 
A private IP address remains associated with the network interface when the instance is stopped and restarted, and is released when the instance is terminated."

---

**_7. You need to configure an Amazon S3 bucket to serve static assets for your public-facing web application. 
Which methods ensure that all objects uploaded to the bucket are set to public read? Choose 2 answers_**

- **Set permissions on the object to public read during upload**
- **Configure the bucket policy to set all objects to public read**
- Configure the bucket ACL to set all objects to public read
- Amazon S3 objects default to public read, so no action is needed
- Use AWS Identity and Access Management roles to set the bucket to public read

http://docs.aws.amazon.com/AmazonS3/latest/user-guide/upload-objects.html
http://jayendrapatil.com/aws-s3-permisions/

"Under Manage public permissions you can grant read access to your objects to the general public (everyone in the world), for all of the files that you're uploading."

---

**_8. After launching an instance that you intend to serve as a NAT (Network Address Translation) device 
in a public subnet you modify your route tables to have the NAT device be the target of internet bound traffic of your private subnet. 
When you try and make an outbound connection to the Internet from an instance in the private subnet, you are not successful. 
Which of the following steps could resolve the issue?_**

- **Disabling the Source/Destination Check attribute on the NAT instance**
- Attaching an Elastic IP address to the instance in the private subnet
- Attaching a second Elastic Network Interface (ENI) to the instance in the private subnet, and placing it in the public subnet
- Attaching a second Elastic Network interface (ENI) to the NAT instance, and placing it in the private subnet

http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_NAT_Instance.html

Each EC2 instance performs source/destination checks by default. This means that the instance must be the source or destination of any traffic it sends or receives. 
However, a NAT instance must be able to send and receive traffic when the source or destination is not itself. 
Therefore, you must disable source/destination checks on the NAT instance.

---

**_9. A company has a workflow that sends video files from their on premise system to AWS for transcoding. 
They use EC2 worker instances that pull transcoding jobs from SQS. Why is SQS an appropriate service for this scenario?_**

- SQS checks the health of the worker instances.
- **SQS helps to facilitate horizontal scaling of encoding tasks.**
- SQS synchronously provides transcoding output.
- SQS guarantees the order of the messages.

http://docs.amazonaws.cn/en_us/AWSSimpleQueueService/latest/SQSDeveloperGuide/sqs-throughput-horizontal-scaling-and-batching.html

"Horizontal scaling means increasing the number of your message producers (making SendMessage requests) and consumers (making ReceiveMessage and DeleteMessage requests) in order to increase your overall queue throughput"

---

**_10. You are working with a customer who has 10 TB of archival data that they want to migrate to Amazon Glacier. 
The customer has a 1-Mbps connection to the Internet. Which service or feature provides the fastest method of getting the data into Amazon Glacier?_**

- Amazon Glacier multipart upload
- VM Import/Export
- AWS Storage Gateway
- **AWS Import/Export**

http://docs.aws.amazon.com/amazonglacier/latest/dev/uploading-an-archive.html

"To upload existing data to Amazon Glacier, you might consider using the AWS Import/Export service. 
AWS Import/Export accelerates moving large amounts of data into and out of AWS using portable storage devices for transport."

---

**_11. You are tasked with setting up a Linux bastion host for access to Amazon EC2 instances running in your VPC. 
Only clients connecting from the corporate external public IP address 72.34.51.100 should have SSH access to the host. 
Which option will meet the customer requirement??_**

- **Security Group Inbound Rule: Protocol – TCP. Port Range – 22, Source 72.34.51.100/32**
- Security Group Inbound Rule: Protocol – UDP, Port Range – 22, Source 72.34.51.100/32
- Network ACL Inbound Rule: Protocol – UDP, Port Range – 22, Source 72.34.51.100/32
- Network ACL Inbound Rule: Protocol – TCP, Port Range-22, Source 72.34.51.100/0

http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_SecurityGroups.html

"A security group acts as a virtual firewall for your instance to control inbound and outbound traffic. 
When you launch an instance in a VPC, you can assign up to five security groups to the instance. Security groups act at the instance level, not the subnet level. 
Therefore, each instance in a subnet in your VPC could be assigned to a different set of security groups. 
If you don't specify a particular group at launch time, the instance is automatically assigned to the default security group for the VPC."

---

**_12. You run an ad-supported photo sharing website using S3 to serve photos to visitors of your site. 
At some point you find out that other sites have been linking to the photos on your site, causing loss to your business. 
What is an effective method to mitigate this?_**

- Store photos on an EBS volume of the web server.
- Block the IPs of the offending websites in Security Groups.
- Use CloudFront distributions for static content.
- **Remove public read access and use signed URLs with expiry dates.**

"Signed URLs allow you to provide users access to your private content. 
A signed URL includes additional information (e.g., expiration time) that gives you more control over access to your content. 
This additional information appears in a policy statement, which is based on either a canned policy or a custom policy"
